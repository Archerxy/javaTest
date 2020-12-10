package leetcode;
import java.util.*;

public class EatApples2 {
    Map<Integer, Integer> map = new HashMap<>();
    
    public int minDays(int n) {
        if(n == 0)
            return 0;
        if(!map.containsKey(n)){
            int ans = n;
            ans = Math.min(ans, minDays(n/2) + 1 + n%2);
            ans = Math.min(ans, minDays(n/3) + 1 + n%3);
            map.put(n, ans);
        }
        return map.get(n);
    }
    
    public void test() {
    	int res = minDays(9);
    	System.out.println(res);
    }
}
