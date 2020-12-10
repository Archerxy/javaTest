package leetCodeMiddle;

import java.util.*;

public class GoodLeaves {
    HashMap<TreeNode,ArrayList<Integer>> map;
    int distance;
    int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        map = new HashMap<>();
        this.distance = distance;
        dfs(root);
        return ans;
    }
    
    void dfs(TreeNode n){
        if(n.left == null && n.right == null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            map.put(n,list);
            return ;
        }
        if(n.left != null)
            dfs(n.left);
        if(n.right != null)
            dfs(n.right);
        ArrayList<Integer> list = new ArrayList<>();
        if(n.left != null && n.right != null) {
            ArrayList<Integer> l = map.get(n.left);
            ArrayList<Integer> r = map.get(n.right);
            for(int i: l){
                list.add(i+1);
                for(int j: r){
                    if(i+j+2 <= distance)
                        ++ans;
                }
            }
            for(int j: r){
                list.add(j+1);
            }
        } else if(n.left != null){
            ArrayList<Integer> l = map.get(n.left);
            for(int i: l){
                list.add(i+1);
            }
        } else if(n.right != null){
            ArrayList<Integer> r = map.get(n.right);
            for(int i: r){
                list.add(i+1);
            }
        }
        map.put(n,list);
    }
    
    public void test() {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.right = new TreeNode(4);
    	
    	System.out.println(countPairs(root,3));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
