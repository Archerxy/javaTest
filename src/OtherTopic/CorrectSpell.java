package OtherTopic;

import java.util.Scanner;

public class CorrectSpell {
    public static void done(){
        Scanner reader = new Scanner(System.in);
        int len = reader.nextInt();
        String[] sArr = new String[len];
        int i = 0;
        while((len--)>0){
        	sArr[i++] = reader.next().trim();
        }
        reader.close();
        for(String s: sArr) {
            if(s.length() < 2){
                System.out.println(s);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            sb.append(chars[0]);
            sb.append(chars[1]);
            for(i = 2 ; i < chars.length; ++i){
            	int l = sb.length();
                char c2 = sb.charAt(l-1);
                char c1 = sb.charAt(l-2);
                if(c1 == c2 && c2 == chars[i])
                    continue;
                if(sb.length()>2){
                    char c0 = sb.charAt(l-3);
                    if(c0 == c1 && c2 == chars[i])
                        continue;
                }
                sb.append(chars[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
