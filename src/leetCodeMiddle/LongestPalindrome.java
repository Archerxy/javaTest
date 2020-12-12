package leetCodeMiddle;

//典型动态规划问题
public class LongestPalindrome {
    public String longestPalindrome(String s) {
    	if(s.isEmpty()) return "";
    	int l = 0,r = 0;
		int n;
		boolean odd, even;
    	for(int i = 0; i < s.length(); i++) {
    		n = 1;
    		odd = true;
    		even = true;
    		while(i-n+1 >= 0 && i + n <= s.length()) {
    			//单回文
    			if(odd) {
    				if(s.charAt(i-n+1) == s.charAt(i+n-1)) {
            			if(r-l+1 < 2*n-1) {
            				l = i-n+1;
            				r = i+n-1;
            			}
    				}else {
    					odd = false;
    				}
    			}
    			//双回文
    			if(even && i + n < s.length()) {
    				if(s.charAt(i-n+1) == s.charAt(i+n)) {
            			if(r-l+1 < 2*n) {
            				l = i-n+1;
            				r = i+n;
            			}
    				}else {
    					even = false;
    				}
    			}
    			if(odd||even) {
    				n++;
    			}else {
    				break;
    			}
    		}
    	}
    	return s.substring(l,r+1);
    }
    public void test() {
    	System.out.println(longestPalindrome("aaaa"));
    }
}
