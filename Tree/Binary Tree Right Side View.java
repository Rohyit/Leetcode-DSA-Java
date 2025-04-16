// Problem: Vertical order Traversal of Binary Tree
// Link: https://leetcode.com/problems/binary-tree-right-side-view/description/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightView(root, list, 0);
        return list;
    }
    private void rightView(TreeNode node, List<Integer> list, int level){
        if(node==null){
            return;
        }
        if(level==list.size()){
            list.add(node.val);
        }
        rightView(node.right, list, level+1);
        rightView(node.left, list, level+1);
    }
}