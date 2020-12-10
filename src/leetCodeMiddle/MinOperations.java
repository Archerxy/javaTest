package leetCodeMiddle;
import java.util.*;

public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length, numsSum = 0;
        int ans = n+1;
        int l = 0,r = 0;
        while(l < n){
            while(sum-numsSum < x && l <= r) 
                numsSum -= nums[l++];
            if(sum-numsSum == x)
                ans = Math.min(ans,n-r+l);
            if(r < n) 
            	numsSum += nums[r++];
            else
                numsSum -= nums[l++];
        }
        return ans==n+1?-1:ans;
    }
    
    public void test() {
    	System.out.println(minOperations(new int[] {3,2,20,1,1,3},25));
    }
}
