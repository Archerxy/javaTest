package leetcode;

public class MatrixSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length][matrix[0].length+1];
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                sum[i][j+1] = sum[i][j] + matrix[i][j];
            }
        }

        int ans = 0;
        int startY = 0, endY = 1;
        int[] lineSum = new int[sum.length+1];
        while(endY < sum[0].length){
            for(; startY < endY; ++startY){
                for(int i = 1; i < lineSum.length; ++i){
                    lineSum[i] = lineSum[i-1] + sum[i-1][endY] - sum[i-1][startY];
                }
                for(int i = 0; i < lineSum.length - 1; ++i){
                    for(int j = i+1; j < lineSum.length; ++j)
                        if(lineSum[j] - lineSum[i] == target)
                            ++ans;
                }
            }
            ++endY;
            startY = 0;
        }
        return ans;
    }
    
    public void test() {
    	int[][] a = new int[][] {{0,1,0},{1,1,1},{0,1,0}};
    	System.out.println(numSubmatrixSumTarget(a,0));
    }
}
