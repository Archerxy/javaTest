package sorts;

import java.util.Arrays;
import java.util.Random;

public class SortCompare {
	public static void showSortOutput() {
		int len = 2000000;
		int[] a1 = new int[len];
		int[] a2 = new int[len];
		int[] a3 = new int[len];
		int[] a4 = new int[len];
		Random r = new Random();
		for(int i = 0; i < len; ++i) {
			int n = r.nextInt(len);
			a1[i] = n;
			a2[i] = n;
			a3[i] = n;
			a4[i] = n;
		}
		
		HeapSort2 hs2 = new HeapSort2();
		MergeSort ms = new MergeSort();
		HeapSort hs = new HeapSort();
		
		long t1 = System.currentTimeMillis();
		hs2.sort(a1);
		long t2 = System.currentTimeMillis();
		ms.sort(a2);
		long t3 = System.currentTimeMillis();
		hs.sort(a3);
		long t4 = System.currentTimeMillis();
		Arrays.sort(a4);
		long t5 = System.currentTimeMillis();
		
		
		
		System.out.println("heapSort2 cost: "+(t2-t1));
		for(int i = 0; i < (len>20?20:len); ++i)
			System.out.print(a1[i]+" ");
		System.out.println(" ");
		
		System.out.println("mergeSort cost: "+(t3-t2));
		for(int i = 0; i < (len>20?20:len); ++i)
			System.out.print(a2[i]+" ");
		System.out.println(" ");
		
		System.out.println("heapSort cost: "+(t4-t3));
		for(int i = 0; i < (len>20?20:len); ++i)
			System.out.print(a3[i]+" ");
		System.out.println(" ");
		
		System.out.println("ori: "+(t5-t4));
		for(int i = 0; i < (len>20?20:len); ++i)
			System.out.print(a4[i]+" ");
		System.out.println(" ");
		
	}
}
