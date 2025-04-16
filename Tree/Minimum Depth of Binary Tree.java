// Problem: Minimum Depth of Binary Tree
// Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(root.left==null || root.right==null){
            return 1+l+r;
        }

        return 1+Math.min(l,r);
    }
}