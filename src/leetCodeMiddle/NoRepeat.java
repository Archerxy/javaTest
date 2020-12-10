package leetCodeMiddle;
import java.util.*;

public class NoRepeat {
    char[] cs;
    public String modifyString(String s) {
        cs = s.toCharArray();
        for(int i = 0; i < cs.length; ++i){
            if(cs[i] == '?'){
                int c = 97;
                cs[i] = (char)c;
                while(isRepeat()){
                    c++;
                    cs[i] = (char)c;
                }
            }
        }
        return new String(cs);
    }
    
    boolean isRepeat(){
        int l = 1;
        while(l <= cs.length/2){
            for(int i = 0; i+2*l <= cs.length; i++){
            	boolean flag = false;
            	for(int k = i; k < i+2*l; ++k)
	            	if(cs[k] == '?') {
	            		flag = true;
	            		break;
	            	}
            	if(flag)
            		break;
                char[] cs1 = Arrays.copyOfRange(cs,i,i+l);
                char[] cs2 = Arrays.copyOfRange(cs,i+l,i+2*l);
                if((new String(cs1)).equals(new String(cs2))){
                    return true;
                }
            }
            ++l;
        }
        return false;
    }
    
    public void test() {
    	String s = "?ob?b???";
    	System.out.println(modifyString(s));
    }

}
