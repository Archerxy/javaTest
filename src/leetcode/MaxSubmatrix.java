package leetcode;

import java.util.*;

public class MaxSubmatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int[][] sum = new int[matrix.length][matrix[0].length+1];
        for(int i = 0; i < sum.length; i++){
            for(int j = 1; j < sum[0].length; j++){
                sum[i][j] = sum[i][j-1]+matrix[i][j-1];
            }
        }


        int max = Integer.MIN_VALUE;
        int[] arr = new int[sum.length];
        int[] lineSum = new int[sum.length+1];
        for(int j = 1; j < sum[0].length; j++){
            for(int k = 0; k < j; k++){
                for(int i = 0; i < sum.length; i++){
                    arr[i] = sum[i][j] - sum[i][k];
                }
                //求arr的最大连续子序列之和
                for(int i = 1; i < lineSum.length; i++){
                    lineSum[i] = lineSum[i-1] + arr[i-1];
                }
                int min = 0, minX = 0;
                for(int i = 1; i < lineSum.length; i++){
                    if(max < lineSum[i] - min){
                        max = lineSum[i] - min;
                        ans[0] = minX;
                        ans[1] = k;
                        ans[2] = i-1;
                        ans[3] = j-1;
                    }
                    if(min > lineSum[i]){
                        minX = i;
                        min = lineSum[i];
                    }
                }
            }
        }
        return ans;
    }
    
    public void test() {
    	int[][] a = new int[][] {{-1,-8,1,3,1},
    							 {-3,7,6,-2,4},
    							 {6,-4,8,8,-7}};
    	System.out.println(Arrays.toString(getMaxMatrix(a)));
    }
}
