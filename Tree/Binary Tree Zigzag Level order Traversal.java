// Problem: Binary Tree Zigzag Level order Traversal
// Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();

            for(int i=0; i<level; i++){
                TreeNode node = queue.poll();
                
                if(leftToRight){
                    sublist.add(node.val);
                }
                else{
                    sublist.addFirst(node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(sublist);
            leftToRight = !leftToRight;
        }
        return list;
    }
}