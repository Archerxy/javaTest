package leetCodeMiddle;

public class MinGenerateTree {
    public int minCostConnectPoints(int[][] p) {
    	int n = p.length;
    	if(n == 1)
    		return 0;
    	int[] dis = new int[n];
    	boolean[] visited = new boolean[n];
    	for(int i = 0; i < n; ++i)
    		dis[i] = Integer.MAX_VALUE;
    	dis[0] = 0;
    	int c = 0, ans = 0;
    	while(c < n) {
    		int pos = -1, dist = Integer.MAX_VALUE;
    		for(int i = 0; i < n; ++i) {
    			if(!visited[i] && dist >= dis[i]) {
    				pos = i;
    				dist = dis[i];
    			}
    			
    		}
    	}
    	return 0;
    }
    
    public void test() {
    	int[][] a = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
    	System.out.println(minCostConnectPoints(a));
    }
}
