package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode  https://leetcode-cn.com/problems/word-search-ii/
public class WordSearch {
	private HashMap<Character,LinkedList<String>> twoStep;
	
    public List<String> findWords(char[][] board, String[] words) {
    	LinkedList<String> res = new LinkedList<>();
    	
    	if(board.length == 0 || board[0].length == 0 || words.length == 0) {
    		return res;
    	}
    	
    	twoStep = new HashMap<>();
    	for(int x = 0; x < board.length; x++) {
    		for(int y = 0; y < board[0].length; y++) {
    			if(!twoStep.containsKey(board[x][y])) {
    				twoStep.put(board[x][y], new LinkedList<String>());
    			}
    			
    			if(x != 0) {
    				twoStep.get(board[x][y]).add(board[x-1][y] + ":"+(x-1)+","+y);
    			}
    			if(y != 0) {
    				twoStep.get(board[x][y]).add(board[x][y-1] + ":"+x+","+(y-1));
    			}
    			if(x != board.length - 1) {
    				twoStep.get(board[x][y]).add(board[x+1][y] + ":"+(x+1)+","+y);
    			}
    			if(y != board[0].length - 1) {
    				twoStep.get(board[x][y]).add(board[x][y+1] + ":"+x+","+(y+1));
    			}
    		}
    	}
    	
    	for(String word: words) {
    		if(word.length() == 0)
    			continue;
    		if(twoStep.containsKey(word.charAt(0))){
    			if(word.length() == 1) {
    				res.add(word);
    				continue;
    			}
    			if(match(word,0,new HashSet<String>()))
    				res.add(word);
    		}
    	}
    	return res;
    }
    
    private boolean match(String word, int index,HashSet<String> before) {
    	if(twoStep.containsKey(word.charAt(index))) {
    		if(index == word.length() - 1) {
    			return true;
    		}
			for(String s: twoStep.get(word.charAt(index))) {
				if(before.contains(s))
					continue;
				
				char c = s.charAt(0);
				if(word.charAt(index+1) == c) {
					before.add(s);
					if(index == 0) {
						for(String last: twoStep.get(word.charAt(index+1))) {
							if(c == last.charAt(0)) {
								before.add(last);
								break;
							}
						}
					}
					return match(word,index+1,before);
				}
			}
		}
    	return false;
    }
    
    public void test() {
//    	char[][] c = new char[][] {
//    		{'o','a','r','n'},
//    		{'e','t','a','e'},
//    		{'i','h','k','r'},
//    		{'i','f','l','v'}
//    	};
//    	String[] w = new String[] {"oath","aaa","eat","rain"};
    	char[][] c = new char[][] {
    		{'a','b'},
    		{'a','a'}
    	};
//    	String[] w = new String[] {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
    	String[] w = new String[] {"bab"};
    	List<String> r = findWords(c,w);
    	for(String s: r) {
    		System.out.print(s+" ");
    	}
    }
}
