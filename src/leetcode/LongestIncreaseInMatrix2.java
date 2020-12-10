package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/submissions/
// timeout error
public class LongestIncreaseInMatrix2 {
	private int[][] matrix;
	private int len = 0;
	private Map<String, Integer> lenMap;
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0) return 0;
		this.matrix = matrix;
		this.lenMap = new HashMap<>();
		
		for(int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[0].length; y++) {
				List<int[]> curList = new LinkedList<>();
				int[] orignP = new int[] {x,y};
				curList.add(orignP);
				loop(curList,1,orignP);
			}
		}
		return len;
    }
	
	private void loop(List<int[]> pList,int depth, int[] orignP) {
		if(pList == null || pList.size() == 0) {
			if(len < depth) len = depth-1;
			if(!lenMap.containsKey(orignP[0]+"-"+orignP[1]) || lenMap.get(orignP[0]+"-"+orignP[1])<depth) {
				lenMap.put(orignP[0]+"-"+orignP[1], depth-1);
			}
			return ;
		}
		for(int[] p: pList) {
			if(!lenMap.containsKey(p[0]+"-"+p[1])) {
				loop(getNextPList(p),depth+1,orignP);
			} else if(len < depth-1+lenMap.get(p[0]+"-"+p[1])){
				len = depth-1+lenMap.get(p[0]+"-"+p[1]);
			}
		}
	}
	
	private List<int[]> getNextPList(int[] curP) {
		List<int[]> res = new LinkedList<>();
		int[] nextP = null;
		if((nextP = toLeft(curP)) != null) {
			res.add(nextP);
		}
		if((nextP = toTop(curP)) != null) {
			res.add(nextP);
		}
		if((nextP = toRight(curP)) != null) {
			res.add(nextP);
		}
		if((nextP = toBottom(curP)) != null) {
			res.add(nextP);
		}
		return res;
	}
	
	private int[] toTop(int[] curP) {
		if(curP[0] <= 0) 
			return null;
		if(matrix[curP[0]-1][curP[1]] <= matrix[curP[0]][curP[1]])
			return null;
		return new int[] {curP[0]-1,curP[1]};
	}

	private int[] toLeft(int[] curP) {
		if(curP[1] <= 0) 
			return null;
		if(matrix[curP[0]][curP[1]-1] <= matrix[curP[0]][curP[1]])
			return null;
		return new int[] {curP[0],curP[1]-1};
	}

	private int[] toBottom(int[] curP) {
		if(curP[0] >= matrix.length-1) 
			return null;
		if(matrix[curP[0]+1][curP[1]] <= matrix[curP[0]][curP[1]])
			return null;
		return new int[] {curP[0]+1,curP[1]};
	}

	private int[] toRight(int[] curP) {
		if(curP[1] >= matrix[0].length-1) 
			return null;
		if(matrix[curP[0]][curP[1]+1] <= matrix[curP[0]][curP[1]])
			return null;
		return new int[] {curP[0],curP[1]+1};
	}
	
	public void test() {
//		int a = this.longestIncreasingPath(new int [][] {{7,8,9},
//														 {9,7,6},
//														 {7,2,3}});
		int a = this.longestIncreasingPath(new int [][] {{9,9,4},
														 {6,6,8},
														 {2,1,1}});
		System.out.println(a);
	}
}
