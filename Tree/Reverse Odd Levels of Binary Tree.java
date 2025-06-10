// Problem: Reverse Odd Levels of Binary Tree
// Link: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
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
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 1);
        return root;
    }
    public void reverse(TreeNode node1, TreeNode node2, int level){
        if(node1 == null || node2 == null){
            return;
        }
        if(level % 2 != 0){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        reverse(node1.left, node2.right, level + 1);
        reverse(node1.right, node2.left, level + 1);
    }
}