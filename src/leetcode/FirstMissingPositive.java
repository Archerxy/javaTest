package leetcode;


//leetcode  https://leetcode-cn.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	if(nums.length == 0) return 1;
    	boolean[] barrel = new boolean[nums.length+1];
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] > 0 && nums[i] <= nums.length) {
    			barrel[nums[i]] = true;
    		}
    	}
    	for(int i = 1; i < barrel.length; i++) {
    		if(!barrel[i]) return i;
    	}
    	return barrel.length;
    }
    
    public void test() {
    	int range = 24;
    	int[] a = new int[range];
    	for(int i = 0 ; i < range; i++) {
    		if(i == 256*256+256*256+2) continue;
    		else a[i] = i+2;
    	}
    	System.out.println(firstMissingPositive(a));
    }
    
    /* old version
    public int firstMissingPositive(int[] nums) {
    	if(nums.length == 0) return 1;
    	int[] bit00 = new int[65536];
    	int[] bit10 = new int[65536], bit11 = new int[65536];
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] > 0) {
    			if(nums[i] < 256*256) {
    				bit00[nums[i]]++;
    			}else if(nums[i] <= 256*256*256*128-1) {
    				bit10[nums[i]&0b1111111111111111]++;
    				bit11[(nums[i]>>16)]++;
    			}
    		}
    	}
    	int bit0to16 = 0,bit16to32l = 0, bit16to32h = 0;
    	for(int i = 1; i < 65536; i++) {
    		if(bit00[i] == 0) return i;
    		if(bit10[i] == 0 && bit0to16 == 0) bit0to16 = i;
    		if(bit10[i] < 256 && bit16to32l == 0) bit16to32l = i;
    		if(bit11[i] < 256 && bit16to32h == 0) bit16to32h = i;
    	}
    	
    	if(bit0to16 > 0) return 256*256+bit0to16;
    	if(bit16to32l > 0) return 256*256+bit16to32l;
    	return 0;
    } 
     * */
}
