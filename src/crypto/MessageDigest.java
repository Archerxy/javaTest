package crypto;
/*
 * Copyright (c) 1996, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

import java.util.*;
import java.lang.*;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

import sun.security.jca.GetInstance;
import sun.security.util.Debug;

public abstract class MessageDigest extends MessageDigestSpi {

    private static final Debug pdebug =
                        Debug.getInstance("provider", "Provider");
    private static final boolean skipDebug =
        Debug.isOn("engine=") && !Debug.isOn("messagedigest");

    private String algorithm;

    // The state of this digest
    private static final int INITIAL = 0;
    private static final int IN_PROGRESS = 1;
    private int state = INITIAL;

    // The provider
    private Provider provider;

    protected MessageDigest(String algorithm) {
        this.algorithm = algorithm;
    }

    public static MessageDigest getInstance(String algorithm)
    throws NoSuchAlgorithmException, ClassNotFoundException {
        MessageDigest md;
		Class<?> clazz = Class.forName("java.security.MessageDigestSpi");
		Object[] objs = GetInstance.getInstance
		                ("MessageDigest", clazz, algorithm).toArray();
		if (objs[0] instanceof MessageDigest) {
		    md = (MessageDigest)objs[0];
		} else {
		    md = new Delegate((MessageDigestSpi)objs[0], algorithm);
		}
		md.provider = (Provider)objs[1];

		if (!skipDebug && pdebug != null) {
		    pdebug.println("MessageDigest." + algorithm +
		        " algorithm from: " + md.provider.getName());
		}

		return md;
    }

//    public static MessageDigest getInstance(String algorithm, String provider)
//        throws NoSuchAlgorithmException, NoSuchProviderException
//    {
//        if (provider == null || provider.length() == 0)
//            throw new IllegalArgumentException("missing provider");
//        Object[] objs = Security.getImpl(algorithm, "MessageDigest", provider);
//        if (objs[0] instanceof MessageDigest) {
//            MessageDigest md = (MessageDigest)objs[0];
//            md.provider = (Provider)objs[1];
//            return md;
//        } else {
//            MessageDigest delegate =
//                new Delegate((MessageDigestSpi)objs[0], algorithm);
//            delegate.provider = (Provider)objs[1];
//            return delegate;
//        }
//    }

//    public static MessageDigest getInstance(String algorithm,
//                                            Provider provider)
//        throws NoSuchAlgorithmException
//    {
//        if (provider == null)
//            throw new IllegalArgumentException("missing provider");
//        Object[] objs = Security.getImpl(algorithm, "MessageDigest", provider);
//        if (objs[0] instanceof MessageDigest) {
//            MessageDigest md = (MessageDigest)objs[0];
//            md.provider = (Provider)objs[1];
//            return md;
//        } else {
//            MessageDigest delegate =
//                new Delegate((MessageDigestSpi)objs[0], algorithm);
//            delegate.provider = (Provider)objs[1];
//            return delegate;
//        }
//    }

    public final Provider getProvider() {
        return this.provider;
    }

    public void update(byte input) {
        engineUpdate(input);
        state = IN_PROGRESS;
    }

    public void update(byte[] input, int offset, int len) {
        if (input == null) {
            throw new IllegalArgumentException("No input buffer given");
        }
        if (input.length - offset < len) {
            throw new IllegalArgumentException("Input buffer too short");
        }
        engineUpdate(input, offset, len);
        state = IN_PROGRESS;
    }

    public void update(byte[] input) {
        engineUpdate(input, 0, input.length);
        state = IN_PROGRESS;
    }

    public final void update(ByteBuffer input) {
        if (input == null) {
            throw new NullPointerException();
        }
        engineUpdate(input);
        state = IN_PROGRESS;
    }

    public byte[] digest() {
        /* Resetting is the responsibility of implementors. */
        byte[] result = engineDigest();
        state = INITIAL;
        return result;
    }

    public int digest(byte[] buf, int offset, int len) throws DigestException {
        if (buf == null) {
            throw new IllegalArgumentException("No output buffer given");
        }
        if (buf.length - offset < len) {
            throw new IllegalArgumentException
                ("Output buffer too small for specified offset and length");
        }
        int numBytes = engineDigest(buf, offset, len);
        state = INITIAL;
        return numBytes;
    }

    public byte[] digest(byte[] input) {
        update(input);
        return digest();
    }

    public String toString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(baos);
        p.print(algorithm+" Message Digest from "+provider.getName()+", ");
        switch (state) {
        case INITIAL:
            p.print("<initialized>");
            break;
        case IN_PROGRESS:
            p.print("<in progress>");
            break;
        }
        p.println();
        return (baos.toString());
    }

    public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta == digestb) return true;
        if (digesta == null || digestb == null) {
            return false;
        }
        if (digesta.length != digestb.length) {
            return false;
        }

        int result = 0;
        // time-constant comparison
        for (int i = 0; i < digesta.length; i++) {
            result |= digesta[i] ^ digestb[i];
        }
        return result == 0;
    }

    public void reset() {
        engineReset();
        state = INITIAL;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final int getDigestLength() {
        int digestLen = engineGetDigestLength();
        if (digestLen == 0) {
            try {
                MessageDigest md = (MessageDigest)clone();
                byte[] digest = md.digest();
                return digest.length;
            } catch (CloneNotSupportedException e) {
                return digestLen;
            }
        }
        return digestLen;
    }

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        } else {
            throw new CloneNotSupportedException();
        }
    }

    static class Delegate extends MessageDigest {

        // The provider implementation (delegate)
        private MessageDigestSpi digestSpi;

        // constructor
        public Delegate(MessageDigestSpi digestSpi, String algorithm) {
            super(algorithm);
            this.digestSpi = digestSpi;
        }

//        public Object clone() throws CloneNotSupportedException {
//            if (digestSpi instanceof Cloneable) {
//                MessageDigestSpi digestSpiClone =
//                    (MessageDigestSpi)digestSpi.clone();
//                // Because 'algorithm', 'provider', and 'state' are private
//                // members of our supertype, we must perform a cast to
//                // access them.
//                MessageDigest that =
//                    new Delegate(digestSpiClone,
//                                 ((MessageDigest)this).algorithm);
//                that.provider = ((MessageDigest)this).provider;
//                that.state = ((MessageDigest)this).state;
//                return that;
//            } else {
//                throw new CloneNotSupportedException();
//            }
//        }
//
        protected int engineGetDigestLength() {
            return 0;
        }

        protected void engineUpdate(byte input) {
            
        }

        protected void engineUpdate(byte[] input, int offset, int len) {
            
        }

        protected void engineUpdate(ByteBuffer input) {
            
        }

        protected byte[] engineDigest() {
            return null;
        }

        protected int engineDigest(byte[] buf, int offset, int len)
            throws DigestException {
                return 0;
        }

        protected void engineReset() {
            
        }
    }
}
