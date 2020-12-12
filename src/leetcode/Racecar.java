package leetcode;

public class Racecar {
    public int racecar(int target) {
        int n = 0, s = 1, steps = 0;
        while(n+s<=target){
        	++steps;
            n += s;
            s*=2;
        }
        if(target == n)
            return steps;
        int right = (n+s)-target, left = target-n;
        return steps+Math.min(racecar(left)+2,racecar(right)+2);
    }
    
    public void test() {
    	System.out.println(racecar(9999));
    }
}
