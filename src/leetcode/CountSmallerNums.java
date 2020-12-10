package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode: https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
public class CountSmallerNums {
    public List<Integer> countSmaller(int[] nums) {
    	//垃圾题目，非要用List作为返回值
    	List<Integer> returnData = new ArrayList<>(nums.length);
    	if(nums.length == 0) return returnData;
    	returnData.add(0);
    	for(int i = nums.length - 2; i >= 0; i--) {
    		int j = i+1;
    		for(; j < nums.length; j++) {
    			if(nums[j] >= nums[j-1]) {
    				nums[j-1] = nums[j]^nums[j-1];
    				nums[j] = nums[j]^nums[j-1];
    				nums[j-1] = nums[j]^nums[j-1];
    			}else {
    				break;
    			}
    		}
    		returnData.add(nums.length - j);
    	}
    	Collections.reverse(returnData);
    	return returnData;
    }
    
    public void test() {
    	List<Integer> res = countSmaller(new int[] {5,2,6,1,7});
    	for(int i = 0; i < res.size(); i++) {
    		System.out.print(res.get(i)+" ");
    	}
    }
}
