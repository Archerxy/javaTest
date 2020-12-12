package leetcode;

import java.util.LinkedList;
import java.util.List;

//leetcode: https://leetcode-cn.com/problems/wildcard-matching/
public class StringMatch{
    public boolean isMatch(String s, String p) {
    	if(p.isEmpty()) return s.isEmpty();
    	
    	int len = p.length();
		String indexE = "";
		for(int i = 0; i < len; i++) {
			indexE += "*";
		}
		
    	if(s.isEmpty()) {
    		return p.isEmpty() || p.equals(indexE);
    	}
    	
    	if(p.indexOf("*") == -1) {
    		if(p.length() != s.length()) return false; 
    		if(p.charAt(0)!=s.charAt(0) && p.charAt(0) != '?') return false;
    		return isMatch(s.substring(1),p.substring(1));
    	}
    	
    	List<String> pList = new LinkedList<>();
    	pList.add(p);
    	pList = splitStr(pList,indexE);
    	
    	for(int i = 0; i < pList.size(); i++) {
    		s = partlyMatch(s,pList.get(i),i==0,i==pList.size()-1);
    		if(s == null) return false;
    	}
		
    	return true;
    }
    
    private List<String> splitStr(List<String> p,String indexE) {
    	if(indexE.isEmpty()) return p;
    	List<String> sList = new LinkedList<>();
    	for(String s: p) {
    		if(s.indexOf(indexE) < 0) sList.add(s);
    		else {
        		String[] tmp = split(s,indexE);
        		for(int j = 0; j < tmp.length; j++) {
        			sList.add(tmp[j]);
        		}
    		}
    	}
		return splitStr(sList,indexE.substring(1));
    }

    private String[] split(String s, String exp) {
    	if(exp.isEmpty()) return s.split("");
    	int len = exp.length();
    	int lastIndex = 0,count = 1;
    	String[] tmp = new String[s.length()+1];
    	for(int i = 0; i <= s.length() - len;) {
    		if(s.substring(i,i+len).equals(exp)) {
    			tmp[i] = s.substring(lastIndex,i);
    			lastIndex = i+len;
    			i = i+len;
    			count++;
    		}else {
    			i++;
    		}
    	}
    	tmp[s.length()] = s.substring(lastIndex);
    	String[] res = new String[count];
    	for(int i = tmp.length - 1; i >=0; i--) {
    		if(tmp[i] != null) res[--count] = tmp[i];
    	}
    	return res;
    }
    
    private String partlyMatch(String s, String p,boolean isFirst, boolean isLast) {
    	if(p.isEmpty()) return s;
    	if(p.length() > s.length()) return null;
    	int si = 0,pi = 0;
    	if(isLast) {
    		si = s.length()-1;
    		pi = p.length()-1;
        	for(; pi >= 0; pi--) {
        		if(s.charAt(si) != p.charAt(pi) && p.charAt(pi) != '?')
        			return null;
        		si--;
        	}
        	return ""; 
    	}else {
        	for(; si < s.length(); si++) {
        		if(pi == p.length()) break;
        		if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
        			pi++;
        		}else {
        			si -= pi;
        			pi = 0;
        		}
        	}
    	}
    	if(pi < p.length()) return null;
    	if(isFirst && si != pi) return null;
    	return s.substring(si);
    }
    
    public void test() {
    	System.out.println(isMatch("mississippi","m*issip*"));
    }
} 