package main;

import java.util.Arrays;
import java.util.Random;

import sorts.BubbleSort;
import sorts.InsertSort;
import sorts.MergeSort;
import sorts.MergeSort2;
import sorts.O2Sort;
import sorts.QuickSort;
import sorts.ShellSort;
import sorts.Sort;

public class Entrance {

	public static void main(String[] args) {
		Random r  = new Random();
		int len = 10000000,range = 10000000;
		int[] a1 = new int[len],a2 = new int[len],a3 = new int[len],a4 = new int[len],a5 = new int[len];
		for(int i = 0; i < len; i++){
		    int num = r.nextInt(range);
		    a1[i] = num;
		    a2[i] = num;
		    a3[i] = num;
		    a4[i] = num;
		    a5[i] = num;
		}
		
		System.out.println("原数组");
		System.out.println(a1[0]+" "+a1[1]+" "+a1[2]+" "+a1[3]+" "+a1[4]+" "+a1[5]);
		
		long t1 = System.currentTimeMillis();
		Arrays.sort(a1);
		long t2 = System.currentTimeMillis();
		System.out.println("原生耗时："+(t2-t1)+"\n");
		

		O2Sort O2 = new O2Sort();
		MergeSort merge = new MergeSort();
		QuickSort quick = new QuickSort();
		ShellSort shell = new ShellSort();
		MergeSort2 mergeOnWeb = new MergeSort2();
		
		showOutput(O2,a2,"O2");

		showOutput(quick,a3,"快排");

		showOutput(mergeOnWeb,a4,"网上并归");
		
		showOutput(merge,a5,"并归");
	}
	
	private static void showOutput(Sort sortMethod,int[] a,String method) {
		long t1 = System.currentTimeMillis();
		sortMethod.sort(a);
		long t2 = System.currentTimeMillis();
		int len = (a.length < 10)?a.length:10;
		System.out.println(method+"耗时："+(t2-t1));
		
		for(int i = 0; i< len; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("");
	}
}
