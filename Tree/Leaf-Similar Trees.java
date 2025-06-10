// Problem: Leaf-Similar Trees
// Link: https://leetcode.com/problems/leaf-similar-trees/description/
// Approach: Tree

package Tree;
import java.util.*;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();    
        List<Integer> list2 = new ArrayList<>();

        leafValues(root1, list1);
        leafValues(root2, list2);

        return list1.equals(list2);
    }
    public void leafValues(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        leafValues(root.left, list);
        leafValues(root.right, list);
    }
}