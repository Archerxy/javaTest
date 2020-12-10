package leetcode;

public class StoneGame {
    public boolean winnerSquareGame(int n) {
        if(canDevided(n))
            return true;
        boolean[] dp = new boolean[n+1];
        dp[1] = true;
        for(int i = 2; i <= n; ++i){
            if(canDevided(i)){
                dp[i] = true;
                continue;
            }
            int k = 1;
            for(int j = 1; j <= i; j = k*k){
                if(!dp[i-j]){
                    dp[i] = true;
                    break;
                }
                ++k;
            }
        }
        return dp[n];
    }
    
    boolean canDevided(int n){
        int d = (int)Math.sqrt(n);
        if(d*d == n)
            return true;
        return false;
    }
    
    public void test() {
    	System.out.print(winnerSquareGame(46));
    }
}
