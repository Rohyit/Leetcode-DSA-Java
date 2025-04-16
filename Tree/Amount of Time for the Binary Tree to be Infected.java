// Problem: Amount of Time for the Binary Tree to be Infected
// Link: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
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
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        TreeNode startNode = mapParents(root, null, start);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        visited.add(startNode);

        int minutes = -1;

        while(!queue.isEmpty()){
            int size = queue.size();
            minutes++;
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();

                if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                if(current.right != null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                TreeNode parent = parentMap.get(current);
                if(parent != null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
        }
        return minutes;
    }

    private TreeNode mapParents(TreeNode node, TreeNode parent, int start){
        if(node==null){
            return null;
        }
        if(parent!= null){
            parentMap.put(node, parent);
        }
        if(node.val==start){
            return node;
        }

        TreeNode left = mapParents(node.left, node, start);
        TreeNode right = mapParents(node.right, node, start);

        return left != null ? left : right;
    }
}