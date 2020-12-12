package sorts;

public class RadixSort implements Sort{
	private int[] b;
	@Override
	public void sort(int[] a) {
		b = new int[a.length];
		int[] barrel0 = new int[256],barrel1 = new int[256],barrel2 = new int[256],barrel3 = new int[256];
		for (int i = 0; i < a.length; i++)
		{	
	    	++barrel0[a[i]&0b11111111];
	    	++barrel1[(a[i]>>8)&0b11111111];
	    	++barrel2[(a[i]>>16)&0b11111111];
	    	++barrel3[a[i]>>24];
		}
		for(int i = 1; i < 256; i++) {
			barrel0[i] += barrel0[i-1];
			barrel1[i] += barrel1[i-1];
			barrel2[i] += barrel2[i-1];
			barrel3[i] += barrel3[i-1];
		}
		for(int i = a.length-1; i >= 0; i--) {
			b[--barrel0[a[i]&0b11111111]] = a[i];
		}
		for(int i = a.length-1; i >= 0; i--) {
			a[--barrel1[(b[i]>>8)&0b11111111]] = b[i];
		}
		for(int i = a.length-1; i >= 0; i--) {
			b[--barrel2[(a[i]>>16)&0b11111111]] = a[i];
		}
		for(int i = a.length-1; i >= 0; i--) {
			a[--barrel3[b[i]>>24]] = b[i];
		}
	}
}
