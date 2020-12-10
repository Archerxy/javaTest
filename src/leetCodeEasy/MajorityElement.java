package leetCodeEasy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length <= 2) return nums[0];
        int res = nums[0],count = 0;
        int l = nums.length/3;
        for(int i = 0; i < l; i++){
            if(res == nums[i]){
                count++;
            }else{
                if(count> 0)count--;
                if(count == 0){
                    res = nums[i];
                    count++;
                }
            }

            if(res == nums[l+i]){
                count++;
            }else{
            	if(count> 0)count--;
                if(count == 0){
                    res = nums[l+i];
                    count++;
                }
            }
            if(res == nums[2*l+i]){
                count++;
            }else{
            	if(count> 0)count--;
                if(count == 0){
                    res = nums[2*l+i];
                    count++;
                }
            }
        }
        if(nums.length%3 == 2){
            if(res == nums[3*l]){
                count++;
            }else{
            	if(count> 0)count--;
                if(count == 0){
                    res = nums[3*l];
                    count++;
                }
            }
            if(res != nums[3*l+1]){
            	if(count> 0)count--;
                if(count == 0){
                    res = nums[3*l+1];
                }
            }
        }
        if(nums.length%3 == 1){
            if(res != nums[3*l]){
            	if(count> 0)count--;
                if(count == 0){
                    res = nums[3*l];
                }
            }
        }
        return res;
    }
}
