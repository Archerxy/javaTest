package leetcode;
import java.util.*;

//https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/

public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        String s = dfs(root,"");
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        if(data.indexOf("_") == -1){
            data = data.trim();
            return new TreeNode(Integer.valueOf(data));
        }
        String[] nodeStr = data.split(" ");
        LinkedList<Node> list = new LinkedList<>();
        for(int i = 0; i < nodeStr.length; i += 2){
            Node node = new Node();
            node.depth = nodeStr[i].length();
            if(!nodeStr[i+1].equals("n"))
                node.n = new TreeNode(Integer.valueOf(nodeStr[i+1]));
            
            if(list.size() > 0){
                if(list.getLast().depth < node.depth){
                    list.getLast().n.left = node.n;
                    list.add(node);
                    continue;
                }
                if(list.getLast().depth == node.depth){
                    list.pollLast();
                    list.getLast().n.right = node.n;
                    list.add(node);
                    continue;
                }
                while(list.getLast().depth >= node.depth){
                    list.pollLast();
                }
                list.getLast().n.right = node.n;
                list.add(node);
            } else 
                list.add(node);
        }
        return list.getFirst().n;
    }

    private String dfs(TreeNode n, String prefix){
        if(n == null)
            return null;
        String left = dfs(n.left,prefix+"_");
        String right = dfs(n.right,prefix+"_");
        String r = prefix+" "+n.val+" ";
        if(left == null && right == null)
            return r;
        if(left != null)
            r += left;
        else
            r += prefix+"_ n ";
        if(right != null)
            r += right;
        else
            r += prefix+"_ n ";
        return r;
    }

    class Node {
        public int depth;
        public TreeNode n;
    }

    private class TreeNode {
    	public int val;
    	public TreeNode left;
    	public TreeNode right;
    	public TreeNode(int x) {val = x;}
    }
    
    public void test() {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);
    	root.right.left.left = new TreeNode(6);
    	root.right.left.right = new TreeNode(6);
    	root.right.right.left = new TreeNode(7);
    	root.right.left.left.left = new TreeNode(8);
    	root.right.left.left.right = new TreeNode(9);
    	
    	String s = serialize(root);
    	System.out.println(s);
    	deserialize(s);
    }
}
