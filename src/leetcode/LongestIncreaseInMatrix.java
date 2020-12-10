package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
// https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/submissions/
// stackoverflow error
public class LongestIncreaseInMatrix {
	private int[][] matrix;
	private int len = 0;
	private List<int[]> nodeList;
	private Map<String,Boolean> noPathMap;
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0) return 0;
		this.matrix = matrix;
		
		for(int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[0].length; y++) {
				int[] curP = new int[] {x,y};
				nodeList = new LinkedList<>();
				nodeList.add(new int[] {x,y});
				noPathMap = new HashMap<>();
				loop(curP);
			}
		}
		return len;
    }
	
	private void loop(int[] curP) {
		String leftKey = curP[0]+"-"+curP[1]+"-left";
		String topKey = curP[0]+"-"+curP[1]+"-top";
		String rightKey = curP[0]+"-"+curP[1]+"-right";
		String bottomKey = curP[0]+"-"+curP[1]+"-bottom";
		
		int[] nextP = null;
		if(nextP == null) {
			nextP = toLeft(curP);
			if(nextP != null) {
				if(noPathMap.get(leftKey) != null) nextP = null;
			}
		}
		if(nextP == null) {
			nextP = toTop(curP);
			if(nextP != null) {
				if(noPathMap.get(topKey) != null) nextP = null;
			}
		}
		if(nextP == null) {
			nextP = toRight(curP);
			if(nextP != null) {
				if(noPathMap.get(rightKey) != null) nextP = null;
			}
		}
		if(nextP == null) {
			nextP = toBottom(curP);
			if(nextP != null) {
				if(noPathMap.get(bottomKey) != null) nextP = null;
			}
		}
		
		if(nextP != null) {
			nodeList.add(nextP);
			loop(nextP);
		} else {
			if(len < nodeList.size()) {
				len = nodeList.size();
			}
			if(nodeList.size() <= 0)
				return;
			nodeList.remove(nodeList.size()-1);
			if(nodeList.size() <= 0)
				return;
			int[] lastP = nodeList.get(nodeList.size()-1);
			if(lastP == null)
				return;
			
			if((curP[0]-lastP[0]) == 1) {
				noPathMap.put(lastP[0]+"-"+lastP[1]+"-bottom", true);
			}
			if((curP[1]-lastP[1]) == 1) {
				noPathMap.put(lastP[0]+"-"+lastP[1]+"-right", true);
			}
			if((curP[0]-lastP[0]) == -1) {
				noPathMap.put(lastP[0]+"-"+lastP[1]+"-top", true);
			}
			if((curP[1]-lastP[1]) == -1) {
				noPathMap.put(lastP[0]+"-"+lastP[1]+"-left", true);
			}
			noPathMap.remove(leftKey);
			noPathMap.remove(topKey);
			noPathMap.remove(rightKey);
			noPathMap.remove(bottomKey);
			loop(lastP);
		}
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
		int a = this.longestIncreasingPath(new int [][] {{7,8,9},
														 {9,7,6},
														 {7,2,3}});
		System.out.println(a);
	}
}
