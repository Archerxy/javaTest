package leetCodeMiddle;
import java.util.*;

public class SumAllArray {
	public int rangeSum(int[] nums, int n, int left, int right) {
	    long ans = 0l;
	    int[] sum = new int[n];
	    sum[0] = nums[0];
	    for(int i = 1; i < n; ++i){
	        sum[i] = sum[i-1] + nums[i];
	    }
	    
	    long[] arr = new long[n*(n+1)/2];
	    int l = 0, r = 0, i = 0;
	    while(r < n){
	        l = 0;
	        while(l <= r){
	            arr[i++] = (long)sum[r] - (long)sum[l] + (long)nums[l]; 
	            ans += arr[i-1];
	            ++l;
	        }
	        ++r;
	    }
	    Arrays.sort(arr);
	    for(i = 0; i < left-1; ++i){
	        ans -= arr[i];
	    }
	    for(i = right; i < arr.length; ++i){
	        ans -= arr[i];
	    }
	    return (int)(ans%100000007l);
	}
	
	public void test() {
		int[] a = new int[] {1,2,3,4};
		System.out.println(rangeSum(a,4,1,4));
	}
}
