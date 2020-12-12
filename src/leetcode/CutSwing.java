package leetcode;

public class CutSwing {
    public int cuttingRope(int n) {
        if(n<=2)
            return 1;
        if(n==3)
            return 2;
        long[] ans = new long[2];
        for(int i = 2; i <= n/2; ++i){
            int k = n/i;
            int b = n%i;
            long[] tmp;
            if(b+i>b*i){
                tmp = pow(i,k-1);
                tmp[0] *= (long)(b+i);
            } else {
                tmp = pow(i,k);
                tmp[0] *= (long)b;
            }
            if(tmp[0] > 1000000007l){
                tmp[0] = tmp[0]%1000000007l;
                ++tmp[1];
            }
            if(ans[1] < tmp[1])
                ans = tmp;
            else if(ans[1] == tmp[1] && ans[0] < tmp[0])
                ans = tmp;
            else 
                break;
        }
        return (int)ans[0];
    }

    long[] pow(long m, long n){
        long ans = 1, count = 0;
        while((n--)>0){
            ans = ans*m;
            if(ans > 1000000007l){
                ans = ans%1000000007l;
                ++count;
            }
        }
        return new long[]{ans,count}; 
    }
    
    public void test() {
    	System.out.println(cuttingRope(300));
    }
}
