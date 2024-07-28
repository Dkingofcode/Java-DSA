package Trees.BinaryTree;

public class BinTreeUpsidedown {
    
    // Top down Approach
    public TreeNode UpsideDownBinaryTree(TreeNode root){
        TreeNode p = root, parent = null, parentRight = null;
        while(p != null){
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p.left;
        }
        return parent;
    }


    // Bottom Up Approach
    public TreeNode dfsBottomUp (TreeNode p, TreeNode parent){
        if(p == null) return parent;
         TreeNode root = dfsBottomUp(p.left, p);
         p.left = (parent == null) ? parent : parent.right;
         p.right = parent;
         return root;
    }



}
