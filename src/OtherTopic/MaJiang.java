package OtherTopic;

import java.util.Arrays;
import java.util.Scanner;

public class MaJiang {
    public static void done(){
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\n");
        String[] sArr = reader.next().trim().split(" ");
        reader.close();
        int[] nums = new int[sArr.length];
        int[] numsP = new int[9];
        for(int i = 0 ; i < nums.length; ++i){
            nums[i] = Integer.valueOf(sArr[i]);
            ++numsP[nums[i]-1];
        }
        String s = null;
        for(int i = 0; i < 9; ++i){
        	++numsP[i];
        	if(isGood(numsP)) 
        		if(s == null)
        			s = ""+(i+1);
        		else
        			s += " "+(i+1);
        	--numsP[i];
        }
        if(s==null)
        	System.out.println(0);
        else 
        	System.out.println(s);
    }
    
    private static boolean isGood(int[] numsP) {
    	for(int i = 0; i < numsP.length; ++i) {
    		if(numsP[i] >= 2) {
    			int[] newNumsP = Arrays.copyOf(numsP, numsP.length);
    			newNumsP[i] -= 2;
    			if(isSmooth(newNumsP)){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    private static boolean isSmooth(int[] numsP) {
    	int k = 0;
    	while(k < 7) {
    		if(numsP[k] > 0) {
    			if(numsP[k] >= 3) {
    				numsP[k] -= 3;
    			} else {
    				if(numsP[k+1]==0||numsP[k+2]==0)
    					return false;
    				--numsP[k];
    				--numsP[k+1];
    				--numsP[k+2];
    			}
    		} else 
    			++k;
    	}
    	return (numsP[7]==0||numsP[7]==3)&&(numsP[8]==0||numsP[8]==3);
    }
}
