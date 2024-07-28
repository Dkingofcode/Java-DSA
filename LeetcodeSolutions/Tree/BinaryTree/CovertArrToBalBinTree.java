package Trees.BinaryTree;

import javax.swing.tree.TreeNode;

public class CovertArrToBalBinTree {
    public TreeNode sortedArraytoBST(int[] num){
        return sortedArraytoBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArraytoBST(int[] arr, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArraytoBST(arr, start, mid - 1);
        node.right = sortedArraytoBST(arr, mid - 1, end);
        return node;
    }

    
}
