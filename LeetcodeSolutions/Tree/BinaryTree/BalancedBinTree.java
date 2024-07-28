package Trees.BinaryTree;

import javax.swing.tree.TreeNode;

public class BalancedBinTree {
       
    // Brute Force - Top-down recursion
    public boolean isBalanced(TreeNode root){
        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }




    // Bottom-Up recursion
    public boolean isBalancedBUp(TreeNode root){
        return maxDepth(root) != 1;
    }


    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        int L = maxDepth(root.left);
        if(L == -1) return -1;
        int R = maxDepth(root.right);
        if(R == -1) return -1;
        return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
    }
}
