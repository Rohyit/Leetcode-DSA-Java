// Problem: N-ary Tree Preorder Traversal
// Link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
// Approach: Tree

package Tree;
import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null){
            return list;
        }
        list.add(root.val);
        for(Node node : root.children){
            preorder(node);
        }
        return list;
    }
}