package sorts;

import java.util.Arrays;

public class HeapSort2 implements Sort {
	public void sort(int[] nums) {
		for(int i = nums.length/2; i >= 0; --i)
			maxHeap(nums, i, nums.length);
		int end = nums.length-1;
		while(end > 0) {
			nums[0] = nums[0]^nums[end];
			nums[end] = nums[0]^nums[end];
			nums[0] = nums[0]^nums[end];
			maxHeap(nums,0, end);
			--end;
		}
	}
	void maxHeap(int[] nums, int p, int end) {
		int left = 2*p+1, right = 2*p+2, max = p;
		if(left < end && nums[max] < nums[left])
			max = left;
		if(right < end && nums[max] < nums[right])
			max = right;
		if(max > p) {
			nums[p] = nums[p]^nums[max];
			nums[max] = nums[p]^nums[max];
			nums[p] = nums[p]^nums[max];
			maxHeap(nums, max, end);
		}
	}
}
