package leetcode;

//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/submissions/

public class ReversePairs {
    private int[] nums;
    private int count;
    public int reversePairs(int[] nums) {
        if(nums.length <= 1)
            return 0;
        if(nums.length == 2)
            return nums[1]<nums[0]?1:0;
        this.nums = nums;
        count = 0;
        mergeSort(0,(nums.length-1)/2, nums.length-1);
        return count;
    }

    private void mergeSort(int l, int m, int r){
        if(r - l <= 1){
            if(nums[l] > nums[r]){
                count += 1;
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
            return;
        }
        mergeSort(l,(l+m)/2,m);
        mergeSort(m+1, (m+1+r)/2,r);

        int[] tmp = new int[r-l+1];
        int lIndex = l,rIndex = m+1,i = 0;
        while(lIndex <= m && rIndex <= r){
            if(nums[lIndex] <= nums[rIndex]) {
                tmp[i++] = nums[lIndex];
                ++lIndex;
                continue;
            }
            if(nums[lIndex] > nums[rIndex]){
                tmp[i++] = nums[rIndex];
                ++rIndex;
                count += (m-lIndex+1);
                continue;
            }
        }
        while(lIndex <= m){
            tmp[i++] = nums[lIndex];
            ++lIndex;
        }
        while(rIndex <= r){
            tmp[i++] = nums[rIndex];
            ++rIndex;
        }
        i = -1;
        while((++i) < r-l+1){
            nums[l+i] = tmp[i];
        }
    }
    
    public void test() {
    	int[] a = new int[] {7,5,6,4,0,5,1};
    	System.out.println(reversePairs(a));
    }
}
