package leetCodeMiddle;
import java.util.*;

//https://leetcode-cn.com/problems/132-pattern/submissions/
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        if(nums.length == 3) return nums[0]<nums[2]&&nums[2]<nums[1];
        int[] minNum = new int[nums.length];
        minNum[1] = nums[0];
        List<Integer> list = new LinkedList<>();

        //minNum = min{nums[0],...,nums[i-1]}
        for(int i = 2; i < nums.length; i++){
            minNum[i] = Math.min(minNum[i-1], nums[i-1]);
        }
        for(int i = nums.length-1; i >=1 ; i--){
        	list.add(nums[i]);
        	while(!list.isEmpty() && list.get(list.size()-1) <= minNum[i]) {
        		list.remove(list.size()-1);
        	}
        	if(!list.isEmpty() && list.get(list.size()-1) < nums[i-1])
        		return true;
        }
        return false;
    }
    
    public void test() {
//    	int[] a = new int[] {5,3,0,3,4}; //0,3,3,0,0
    	int[] a = new int[] {4,1,3,2};
//    	int[] a = new int[] {0,1,1,0,1,1,0,1,1,1,0};
//    	int[] a = new int[15000];
//    	for(int i = -5000; i < 10000; i++) {
//    		a[i+5000] = (new Random()).nextInt(2);
//    	}
//    	System.out.println(a[0]+","+a[1]+","+a[2]+","+a[3]);
    	long s = System.currentTimeMillis();
    	System.out.println(find132pattern(a));
    	System.out.println(System.currentTimeMillis()-s);
    }
}
