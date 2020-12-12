package OtherTopic;

import java.util.*;
public class CommonNumberInSortedArray {
	//输入，第一维为数组的数量，第二维为无重复有序数组，nums不为null
	public List<Integer> commonNumberInSortedArray(int[][] nums) {
		LinkedList<Integer> ans = new LinkedList<>();
		for(int target: nums[0]) {
			boolean flag = true;
			for(int l = 1; l < nums.length; ++l) {
				if(!binarySearch(nums[l], target, 0, nums[l].length-1)) {
					flag = false;
					break;
				}
			}
			if(flag)
				ans.add(target);
		}
		return ans;
	}
	boolean binarySearch(int[] nums, int target, int s, int e) {
		if(nums[s] == target || nums[e] == target)
			return true;
		if(s >= e-1)
			return false;
		if(nums[(s+e)/2] > target)
			return binarySearch(nums, target, s, (s+e)/2);
		return binarySearch(nums, target, (s+e)/2, e);
	}
	
	
	//测试
	public void test() {
		int[][] a = new int[][] {{0,2,8,10,18},
								 {2,7,8,11,25},
								 {0,2,5,8,10,20},
								 {-12,-9,2,8,13},
								 {-9,-3,2,8,18}};
		List<Integer> r = commonNumberInSortedArray(a);
		Integer[] print = new Integer[r.size()];
		r.toArray(print);
		System.out.println(Arrays.toString(print));
	}
}
