package leetCodeMiddle;

public class LonggestIncreaseSeq {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
        	dp[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(nums[j] < nums[i]) {
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}
        	}
        }
        int res = 1;
        for(int l: dp) {
        	if(l > res) res = l;
        }
        return res;
    }
    
    public void test() {
    	int[] a = new int[] {4,10,4,3,8,9};
    	System.out.println(lengthOfLIS(a));
    }
}
