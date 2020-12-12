package leetCodeMiddle;

import java.util.Arrays;

public class MaxBlackSquare2 {
    private int[][] matrix;
    private int[][] xSum;
    private int[][] ySum;

    public int[] findSquare(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        if(matrix.length == 1){
            if(matrix[0][0] == 0)
                return new int[] {0,0,1};
            else  
                return new int[0];
        }
        int len = matrix.length;

        this.xSum = new int[len+1][len];
        this.ySum = new int[len][len+1];

        this.matrix = matrix;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len; ++j){
                ySum[i][j+1] = ySum[i][j] + matrix[i][j];
                xSum[j+1][i] = xSum[j][i] + matrix[j][i];
            }
        }
        int[] res = new int[3];
        
        for(int i = 0; i < len; ++i){
            if(len-i < res[2])
                break;

            for(int j = 0; j < len; ++j){
                if(len -j < res[2])
                    continue;
                if(matrix[i][j] == 0){
                    int l = square(i,j);
                    if(res[2] < l){
                        res[0] = i;
                        res[1] = j;
                        res[2] = l;
                    }
                }
            }
        }
        if(res[2] == 0)
            return new int[0];
        return res;
    }

    private int square(int x, int y){
        int l = 1;
        int ans = 1;
        while(x+l < matrix.length && y+l < matrix.length){
            if(xSum[x+l+1][y]-xSum[x][y] == 0 
            && xSum[x+l+1][y+l]-xSum[x][y+l] == 0
            && ySum[x][y+l+1]-ySum[x][y] == 0
            && ySum[x+l][y+l+1]-ySum[x+l][y] == 0)
                ans = l+1;
            ++l;
        }
        return ans;
    }

    public void test() {
    	int[][] a = new int [][]{{1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
					    		 {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					    		 {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
					    		 {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
					    		 {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
					    		 {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
					    		 {0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
					    		 {0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
					    		 {1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
					    		 {1, 1, 1, 0, 1, 0, 0, 1, 1, 1}};
//    	int[][] a = new int [][]{{1, 1, 1, 0, 1, 1, 0, 1, 0, 0},
//					    		 {0, 1, 0, 1, 1, 0, 0, 0, 1, 1},
//					    		 {0, 0, 1, 1, 0, 0, 1, 1, 1, 0},
//					    		 {0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
//					    		 {1, 1, 0, 1, 1, 0, 1, 0, 0, 1},
//					    		 {0, 1, 1, 0, 0, 0, 0, 1, 1, 0},
//					    		 {1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
//					    		 {1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
//					    		 {1, 1, 1, 1, 0, 1, 0, 1, 0, 0},
//					    		 {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}};
	    System.out.println(Arrays.toString(findSquare(a)));
    }
}
