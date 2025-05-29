// Problem: N-ary Tree Postorder Traversal
// Link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
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
    public List<Integer> postorder(Node root) {
        if(root == null){
            return list;
        }
        for(Node node : root.children){
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
}