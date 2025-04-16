// Problem: Vertical order Traversal of Binary Tree
// Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
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
    class Tuple{
        int row, col, val;
        Tuple(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Tuple> list = new ArrayList<>();
        dfs(root, 0, 0, list);

        Collections.sort(list, (a, b) -> {
            if(a.col != b.col){
                return a.col-b.col;
            }
            else if(a.row != b.row){
                return a.row-b.row;
            }
            else{
                return a.val-b.val;
            }
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        
        for(Tuple t : list){
            if(t.col != prevCol){
                result.add(new ArrayList<>());
                prevCol = t.col;
            }
            result.get(result.size()-1).add(t.val);
        }

        return result;
    }
    private void dfs(TreeNode node, int row, int col, List<Tuple> list){
        if(node==null){
            return;
        }
        list.add(new Tuple(row, col, node.val));
        dfs(node.left, row+1, col-1, list);
        dfs(node.right, row+1, col+1, list);
    }
}