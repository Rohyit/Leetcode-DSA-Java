// Problem: Search in a Binary Search Tree
// Link: https://leetcode.com/problems/search-in-a-binary-search-tree/description/
// Approach: Tree

package Tree;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val ? root.left : root.right;
        }
        return root;
    }
}