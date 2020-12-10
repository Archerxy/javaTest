package crypto;

import java.util.concurrent.atomic.AtomicLong;

public class CLGRandom {
	public CLGRandom() {
		seed = new AtomicLong(System.nanoTime()&0x36e216d71L);
	}
	static AtomicLong seed;
	
	double crand() {
		long oldSeed = seed.get();
		long newSeed = ((314159269L * oldSeed + 453806245L)&Long.MAX_VALUE) % (2147483648L);
		seed.compareAndSet(oldSeed, newSeed);
		return((double)newSeed / 2147483648.0);
	}
	
	public int nextInt(int bound) {
		if(bound <= 0)
            throw new IllegalArgumentException("bound must be positive");
		return (int) Math.floor(crand()*bound);
	}
}
