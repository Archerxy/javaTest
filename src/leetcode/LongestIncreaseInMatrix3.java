package leetcode;
//https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/submissions/
public class LongestIncreaseInMatrix3 {
	private int[][] matrix;
	private int xLen, yLen;
	private int[][] lenMap;
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0) return 0;
		this.matrix = matrix;
		this.xLen = matrix.length;
		this.yLen = matrix[0].length;
		this.lenMap = new int[xLen][yLen];
		
		int len = 0;
		for(int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[0].length; y++) {
				len = Math.max(len, loop(x,y));
			}
		}
		return len;
    }

	private int loop(int x, int y) {
		if(lenMap[x][y] > 0) {
			return lenMap[x][y];
		}
		
		if(x-1>=0 && matrix[x][y] < matrix[x-1][y]) {
			lenMap[x][y] = Math.max(loop(x-1,y)+1, lenMap[x][y]); 
		}
		if(x+1<xLen && matrix[x][y] < matrix[x+1][y]) {
			lenMap[x][y] = Math.max(loop(x+1,y)+1, lenMap[x][y]);
		}
		if(y-1>=0 && matrix[x][y] < matrix[x][y-1]) {
			lenMap[x][y] = Math.max(loop(x,y-1)+1, lenMap[x][y]);
		}
		if(y+1<yLen && matrix[x][y] < matrix[x][y+1]) {
			lenMap[x][y] = Math.max(loop(x,y+1)+1, lenMap[x][y]);
		}
		if(lenMap[x][y] > 0)
			return lenMap[x][y];
		lenMap[x][y] = 1;
		return 1;
	}

	public void test() {
		int a = this.longestIncreasingPath(new int [][] {{7,8,9},
														 {9,7,6},
														 {7,2,3}});
//		int a = this.longestIncreasingPath(new int [][] {{9,9,4},
//														 {6,6,8},
//														 {2,1,1}});
		System.out.println(a);
	}
}
