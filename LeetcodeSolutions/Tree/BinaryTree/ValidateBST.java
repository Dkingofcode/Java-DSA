package Trees.BinaryTree;

import javax.swing.tree.TreeNode;

public class ValidateBST {

    // Brute force
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;
        return isSubTreeLessThan(root.left, root.val) && isSubTreeGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isSubTreeLessThan(TreeNode p, int val){
        if(p == null) return true;
        return p.val < val && isSubTreeLessThan(p.left, val) && isSubTreeLessThan(p.right, val);
    }

    private boolean isSubTreeGreaterThan(TreeNode p, int val){
        if(p == null) return true;
        return p.val > val && isSubTreeGreaterThan(p.left, val) && isSubTreeGreaterThan(p.right, val);
    }




    // Top-down Recursion
    public boolean isValidBSTdownReecursion(TreeNode root){
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode p, int low, int high){
        if(p == null) return true;

        return p.val > low && p.val < high && valid(p.left, low, p.high) && valid(p.right, p.val, high);
    }

    // Note: If the tree contains the smallest and largest integer values, use null as infinity


     // Inorder Traversal
     private TreeNode prev;
     public boolean isValidBST(TreeNode root){
        prev = null;
        return isMonotonicIncreasing(root);

        private boolean isMonotonicIncreasing(TreeNode p){
            if(p == null) return true;
            if (isMonotonicIncreasing(p.left)){
                if(prev != null && p.val <= prev.val) return false;
                prev = p;
                return isMonotonicIncreasing(p.right);
            }
            return false;
        }
     }


}






