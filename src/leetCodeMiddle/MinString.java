package leetCodeMiddle;

public class MinString {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int value = 0, index = n-1;
        for(int i = 0; i < n; ++i) {
        	sb.append('a');
        	value += 1;
        }
        while(value <= k) {
        	if(value == k)
        		return sb.toString();
        	sb.setCharAt(index, 'z');
        	value += 25;
        	--index;
        }
        int sub = value-k;
        sb.setCharAt(index+1, (char)(122-sub));
        return sb.toString();
    }
    
    
    public void test() {
    	//3, 27
    	System.out.println(getSmallestString(3,28));
    }
}