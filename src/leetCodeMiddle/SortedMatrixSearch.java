package leetCodeMiddle;

public class SortedMatrixSearch {
	private int[][] matrix;
	private int target;
	private int theX;
	private int theY;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        
        this.matrix = matrix;
        this.target = target;
        int x = matrix.length;
        int y = matrix[0].length;
        if(matrix[0][0] > target) return false;
        if(matrix[x-1][y-1] < target) return false;
        
        theX = searchXY1(0, x-1);
        boolean flag = searchXY2(0, y-1);
        if(flag) return true;
        theY = searchYX1(0,y-1);
        return searchYX2(0,x-1);
    }

    private int searchXY1(int l,int h){
    	if(matrix[l][0] == target) return l;
    	if(matrix[h][0] == target) return h;
    	
    	if(l == h || h == l+1) {
    		if(matrix[h][0] < target) return h;
    		else return l;
    	}
    	
        if(matrix[(l+h)/2][0] < target) {
        	return searchXY1((l+h)/2,h);
        } else {
        	return searchXY1(l,(l+h)/2);
        }
    }

    private boolean searchXY2(int l,int h){
    	if(l == h || h == l+1) return matrix[theX][l] == target || matrix[theX][h] == target;
    	if(matrix[theX][l] == target) return true;
    	if(matrix[theX][h] == target) return true;
    	
        if(matrix[theX][(l+h)/2] < target) {
        	return searchXY2((l+h)/2,h);
        } else {
        	return searchXY2(l,(l+h)/2);
        }
    }

    private boolean searchYX2(int l,int h){
    	if(l == h || h == l+1) return matrix[l][theY] == target || matrix[h][theY] == target;
    	if(matrix[l][theY] == target) return true;
    	if(matrix[h][theY] == target) return true;
    	
        if(matrix[(l+h)/2][theY] < target) {
        	return searchYX2((l+h)/2,h);
        } else {
        	return searchYX2(l,(l+h)/2);
        }
    }

    private int searchYX1(int l,int h){
    	if(matrix[0][l] == target) return l;
    	if(matrix[0][h] == target) return h;

    	if(l == h || h == l+1) {
    		if(matrix[0][h] < target) return h;
    		else return l;
    	}
    	
        if(matrix[0][(l+h)/2] < target) {
        	return searchYX1((l+h)/2,h);
        } else {
        	return searchYX1(l,(l+h)/2);
        }
    }
    
    public void test() {
    	int[][] a = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    	System.out.println(searchMatrix(a,3));
    }

}
