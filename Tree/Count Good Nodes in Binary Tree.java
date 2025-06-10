// Problem: Count Good Nodes in Binary Tree
// Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return cnt;
    }
    public void dfs(TreeNode node, int currMax){
        if(node == null){
            return;
        }
        if(node.val >= currMax){
            cnt++;
            currMax = node.val;
        }
        dfs(node.left, currMax);
        dfs(node.right, currMax);
    }
}