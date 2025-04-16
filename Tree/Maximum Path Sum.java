// Problem: Maximum Path Sum
// Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }
    private int maxPath(TreeNode root, int[] maxValue){
        if(root==null){
            return 0;
        }
        int l = Math.max(0, maxPath(root.left, maxValue));
        int r = Math.max(0, maxPath(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], l+r+root.val);

        return Math.max(l, r) + root.val;
    }
}