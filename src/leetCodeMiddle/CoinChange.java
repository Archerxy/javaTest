package leetCodeMiddle;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
    	if(coins.length == 0) return -1;
    	if(amount == 0) return 0;
    	int minCoin = coins[0];
		for(int price: coins) {
			if(minCoin > price) {
				minCoin = price;
			}
		}
    	
    	int[] dp = new int[amount+1];
    	dp[0] = 0;
    	int n = 1;
    	int minVal = minCoin>amount+1?amount+1:minCoin;
    	for(; n < minVal; n++) {
    		dp[n] = -1;
    	}
		int minCost;
    	while(n<=amount) {
    		minCost = Integer.MAX_VALUE;
    		for(int price: coins) {
    			if(n >= price && dp[n-price] != -1) {
    				if(minCost > dp[n-price])
    					minCost = dp[n-price];
    			}
    		}
    		if(minCost < Integer.MAX_VALUE) {
    			dp[n] = minCost +1;
    		}else {
    			dp[n] = -1;
    		}
    		n++;
    	}
    	return dp[amount];
    }
    
//    [186,419,83,408]
//    6249
    public void test() {
    	int[] a = new int[] {186,419,83,408};
//    	int[] a = new int[] {8,2,17};
    	System.out.println(coinChange(a,6249));
    }
}
