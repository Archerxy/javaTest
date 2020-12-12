package leetcode;

import java.util.*;

public class MaxMinDistance {
	public int maxDistance(int[] xs, int m) {
	    Arrays.sort(xs);
	    int l = 0;
	    int r = inf;
	    while(l < r){
	        int k = (l + r + 1) / 2;
	        if(check(xs, m, k)){
	            l = k;
	        }else{
	            r = k - 1;
	        }
	    }
	    return l;
	}
	
	int inf = (int)1e9;
	boolean check(int[] xs, int m, int k){
	    int last = -inf;
	    for(int x : xs){
	        if(x - last >= k){
	            m--;
	            last = x;
	        }
	    }
	    return m <= 0;
	}
	
	public void test() {
		int[] a = new int[] {1,2,5,7,999};
		System.out.println(maxDistance(a,3));
	}
}
