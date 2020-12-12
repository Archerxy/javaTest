package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode  https://leetcode-cn.com/problems/word-break-ii/
public class WordsBreak {
	private LinkedList<Integer> dpPointList = new LinkedList<>();
	private HashSet<String> dictSet = new HashSet<>();
	private List<String> res = new LinkedList<>();
	private int minWordLen = 0;
	private int maxWordLen = 0;
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		dpPointList = new LinkedList<>();
		dictSet = new HashSet<>();
		res = new LinkedList<>();
		
        if(wordDict.size() == 0) return res;
        
        HashSet<Character> charSet = new HashSet<>();
    	for(String word: wordDict) {
    		if(minWordLen == 0) minWordLen = word.length();
    		if(minWordLen > word.length()) minWordLen = word.length();
    		if(maxWordLen == 0) maxWordLen = word.length();
    		if(maxWordLen < word.length()) maxWordLen = word.length();
    		for(char c: word.toCharArray()){
                if(!charSet.contains(c))
                	charSet.add(c);
            }
    		dictSet.add(word);
    	}
    	//抖机灵
        for(int i = 0; i < s.length(); i++){
            if(!charSet.contains(s.charAt(i)))
                return res;
        }
    	
    	int i = minWordLen-1;
		boolean flag = false;
    	for(; i < s.length(); i++) {
    		if(dictSet.contains(s.substring(0,i+1))) {
    			dpPointList.add(i);
    			continue;
    		}
			for(int j: dpPointList) {
				if(j < i&&dictSet.contains(s.substring(j+1,i+1))) {
					flag = true;
					break;
				}
			}
			if(flag) {
				dpPointList.add(i);
				flag = false;
			}
    	}
    	if(dpPointList.size() > 0 && dpPointList.getLast() != s.length()-1) return res;

    	//公式为 f[n] = f[n-1] + s.substring(f[n-1]+1,f[n])
    	subEachWord(s,"");
    	return res;
    }
    
    //这里用了String而非StringBuilder主要是用了String值传递得原理
    public void subEachWord(String s, String centence) {
		for(int p: dpPointList) {
			if(p < s.length()) {
				if(s.substring(p+1).isEmpty() && dictSet.contains(s.substring(0,p+1))){
		    		centence = s+(centence.isEmpty()?"":" "+centence); 
		    		res.add(centence);
		    		continue;
				}
		    	if(dictSet.contains(s.substring(p+1))) {
					subEachWord(s.substring(0,p+1),s.substring(p+1)+(centence.isEmpty()?"":" "+centence));
				}
			}
		}
    }
 	
    
    public void test() {
    	LinkedList<String> in = new LinkedList<>();
    	
//    	String inS = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//    	in.add("a");
//    	in.add("aa");
//    	in.add("aaa");
//    	in.add("aaaa");
//    	in.add("aaaaa");
//    	in.add("aaaaaa");
//    	in.add("aaaaaaa");
//    	in.add("aaaaaaaa");
//    	in.add("aaaaaaaaa");
//    	in.add("aaaaaaaaaa");
    	
//    	String inS = "catsanddog";
//    	in.add("cat");
//    	in.add("cats");
//    	in.add("and");
//    	in.add("sand");
//    	in.add("dog");
    	
//    	String inS = "pineapplepenapple";
//    	in.add("apple");
//    	in.add("pen");
//    	in.add("applepen");
//    	in.add("pine");
//    	in.add("pineapple");
    	
    	String inS = "a";
    	in.add("a");
    	List<String> res = wordBreak(inS,in);
    	for(String s: res) {
    		System.out.println("'"+s+"'");
    	}
    }
    /**
    * old version, problems with runtimeout
    public List<String> wordBreak(String s, List<String> wordDict) {
    	List<String> res = new LinkedList<>();
        if(wordDict.size() == 0) return res;
        
    	HashSet<String> dictSet = new HashSet<>();
        HashSet<Character> charSet = new HashSet<>();
    	int minWordLen = 0,maxWordLen = 0;
    	for(String word: wordDict) {
    		if(minWordLen == 0) minWordLen = word.length();
    		if(minWordLen > word.length()) minWordLen = word.length();
    		if(maxWordLen == 0) maxWordLen = word.length();
    		if(maxWordLen < word.length()) maxWordLen = word.length();
    		for(char c: word.toCharArray()){
                if(!charSet.contains(c))
                	charSet.add(c);
            }
    		dictSet.add(word);
    	}
    	//抖机灵
        for(int i = 0; i < s.length(); i++){
            if(!charSet.contains(s.charAt(i)))
                return res;
        }
    	
    	HashMap<Integer,LinkedList<String>> dp = new HashMap<>();
    	LinkedList<Integer> keyList = new LinkedList<>();
    	
    	dp.put(-1, new LinkedList<String>());
    	dp.get(-1).add("");
    	
    	StringBuilder outerSb = new StringBuilder();
    	int i = minWordLen-1;
		outerSb.append(s.substring(0, i));
    	for(; i < s.length() - minWordLen; i++) {
    		//删除过期记录，防止JVM堆溢出
    		if(i > maxWordLen) {
    			dp.remove(i-maxWordLen-1);
    		}
    		outerSb.append(s.charAt(i));
    		if(dictSet.contains(outerSb.toString())) {
    			dp.put(i, new LinkedList<>());
    			dp.get(i).add(outerSb.toString()+" ");
    		}
			for(int j: keyList) {
				if(dictSet.contains(outerSb.substring(j+1))) {
					if(!dp.containsKey(i))
						dp.put(i, new LinkedList<>());
					for(String beforeStr: dp.get(j)) {
						dp.get(i).add(beforeStr+outerSb.substring(j+1)+" ");
					}
				}
			}
			if(dp.containsKey(i))
				keyList.add(i);
    	}
    	for(String word: dictSet) {
    		int index = s.length()-word.length();
    		if(dp.containsKey(index-1) && s.substring(index).equals(word)) {
    			for(String beforeStr: dp.get(index-1)) {
    				res.add(beforeStr+word);
    			}
    		}
    	}
    	
    	return res;
    }
     */
}
