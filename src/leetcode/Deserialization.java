package leetcode;

import java.util.*;

//https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/

public class Deserialization {
    public TreeNode recoverFromPreorder(String S) {
        String[] sArr = S.split("-");
        TreeNode head = new TreeNode(Integer.valueOf(sArr[0]));
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        int depth = 1;
        for(int i = 1; i < sArr.length; i++){
            if(sArr[i].equals("")||sArr[i].isEmpty()){
                depth++;
            } else {
                TreeNode n = new TreeNode(Integer.valueOf(sArr[i]));
                if(depth == stack.size()){
                    if(stack.peek().left==null)
                        stack.peek().left = n;
                    else 
                        stack.peek().right = n;
                    stack.add(n);
                } else if(depth < stack.size()){
                    while(stack.size() > depth){
                        stack.pop();
                    }
                    if(stack.peek().left==null)
                        stack.peek().left = n;
                    else 
                        stack.peek().right = n;
                    stack.add(n);
                }
                depth = 1;
            }
        }
        return head;
    }
    
    public void test() {
    	TreeNode n = recoverFromPreorder("1-2--3--4-5--6--7");
    }
    
    public class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
