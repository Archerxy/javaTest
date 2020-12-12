package crypto;

import java.math.BigInteger;
import java.util.Random;

public class KeyPairs {
	BigInteger prime1 = new BigInteger("14732568541086397");
	BigInteger prime2 = new BigInteger("14732568541086271");
	BigInteger E = new BigInteger("31");
	BigInteger D = new BigInteger("14003133923729463378110178024704");
	BigInteger N = new BigInteger("217048575817806711825844841555587");
	BigInteger one = new BigInteger("1");
	BigInteger zero = new BigInteger("0");
	
	//D*E -1 = k*Yn  comsume d = 
	NED getNED(){
		BigInteger N = prime1.multiply(prime2);
		BigInteger inc = new BigInteger("2");
		BigInteger Yn = new BigInteger("217048575817806682360707759382920");
		while(Yn.multiply(inc).add(one).mod(E).compareTo(zero) == 0) {
			inc = inc.add(one);
		}
		BigInteger Big = Yn.multiply(inc).add(one);
		BigInteger D = Big.divide(E);

		System.out.println(inc.toString(10));
		System.out.println(Big.toString(10));
		System.out.println(D.toString(10));
		return new NED(null,null,null);
	}
	
	public void test() {
		getNED();
	}
	
	class NED {
		public NED(BigInteger N, BigInteger E, BigInteger D) {
			this.N = N;
			this.E = E;
			this.D = D;
		}
		public BigInteger N;
		public BigInteger E;
		public BigInteger D;
	}
}
