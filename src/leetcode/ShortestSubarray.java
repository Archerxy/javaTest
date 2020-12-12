package leetcode;

import java.util.LinkedList;

//leetcode  https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
public class ShortestSubarray {

	private int[] A;
	private int[] sumS;
	private int[] sumE;
	
    public int shortestSubarray(int[] A, int K) {
    	if(A.length == 0) return -1;
    	this.A = A;
    	sumS = new int[A.length + 1];
    	sumE = new int[A.length + 1];
    	int maxSum = A[0], s = 0 ,e = A.length-1;
    	for(int i = 0; i < A.length; i++) {
    		sumS[i + 1] = sumS[i] + A[i];
    		sumE[A.length - i - 1] = sumE[A.length - i] + A[A.length - i - 1];
    		
    		if(sumS[i+1] > maxSum) {
    			e = i;
    			maxSum = sumS[i + 1];
    		}
    	}
    	maxSum = A[e];
    	for(int i = e; i>= 0; i--) {
    		if((sumE[i] - sumE[e+1])> maxSum) {
    			s = i;
    			maxSum = (sumE[i] - sumE[e+1]);
    		}
    	}
    	
    	if(sumS[e+1] - sumS[s] < K) return -1;
    	
    	int res = 1;
    	for(int i = s; i <= e; i++) {
    		if(sumS[e+1] - sumS[i] < K) {
    			res = e + 1 - i + 1;
    			break;
    		}
    	}
    	for(int i = e; i >= s; i--) {
    		if(sumE[s] - sumE[i+1] < K) {
    			if(i + 1 - s + 1 < res)
    				res = i + 1 - s + 1;
    			break;
    		}
    	}
    	return res;
    }
    
    public void test() {
    	int[] A = new int[] {2,-1,2,-12,5,-2,21,3,-1,3};
    	System.out.println(shortestSubarray(A,24));
    }    
}
