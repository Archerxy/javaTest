package leetCodeMiddle;

import java.util.Arrays;

//https://leetcode-cn.com/problems/max-black-square-lcci/

public class MaxBlackSquare {
    private int[][] matrix;
    private int[] res = new int[3];

    public int[] findSquare(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        if(matrix.length == 1){
            if(matrix[0][0] == 0)
                return new int[] {0,0,1};
            else  
                return new int[0];
        }

        this.matrix = matrix;
        int len = matrix.length;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len; ++j){
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
        int l = 2;
        int ans = 1;
        while(x+l <= matrix.length && y+l <= matrix.length){
            boolean flag = false;
            if(matrix[x][y+l-1] == 1)
                break;
            if(matrix[x+l-1][y] == 1)
                break;
            for(int i = y+1; i < y+l; ++i){
                if(matrix[x+l-1][i] == 1){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                for(int i = x+1; i < x+l; ++i){
                    if(matrix[i][y+l-1] == 1){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag)
            	ans = l;
            ++l;
        }
        return ans;
    }
    
    public void test() {
//    	int[][] a = new int [][]{{1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
//					    		 {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//					    		 {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
//					    		 {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//					    		 {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
//					    		 {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
//					    		 {0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
//					    		 {0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
//					    		 {1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
//					    		 {1, 1, 1, 0, 1, 0, 0, 1, 1, 1}};
    	int[][] a = new int [][]{{1, 1, 1, 0, 1, 1, 0, 1, 0, 0},
					    		 {0, 1, 0, 1, 1, 0, 0, 0, 1, 1},
					    		 {0, 0, 1, 1, 0, 0, 1, 1, 1, 0},
					    		 {0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
					    		 {1, 1, 0, 1, 1, 0, 1, 0, 0, 1},
					    		 {0, 1, 1, 0, 0, 0, 0, 1, 1, 0},
					    		 {1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
					    		 {1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
					    		 {1, 1, 1, 1, 0, 1, 0, 1, 0, 0},
					    		 {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}};
	    System.out.println(Arrays.toString(findSquare(a)));
    }
}
