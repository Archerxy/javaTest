package leetcode;

import java.util.*;

public class EightQueens {
    char[] s;
    int n;
    int[] p;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        if(n <= 2)
            return new LinkedList<List<String>>();
        this.n = n;

        ans = new LinkedList<List<String>>();
        s = new char[n];
        int i = -1;
        while((++i)<n){
            s[i] = '.';
        }
        p = new int[n];
        findNext(p,0);
        return ans;
    }

    void findNext(int[] p,int count){
        if(count == n && isValid(p)){
            String[] line = new String[n];
            for(int i = 0; i < n; ++i){
                s[i] = 'Q';
                line[p[i]-1] = String.valueOf(s);
                s[i] = '.';
            }
            ans.add(Arrays.asList(line));
        }
        for(int i = 0; i < n; ++i){
            if(p[i] > 0){
                continue;
            }
            p[i] = count+1;
            findNext(p,count+1);
            p[i] = 0;
        }
    }

    boolean isValid(int[] p){
        for(int i = 0; i < n-1; ++i){
            if(p[i] - p[i+1] == 1)
            	return false;
            if(p[i+1] - p[i] == 1)
            	return false;
        }
        for(int i = n-1; i > 0; --i){
            if(p[i] - p[i-1] == 1)
            	return false;
            
            if(p[i-1] - p[i] == 1)
            	return false;
        }
        return true;
    }
    
    public void test() {
    	int a = 4;
    	List<List<String>> ans = solveNQueens(a);
    	for(List<String> l: ans) {
    		for(String s: l) {
    			System.out.print(s+" ");
    		}
			System.out.print("\n");
    	}
    }
}
