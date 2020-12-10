package leetCodeMiddle;

public class UniquePath {
	public int uniquePaths(int m, int n) {
        if(m == n&&m==1) return 0;
        int min = (m<n?m:n)-1;
        long y = 1, x = 1;
        while(min>0){
            y = y*(m+n-1-min);
            x = x*min;
            if(y%min == 0) {
            	y = y/min;
            	x = x/min;
            }
            if(x%(m+n-1-min)==0) {
            	x = x/(m+n-1-min);
            	y = y/(m+n-1-min);
            }
            if(y%x==0) {
            	y = y/x;
            	x = 1;
            }
            min--;
        }
        return (int) (y/x);
    }
	public void test() {
		System.out.println(uniquePaths(50,50));
	}
}
