package crypto;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class RandomNum {
	static final AtomicLong seedUniquifier
    = new AtomicLong(8682522807148012L);
	
	static long seedUniquifier() {
        for (;;) {
            long current = seedUniquifier.get();
            long next = current * 181783497276652981L;
            if (seedUniquifier.compareAndSet(current, next))
                return next;
        }
    }

    static final long multiplier = 0x5DEECE66DL;
    static final long addend = 0xBL;
    static final long mask = (1L << 48) - 1;

    public int nextInt(int bound) {
        if (bound <= 0)
            throw new IllegalArgumentException("bound must be positive");

        int r = next(31);
        int m = bound - 1;
        if ((bound & m) == 0)  // i.e., bound is a power of 2
            r = (int)((bound * (long)r) >> 31);
        else {
            for (int u = r;
                 u - (r = u % bound) + m < 0;
                 u = next(31));
        }
        return r;
    }
    

    protected int next(int bits) {
    	
        long oldseed, nextseed;
        AtomicLong seed = new AtomicLong(((seedUniquifier() ^ System.nanoTime())^ multiplier) & mask);
        do {
            oldseed = seed.get();
            nextseed = (oldseed * multiplier + addend) & mask;
        } while (!seed.compareAndSet(oldseed, nextseed));
        return (int)(nextseed >>> (48 - bits));
    }
}
