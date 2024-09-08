import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }    
}

public class BuildTree {
    public static TreeNode buildTree(int[] arr){
        if(arr.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if(idx < arr.length){
                node.left = new TreeNode(arr[idx++]);
                q.add(node.left);
            }

            if(idx < arr.length){
                node.right = new TreeNode(arr[idx++]);
                q.add(node.right);
            }
        }

        return root;
        
    }

    public static void displayTree(TreeNode root){
        if(root == null){
            return;
        }

        displayTree(root.left);
        System.out.print(" "+root.data);
        displayTree(root.right);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };

        TreeNode root = buildTree(nums);
        
        displayTree(root);
    }
}
