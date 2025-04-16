// Problem: Construct Binary Tree from PostOrder and Inorder Traversal
// Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
// Approach: Tree

package Tree;
import java.util.*;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inMap);

        return root;
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inRoot-inStart;

        root.left = build(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inRoot-1, inMap);
        root.right = build(postorder, postStart+numsLeft, postEnd-1, inorder, inRoot+1, inEnd, inMap);

        return root;
    }
}