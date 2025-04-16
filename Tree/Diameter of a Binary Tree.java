// Problem: Diameter of a Binary Tree
// Link: https://leetcode.com/problems/diameter-of-binary-tree/description/
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }
    public int maxDepth(TreeNode root, int[] diameter) {
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left, diameter);
        int r = maxDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], l+r);

        return 1+Math.max(l,r);
    }
}