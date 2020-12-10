package leetCodeMiddle;

public class MatWithAllOnes {

    private int[][] mat;
    public int numSubmat(int[][] mat) {
        this.mat = mat;
        int ans = 0;
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[0].length; ++j){
                if(mat[i][j] == 1)
                    ans += findSquare(i,j);
                
            }
        }
        return ans;
    }
    
    private int findSquare(int x, int y){
        int ans = 1;
        int l = -1, r = -1;
        boolean lFlag = true, rFlag = true, lAdd = true, rAdd = true;
        for(int i = 1;;){
            if(!lAdd && !rAdd)
                break;
            
            if(lAdd && x+i < mat.length && mat[x+i][y] == 1){
                if(lFlag)
                    l = i;
                for(int j = 0; j < l; ++j){
                    if(y+j < mat[0].length && mat[x+i][y+j] == 1){
                        ++ans;
                    } else {
                        l = j;
                        lFlag = false;
                        break;
                    }
                }
            } else {
            	if(rFlag)
                	r = i;
            	rFlag = false;
            	lAdd = false;
            }
            
            if(rAdd && y+i < mat[0].length && mat[x][y+i] == 1){
                if(rFlag)
                    r = i;
                for(int j = 0; j < r; ++j){
                    if(x+j < mat.length && mat[x+j][y+i] == 1){
                        ++ans;
                    } else {
                        r = j;
                        rFlag = false;
                        break;
                    }
                }
            } else {
            	if(lFlag)
                	l = i;
            	lFlag = false;
            	rAdd = false;
            }
            
            if(x+i < mat.length && y+i < mat[0].length && mat[x+i][y+i] == 1 && lFlag && rFlag){
                ++ans;
            } else if(x+i < mat.length && y+i < mat[0].length && mat[x+i][y+i] == 0){
            	if(lFlag)
            		l = i;
            	if(rFlag)
            		r = i;
            	lFlag = false;
            	rFlag = false;
            }
            
            ++i;
        }
        return ans;
    }
    
    public void test() {
    	int[][] a = new int[][] {{0,0,0},
    							 {0,0,0},
    							 {0,1,1},
    							 {1,1,0},
    							 {0,1,1}};
    	
    	System.out.println(numSubmat(a));
    }
}
