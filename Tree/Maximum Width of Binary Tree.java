// Problem: Maximum Width of Binary Tree
// Link: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
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
    class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0, last = 0;

            for(int i = 0; i<size; i++){
                int curr = queue.peek().index - min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0){
                    first = curr;
                }
                if(i==size-1){
                    last = curr;
                }
                if(node.left != null){
                    queue.offer(new Pair(node.left, curr*2+1));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, curr*2+2));
                }
            } 
            width = Math.max(width, last-first+1);
        }
        return width;
    }
}