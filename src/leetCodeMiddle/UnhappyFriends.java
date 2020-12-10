package leetCodeMiddle;

public class UnhappyFriends {

    public int unhappyFriends(int n, int[][] pre, int[][] p) {
        int[][] map = new int[n][n];
        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n-1; ++i){
                map[k][pre[k][i]] = n-i;
            }
        }
        int ans = 0;
        for(int i = 0; i < n/2 - 1; ++i){
            for(int j = i +1; j < n/2; ++j){
                int x = p[i][0], y = p[i][1], u = p[j][0], v = p[j][1];
                int xy = map[x][y], xu = map[x][u], xv = map[x][v];
                int yx = map[y][x], yu = map[y][u], yv = map[y][v];
                int ux = map[u][x], uy = map[u][y], uv = map[u][v];
                int vx = map[v][x], vy = map[v][y], vu = map[v][u];
                if((xu > xy && ux > uv)||(xv > xy && vx > vu))
                    ++ans;
                if((yu > yx && uy > uv)||(yv > yx && vy > vu))
                    ++ans;
                if((ux > uv && xu > xy)||(uy > uv && yu > yx))
                    ++ans;
                if((vx > vu && xv > xy)||(vy > vu && yv > yx))
                    ++ans;
            }
        }
        return ans;
    }
    
    public void test() {
    	int[][] pre = new int[][] {{1,4,3,2,5},{0,5,4,3,2},{3,0,1,5,4},{2,1,4,0,5},{2,1,0,3,5},{3,4,2,0,1}};
    	int[][] p = new int[][] {{3,1},{2,0},{5,4}};
    	System.out.println(unhappyFriends(6,pre,p));
    }

}
