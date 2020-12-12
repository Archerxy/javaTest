package leetCodeMiddle;
//[47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27]
public class Solution {
    private String min;
    private String max;
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() > str2.length()){
            max = str1;
            min = str2;
        } else {
            max = str2;
            min = str1;
        }
        if(max.length() == min.length() && max.equals(min)) return min;
        
        int d = min.length();
        if(max.length()%min.length() == 0){
            for(int i = 0; i < max.length()/d - 1; i++){
                if(!max.substring(i*d,(i+1)*d).equals(max.substring((i+1)*d,(i+2)*d))){
                    break;
                }
                if(i == max.length()/d-2){
                    return min;
                }
            }
        }
        if(d < 2) return ""; 
        return match(d/2);
    }
    public String match(int d){
        if(max.length()%d == 0 && min.length()%d == 0){
            int lm = max.length()/d, ln = min.length()/d;
            for(int i = 0; i < lm - 1; i++){
                if(!max.substring(i*d,(i+1)*d).equals(max.substring((i+1)*d,(i+2)*d))){
                    break;
                }
                if((i < ln-1)&&!min.substring(i*d,(i+1)*d).equals(min.substring((i+1)*d,(i+2)*d))){
                    break;
                }
                if(i == lm-2){
                    return min.substring(0,d);
                }
            }
        }
        d--;
        if(d == 0) return "";
        return match(d);
    }
    
    public void test() {
    	System.out.println(gcdOfStrings("AAA","AAAA"));
    }
}
