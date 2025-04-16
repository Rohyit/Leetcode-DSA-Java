// Problem: All Nodes Distance k in Binary Tree
// Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            if(currLevel == k){
                break;
            }
            currLevel++;

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left)==null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right)==null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current))==null){
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            list.add(current.val);
        } 
        return list;
    }

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode target){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left!=null){
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right!=null){
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
    } 
}