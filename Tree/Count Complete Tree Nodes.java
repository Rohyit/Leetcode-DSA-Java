// Problem: Count Complete Tree Nodes
// Link: https://leetcode.com/problems/count-complete-tree-nodes/description/
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        if(left == right){
            int x = (int)Math.pow(2, left);
            return x-1;
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }

    private int getHeightLeft(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }

    private int getHeightRight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }
}