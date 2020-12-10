package leetCodeMiddle;

import java.util.*;

public class DisConnectIsland {
    
    boolean vis[][];
    int get(int g[][]){
        
        int l  =g.length;
        int ll = g[0].length;
        
        vis  = new boolean[l][ll];
        int r = 0;
        for(int j=0;j<l;++j){
            for(int k=0;k<ll;++k){
                if(g[j][k]==1&&!vis[j][k]){
                    dfs(j,k,g);
                    r++;
                }
            }
        }
        return r;
    }
    
    void dfs(int i,int j,int g[][]){
        int l = g.length;
        int ll = g[0].length;
        if(i<0||j<0||i>=l||j>=ll||g[i][j]==0||vis[i][j]){
            return ;
        }
        vis[i][j] = true;
        dfs(i+1,j,g);
        dfs(i-1,j,g);
        dfs(i,j+1,g);
        dfs(i,j-1,g);
    }
    
    
    public int minDays(int[][] g) {
        int num = get(g);
        if(num>=2) return 0;
        
        int l  =g.length;
        int ll = g[0].length;
        
        for(int j=0;j<l;++j){
            for(int k=0;k<ll;++k){
                if(g[j][k]==1){
                    g[j][k] = 0;
                    
                    int r = get(g);
                    if(r>=2){
                        return 1;
                    }
                    g[j][k] = 1;
                }       
            }
        }
        return 2;
    }
    
    public void test() {
    	int[][] g = new int[][] {{0,1,1,1,0},
    							 {1,1,1,1,1},
    							 {1,1,1,1,1},
    							 {1,1,1,1,1},
    							 {0,1,1,1,0}};
    	System.out.println(minDays(g));
    }
}
