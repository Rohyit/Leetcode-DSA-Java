// Problem: Balanced Binary Tree
// Link: https://leetcode.com/problems/balanced-binary-tree/description/
// Approach: Tree

package Tree;

class TreeNode {
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

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsheight(root) != -1;
    }
    int dfsheight(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = dfsheight(root.left);
        int r = dfsheight(root.right);
        if(l == -1 || r == -1){
            return -1;
        }
        if(Math.abs(l-r) > 1){
            return -1;
        }
        return 1+Math.max(l,r);
    }
}