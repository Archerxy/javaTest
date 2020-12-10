package leetCodeMiddle;

import java.util.*;

public class MaxUnrepeatStr {
    int ans = 0;
    Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
    	searchBack(s,0,0);
    	return ans;
    }
    void searchBack(String s, int b, int size) {
    	if(size + s.length()-b < ans)
    		return ;
    	if(b >= s.length()) 
    		ans = Math.max(ans,size);
    	for(int i = b+1; i <= s.length(); ++i) {
    		String tmp = s.substring(b,i);
    		if(!set.contains(tmp)) {
    			set.add(tmp);
    			searchBack(s,i,size+1);
    			set.remove(tmp);
    		}
    	}
    }
    
    public void test() {
    	String a = "addadddadddd";
    	System.out.println(maxUniqueSplit(a));
    }
}
