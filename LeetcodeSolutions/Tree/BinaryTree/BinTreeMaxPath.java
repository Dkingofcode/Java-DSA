package Trees.BinaryTree;

public class BinTreeMaxPath {
    
    private int maxSum;

    public int maxPathSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode root){
        if(root == null) return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);
        maxSum = Math.max(root.val + left + right, maxSum);
        int ret = root.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }
}
