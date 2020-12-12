package leetCodeMiddle;

import java.util.*;

public class MaxPositive {
    public int getMaxLen(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int count = 0, ans = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                l.add(count);
                count = 0;
                if(l.size() > 0){
                    int tmp = 0;
                	if(l.size()%2==1) {
                        for(int j = 0; j < l.size(); ++j){
                            tmp += l.get(j)+1;
                        }
                        ans = Math.max(ans,tmp-1);
                	} else {
                        for(int j = 0; j < l.size(); ++j){
                            tmp += l.get(j)+1;
                        }
                        ans = Math.max(ans,tmp-2-l.get(0));
                        ans = Math.max(ans,tmp-2-l.get(l.size()-1));
                	}
                }
                l = new ArrayList<>();
                continue;
            } 
            if(nums[i] < 0){
                l.add(count);
                count = 0;
                continue;
            }
            ++count;
        }
        l.add(count);
        if(l.size() > 0){
            int tmp = 0;
        	if(l.size()%2==1) {
                for(int j = 0; j < l.size(); ++j){
                    tmp += l.get(j)+1;
                }
                ans = Math.max(ans,tmp-1);
        	} else {
                for(int j = 0; j < l.size(); ++j){
                    tmp += l.get(j)+1;
                }
                ans = Math.max(ans,tmp-2-l.get(0));
                ans = Math.max(ans,tmp-2-l.get(l.size()-1));
        	}
        }
        return ans;
    }
    
    public void  test() {
    	int[] a = new int[] {1,2,3,5,-6,4,0,10};
    	System.out.println(getMaxLen(a));
    }
}
