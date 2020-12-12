package leetcode;

public class JumpGame {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int end = nums.length-1, s = 0;
        int steps = 0;
        while(s <= end){
            if(nums[s] >= end-s){
                ++steps;
                if(s == 0)
                    return steps;
                end = s;
                s = -1;
            }
            ++s;
        }
        return 0;
    }
    
    public void test() {
    	int[] a= new int[] {2,3,1,1,4};
    	System.out.println(jump(a));
    }
}
