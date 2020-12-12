package crypto;

import java.util.concurrent.atomic.AtomicLong;

public class CLGRandom {
	public CLGRandom() {
		seed = new AtomicLong(System.nanoTime()&0x36e216d71L);
	}
	static AtomicLong seed;
	
	double crand() {
		long oldSeed = seed.get();
		long newSeed = ((0x12b9b0a5L * oldSeed + 0x1b0c88a5L)&Long.MAX_VALUE) % (0x80000000L);
		seed.compareAndSet(oldSeed, newSeed);
		return newSeed / 0x1.0p31;
	}
	
	public int nextInt(int bound) {
		if(bound <= 0)
            throw new IllegalArgumentException("bound must be positive");
		return (int) (crand()*bound);
	}
	
	public double random() {
		return crand();
	}
}
