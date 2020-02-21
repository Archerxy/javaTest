package sorts;

public class O2Sort implements Sort{
	@Override
	public void sort(int[] a) {
		int len = a.length;
		int[] b = new int[4 * len];
		int[] sum0 = new int[256], sum1 = new int[256], sum2 = new int[256], sum3 = new int[256];
		for (int i = 0; i < len; i++)
		{
		    ++sum0[a[i] & 0b11111111];
		    ++sum1[(a[i] >> 8) & 0b11111111];
		    ++sum2[(a[i] >> 16) & 0b11111111];
		    ++sum3[a[i] >> 24];
		}
		for (int q = 1; q <= 255; ++q)
		{
		    sum0[q] += sum0[q - 1];
		    sum1[q] += sum1[q - 1];
		    sum2[q] += sum2[q - 1]; 
		    sum3[q] += sum3[q - 1];
		}
		for (int q = len - 1; q >= 0; --q)
		    b[--sum0[a[q] & 0b11111111]] = a[q];
		for (int q = len - 1; q >= 0; --q)
		    a[--sum1[(b[q] >> 8) & 0b11111111]] = b[q];
		for (int q = len - 1; q >= 0; --q)
		    b[--sum2[(a[q] >> 16) & 0b11111111]] = a[q];
		for (int q = len - 1; q >= 0; --q)
		    a[--sum3[b[q] >> 24]] = b[q];
	}
}
