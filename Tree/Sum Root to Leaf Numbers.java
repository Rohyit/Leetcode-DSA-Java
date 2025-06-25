// Problem: Sum Root to Leaf Numbers
// Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
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
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }
    public int solve(TreeNode root, int curr){
        if(root == null){
            return 0;
        }
        curr = curr* 10 + root.val;
        if(root.left == null && root.right == null){
            return curr;
        }
        int l = solve(root.left, curr);
        int r = solve(root.right, curr);

        return l+r;
    }
}