// Problem: Root Equals Sum of Children
// Link: https://leetcode.com/problems/root-equals-sum-of-children/description/
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
    public boolean checkTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return root.val == root.left.val+root.right.val;
    }
}