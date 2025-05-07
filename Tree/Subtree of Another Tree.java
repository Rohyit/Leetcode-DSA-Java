// Problem: Subtree of Another Tree
// Link: https://leetcode.com/problems/subtree-of-another-tree/description/
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return search(root, subRoot);
    }
    private boolean search(TreeNode root, TreeNode subRoot){
        boolean ans = false;
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            ans = isSameTree(root, subRoot);
            if(ans){
                return ans;
            }
        }
        return search(root.left, subRoot) || search(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}