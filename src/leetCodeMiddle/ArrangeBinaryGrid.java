package leetCodeMiddle;

import java.util.*;

public class ArrangeBinaryGrid {
    public int minSwaps(int[][] g) {
        int[] sum = new int[g.length];
        for(int i = 0; i < g.length; ++i){
            int s = 0;
            for(int j = 0; j < g.length; ++j){
                if(g[i][j] == 1)
                    s = j;
            }
            sum[i] = s;
        }
        System.out.println(Arrays.toString(sum));
        int ans = 0;
        for(int i = 0; i < sum.length; ++i){
            if(sum[i] <= i){
                continue;
            } else {
                int j = i+1;
                for(; j < sum.length; ++j){
                    if(sum[j] <= i){
                        for(int k = i; k < j; ++k){
                            int tmp = sum[k];
                            sum[k] = sum[k+1];
                            sum[k+1] = tmp;
                        }
                        ans += j-i;
                        break;
                    }
                }
                if(j == sum.length)
                    return -1;
            }
        }
        return ans;
    }
    
    public void test () {
    	int[][] g = new int[][] {{1,0,0,0,0,0},{0,1,0,1,0,0},{1,0,0,0,0,0},{1,1,1,0,0,0},{1,1,0,1,0,0},{1,0,0,0,0,0}};;
    	System.out.println(minSwaps(g));
    }
}
