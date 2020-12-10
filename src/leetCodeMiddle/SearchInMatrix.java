package leetCodeMiddle;

public class SearchInMatrix {
	private int[][] matrix;
	private int target;
	private int theX;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        
        this.matrix = matrix;
        this.target = target;
        int x = matrix.length;
        int y = matrix[0].length;
        if(matrix[0][0] > target) return false;
        if(matrix[x-1][y-1] < target) return false;
        
        theX = searchX(0, x-1);
        return searchY(0, y-1);
    }

    private int searchX(int lx,int hx){
    	if(matrix[lx][0] == target) return lx;
    	if(matrix[hx][0] == target) return hx;
    	
    	if(lx == hx || hx == lx+1) {
    		if(matrix[hx][0] < target) return hx;
    		else return lx;
    	}
    	
        if(matrix[(lx+hx)/2][0] < target) {
        	return searchX((lx+hx)/2,hx);
        } else {
        	return searchX(lx,(lx+hx)/2);
        }
    }

    private boolean searchY(int ly,int hy){
    	if(ly == hy || hy == ly+1) return matrix[theX][ly] == target || matrix[theX][hy] == target;
    	if(matrix[theX][ly] == target) return true;
    	if(matrix[theX][hy] == target) return true;
    	
        if(matrix[theX][(ly+hy)/2] < target) {
        	return searchY((ly+hy)/2,hy);
        } else {
        	return searchY(ly,(ly+hy)/2);
        }
    }
    
    public void test() {
    	int[][] a = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    	System.out.println(searchMatrix(a,3));
    }
}
