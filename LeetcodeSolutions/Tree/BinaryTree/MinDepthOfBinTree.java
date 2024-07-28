package Trees.BinaryTree;

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class MinDepthOfBinTree {
    
    // DepthFirst traversal
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right));
    }


    // BreadthFirst traversal
    public int minDepthBreadth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightMost = root;
        int depth = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left == null && node.right == null)break;
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            if(node == rightMost){
                depth++;
                rightMost = (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }
}
