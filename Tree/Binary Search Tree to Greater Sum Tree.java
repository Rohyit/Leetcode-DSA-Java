// Problem: Binary Search Tree to Greater Sum Tree
// Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    private void reverseInorder(TreeNode root){
        if(root == null){
            return;
        }
        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);
    }
}