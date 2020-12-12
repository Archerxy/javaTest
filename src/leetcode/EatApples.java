package leetcode;
import java.util.*;

public class EatApples {
    int daysInUse = Integer.MAX_VALUE;
    Map<Integer,Integer> map = new HashMap<>();
    
    public int minDays(int n) {
         eat(n,0,0);
         return daysInUse;
    }
    
    void eat(int remain, int days, int lastIsOne){
        if(remain == 0){
            if(days < daysInUse)
                daysInUse = days;
            return ;
        }
        if(map.containsKey(remain)) {
            if(days+map.get(remain) < daysInUse)
                daysInUse = days+map.get(remain);
            return ;
        }
        if(remain%3==0)
            eat(remain/3, days+1, 0);
        if(remain%2==0)
            eat(remain/2, days+1,0);
        if(lastIsOne>=2)
        	return ;
        eat(remain - 1,days+1,lastIsOne+1);
    }
    
    public void test() {
    	System.out.println(minDays(5126970));
    }
}

//11
