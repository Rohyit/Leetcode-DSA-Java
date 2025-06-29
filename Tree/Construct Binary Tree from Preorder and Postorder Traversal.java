// Problem: Construct Binary Tree from Preorder and Postorder Traversal
// Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
// Approach: Tree

package Tree;
import java.util.*;

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int preIndex = 1;
        int postIndex = 0;

        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            
            if(curr.val == postorder[postIndex]){
                stack.pop();
                postIndex++;
            }
            else{
                TreeNode newNode = new TreeNode(preorder[preIndex++]);
                if(curr.left == null){
                    curr.left = newNode;
                }
                else{
                    curr.right = newNode;
                }
                stack.push(newNode);
            }
        }
        return root;
    }
}