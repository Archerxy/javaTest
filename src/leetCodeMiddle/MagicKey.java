package leetCodeMiddle;

public class MagicKey {
    public boolean isMagic(int[] t) {
        int n = t.length;
        int i = 0;
        int b = n%2+1;
        for(; i < n; ++i){
            if(i < n/2 && t[i] != 2*i+2)
                break;
            if(i >= n/2 && t[i] != 2*i+b-n) 
            	break;
        }
        if(i == 0)
            return false;
        return tryChange(t,i);
    }
    boolean tryChange(int[] t, int k){
        int n = t.length;
        int s = 0;
        int[] d = new int[n];
        for(int i = 0; i < n; ++i)
            d[i] = i+1;
        for(;s<n;){
            int[] even = new int[n/2];
            for(int i = s+1; i < n; i+=2 ){
                even[(i-s-1)/2] = d[i];
            }
            int count = 0;
            if((n-s)%2 == 0)
                count = 1;
            
            for(int i = n-1; i >= s; --i ){
                if(i >= (s+n)/2)
                    d[i] = d[i-count];
                else 
                    d[i] = even[i-s];
                ++count;
            }
            s+=k;
            for(int i = s-k; i < (s>=n?n:s); ++i){
                if(d[i] != t[i])
                    return false;
            }
        }
        return true;
    }
    
    public void test() {
//    	int[] a = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,55,59,63,67,53,57,61,65,69};
//    	int[] a = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,35,41,33,39,37,47,43,45};
    	int[] a = {2,4,6,8,10,12,14,16,1,3,5,7,9,13,11,15};
    	System.out.println(isMagic(a));
    }
}
