// Problem: Deepest Leaves Sum
// Link: https://leetcode.com/problems/deepest-leaves-sum/description/
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

    public int deepestLeavesSum(TreeNode root) {
        int maxLevel = maxDepth(root);
        calculateSum(root, maxLevel);
        return sum;
    }
    
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l , r);
    }

    private void calculateSum(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            sum += root.val;
        }
        calculateSum(root.left, level - 1);
        calculateSum(root.right, level - 1);
    }
}