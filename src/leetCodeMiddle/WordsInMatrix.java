package leetCodeMiddle;
import java.util.*;

//https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

public class WordsInMatrix {
    private char[][] board;
    private char[] words;
    private boolean[][] passed;
    private int len;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.isEmpty() || word.equals(""))
            return false;
        if(board.length*board[0].length < word.length())
            return false;
        this.board = board;
        this.len = board[0].length;
        this.words = word.toCharArray();
        this.passed = new boolean[board.length][len];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == words[0]){
                    if(hasNextRoad(i,j,1))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean hasNextRoad(int x, int y, int i){
        passed[x][y] = true;
        if(i >= words.length)
            return true;
        if(x+1<board.length && words[i] == board[x+1][y] && !passed[x+1][y]){
            if(i == words.length-1 || hasNextRoad(x+1,y,i+1))
                return true;
        }
        if(y+1<board[0].length && words[i] == board[x][y+1] && !passed[x][y+1]){
            if(i == words.length-1 || hasNextRoad(x,y+1,i+1))
                return true;
        }
        if(x>0 && words[i] == board[x-1][y] && !passed[x-1][y]){
            if(i == words.length-1 || hasNextRoad(x-1,y,i+1))
                return true;
        }
        if(y>0 && words[i] == board[x][y-1] && !passed[x][y-1]){
            if(i == words.length-1 || hasNextRoad(x,y-1,i+1))
                return true;
        }
        passed[x][y] = false;
        return false;
    }
    
    public void test() {
    	char[][] a = {{'A','B','C','E'},
    			      {'S','F','E','S'},
    			      {'A','D','E','E'}};
    	String b = "ABCESEEEFS";
    	System.out.println(exist(a,b));
    }
}
