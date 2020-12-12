package leetCodeEasy;

public class Match {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i = 0; i <= arr.length-m*k; ++i){
            int count = 1;
            for(int j = i; j <= arr.length-2*m; j+=m){
            	boolean flag = true;
                for(int l = 0; l < m; ++l){
                    if(arr[j+l] != arr[j+m+l]){
                    	flag = false;
                        break;
                    }
                }
                if(flag) {
                	++count;
                	if(count >= k)
                		return true;
                } else {
                	count = 1;
                }
            }
        }
        return false;
    }
    
    public void test() {
    	int[] a = new int[] {1,2,1,2,1,3};
    	System.out.println(containsPattern(a,2,3));
    }

}
