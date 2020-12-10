package leetCodeMiddle;

import java.util.LinkedList;
import java.util.List;
//https://leetcode-cn.com/problems/01-matrix/
public class ZeroAndMatrix {
    private int[][] res;
    private List<int[]> lastList;
    private List<int[]> nextList;
    
    public int[][] updateMatrix(int[][] matrix) {
    	if(matrix.length == 1 && matrix[0].length == 1) return matrix;
    	
        this.lastList = new LinkedList<>();
        this.nextList = new LinkedList<>();
        
        res = new int[matrix.length][matrix[0].length];
        
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                res[x][y] = Integer.MAX_VALUE;
                if(matrix[x][y]==0) {
                	nextList.add(new int[] {x,y});
                	res[x][y] = 0;
                }
            }
        }
        
        bfs();
        
        return res;
    }
    private void bfs() {
    	lastList.clear();
    	lastList.addAll(nextList);
    	nextList.clear();
    	for(int[] p: lastList) {
    		if(p[0]>0 && res[p[0]-1][p[1]] == Integer.MAX_VALUE) {
    			res[p[0]-1][p[1]] = res[p[0]][p[1]]+1;
    			nextList.add(new int[] {p[0]-1,p[1]});
    		}
    		if(p[1]>0 && res[p[0]][p[1]-1] == Integer.MAX_VALUE) {
    			res[p[0]][p[1]-1] = res[p[0]][p[1]]+1;
    			nextList.add(new int[] {p[0],p[1]-1});
    		}
    		if(p[0]<res.length-1 && res[p[0]+1][p[1]] == Integer.MAX_VALUE) {
    			res[p[0]+1][p[1]] = res[p[0]][p[1]]+1;
    			nextList.add(new int[] {p[0]+1,p[1]});
    		}
    		if(p[1]<res[0].length-1 && res[p[0]][p[1]+1] == Integer.MAX_VALUE) {
    			res[p[0]][p[1]+1] = res[p[0]][p[1]]+1;
    			nextList.add(new int[] {p[0],p[1]+1});
    		}
    	}
    	if(nextList.size() == 0) return;
    	else bfs();
    }
    
    
    public void test() {
//    	int[][] b = new int[][] {{0,0,1,0,1,1,1,0,1,1},
//    							 {1,1,1,1,0,1,1,1,1,1},
//    							 {1,1,1,1,1,0,0,0,1,1},
//    							 {1,0,1,0,1,1,1,0,1,1},
//    							 {0,0,1,1,1,0,1,1,1,1},
//    							 {1,0,1,1,1,1,1,1,1,1},
//    							 {1,1,1,1,0,1,0,1,0,1},
//    							 {0,1,0,0,0,1,0,0,1,1},
//    							 {1,1,1,0,1,1,0,1,0,1},
//    							 {1,0,1,1,1,0,1,1,1,0}};
    							 
    	int[][] b = new int[][]	{{1,1,1,1,1,1,1,1,1,1},
    							 {1,1,1,1,1,1,1,1,1,1},
    							 {1,1,1,1,1,1,1,1,1,1},
    							 {1,1,1,0,0,1,1,1,1,1},
    							 {1,1,1,1,1,1,1,1,1,1},
    							 {1,1,1,0,1,1,1,1,1,1},
    							 {1,1,1,1,1,0,1,1,1,1},
    							 {1,1,1,1,1,1,1,1,1,1},
    							 {1,1,1,1,1,1,1,1,1,1},
    							 {1,1,1,1,1,1,1,1,1,1}};
    	
//		int[][] b = new int[][]	{{0,1,0,1,1},
//								 {1,1,0,0,1},
//								 {0,0,0,1,0},
//								 {1,0,1,1,1},
//								 {1,0,0,0,1}};
//		int[][] b = new int[][] {{1,1,0,0,1,0,0,1,1,0},
//								 {1,0,0,1,0,1,1,1,1,1},
//								 {1,1,1,0,0,1,1,1,1,0},
//								 {0,1,1,1,0,1,1,1,1,1},
//								 {0,0,1,1,1,1,1,1,1,0},
//								 {1,1,1,1,1,1,0,1,1,1},
//								 {0,1,1,1,1,1,1,0,0,1},
//								 {1,1,1,1,1,0,0,1,1,1},
//								 {0,1,0,1,1,0,1,1,1,1},
//								 {1,1,1,0,1,0,1,1,1,1}};
    	int[][] a = updateMatrix(b);
    	System.out.println(a);
    }
}
