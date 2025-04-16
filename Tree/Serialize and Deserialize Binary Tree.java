// Problem: Serialize and Deserialize Binary Tree
// Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
// Approach: Tree

package Tree;
import java.util.*;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                sb.append("# ");
                continue;
            }
            sb.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);

        for(int i=1; i<arr.length; i++){
            TreeNode parent = queue.poll();

            if(!arr[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                queue.add(left);
            }
            if(++i<arr.length && !arr[i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}