// Problem: Construct Binary Search Tree from Preorder Traversal
// Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    public TreeNode bst(int[] preorder, int val, int[] i){
        if(i[0] == preorder.length || preorder[i[0]] > val){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bst(preorder, root.val, i);
        root.right = bst(preorder, val, i);
        return root;
    }
}