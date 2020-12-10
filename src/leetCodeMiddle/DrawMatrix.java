package leetCodeMiddle;

public class DrawMatrix {
    public int paintingPlan(int n, int k) {
        if(k == 0)
            return 1;
        if(k < n)
            return 0;
        if(k == n*n)
            return 1;
        int ans = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(i*n + j*n - i*j == k){
                    ans += pick(n,i)*pick(n,j);
                }
            }
        }
        return ans;
    }
    
    int pick(int n, int k){
        if(k == 0)
            return 1;
        int m = 1, z = 1;
        while(k > 0){
            m *= (n-k+1);
            z *= k;
            --k;
        }
        return m/z;
    }
    
    public void test() {
    	
    }
}
