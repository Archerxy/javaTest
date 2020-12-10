package leetCodeMiddle;

public class FairArray {
	public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        if(n == 1)
        	return 1;
        if(n == 2)
        	return 0;
        int[] oddSum = new int[n/2];
        int[] evenSum = new int[(n+1)/2];
        
        oddSum[0] = nums[1];
        evenSum[0] = nums[0];
        
        for(int i = 2; i < n; ++i) {
        	if(i%2 == 0) {
        		evenSum[i>>1] = evenSum[(i>>1)-1] + nums[i];
        	} else {
        		oddSum[(i-1)>>1] = oddSum[((i-1)>>1)-1] + nums[i];
        	}
        }
        int ans = 0;
        if(evenSum[(n+1)/2-1] - evenSum[0] == oddSum[n/2-1])
        	++ans;
        if(oddSum[n/2-1]-oddSum[0] + evenSum[0] == evenSum[(n+1)/2-1] - evenSum[0])
        	++ans;
        
        for(int i = 2; i < n; ++i) {
        	if(i % 2 == 0) {
        		int sumEven = evenSum[(i>>1)-1]+oddSum[n/2-1]-oddSum[(i>>1)-1];
        		int sumOdd = oddSum[(i>>1)-1]+evenSum[(n+1)/2-1]-evenSum[(i>>1)];
        		if(sumEven == sumOdd)
        			++ans;
        	} else {
        		int sumEven = evenSum[(i>>1)]+oddSum[n/2-1]-oddSum[(i>>1)];
        		int sumOdd = oddSum[(i>>1)-1]+evenSum[(n+1)/2-1]-evenSum[(i>>1)];
        		if(sumEven == sumOdd)
        			++ans;
        	}
        }
        return ans;
    }
	
	public void test() {
		System.out.println(waysToMakeFair(new int[] {2,1,6,4}));
	}
}
