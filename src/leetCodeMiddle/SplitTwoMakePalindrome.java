package leetCodeMiddle;

public class SplitTwoMakePalindrome {
    String a, b;
    int len;
    public boolean checkPalindromeFormation(String a, String b) {
        this.a = a;
        this.b = b;
        len = a.length();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        
        boolean af = true, bf = true;
        for(int i = 0; i < len/2; ++i){
            if(af && ac[i] != ac[len-1-i])
                af = false;
            if(bf && ac[i] != ac[len-1-i])
                bf = false;
        }
        if(af || bf)
            return true;
        
        af = true;
        bf = true;
        for(int i = 1; i < len; ++i){
            if(af && ac[i-1] == bc[len-i] ){
                if(checkAB(i) || checkAB(len-i))
                    return true;
            } else 
                af = false;
            if(bf && bc[i-1] == ac[len-i]){
                if(checkBA(i))
                    return true;
            } else 
                bf = false;
        }
        return false;
    }
    
    boolean checkAB(int index){
        char[] ab = (a.substring(0,index)+b.substring(index,len)).toCharArray();
        for(int i = 0; i < len/2; ++i){
            if(ab[i] != ab[len-1-i])
                return false;
        }
        return true;
    }
    
    boolean checkBA(int index){
        char[] ba = (b.substring(0,index)+a.substring(index,len)).toCharArray();
        for(int i = 0; i < len/2; ++i){
            if(ba[i] != ba[len-1-i])
                return false;
        }
        return true;
    }
    
    // aejbaal
    public void test() {
    	String a = "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", b = "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea";
    	System.out.println(checkPalindromeFormation(a,b));
    }
}
