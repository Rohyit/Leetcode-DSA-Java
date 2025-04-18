// Problem: Construct Binary Tree from PreOrder and Inorder Traversal
// Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// Approach: Tree

package Tree;
import java.util.*;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);

        return root;
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot-inStart;

        root.left = build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = build(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);

        return root;
    }
}