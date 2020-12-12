package OtherTopic;

import java.util.Scanner;

public class CalculateString {
    public static void solution(){
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\n");
        String in = reader.next();
        reader.close();
        System.out.println(calculateOne(in));
    }
    
    private static String calculateOne(String s){
        if(s.indexOf("(") == -1 && s.indexOf(")") == -1) return s;
        int l = -1, r = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') l = i;
            if(l != -1 && s.charAt(i) == ')') {
                r = i;
                break;
            } 
        }
        String cal = s.substring(l+1,r);
        String[] calArr = cal.split(" ");
        int res = 0;
        boolean flag = false;
        switch(calArr[0]){
            case "add": {
                res = Integer.valueOf(calArr[1]) + Integer.valueOf(calArr[2]);
                break;
            }
            case "sub": {
                res = Integer.valueOf(calArr[1]) - Integer.valueOf(calArr[2]);
                break;
            }
            case "mul": {
                res = Integer.valueOf(calArr[1]) * Integer.valueOf(calArr[2]);
                break;
            }
            case "div": {
                if(Integer.valueOf(calArr[2]) == 0) flag = true;
                else res = Integer.valueOf(calArr[1]) / Integer.valueOf(calArr[2]);
                break;
            }
        }
        if(flag) return "error";
        if(r == s.length()) return String.valueOf(res);
        return calculateOne(s.substring(0,l)+res+s.substring(r+1));
    }

}
