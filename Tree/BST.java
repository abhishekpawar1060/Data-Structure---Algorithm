import java.util.ArrayList;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right; 
        Node(int data){
            this.data = data;
        } 
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root){ //O(H)
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }



    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return search(root.left, key);
        }
        
        else if (key > root.data){
            return search(root.right, key);
        } 
        
        return false;
    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            return null;
        }

        if(root.data > val){
            root.left = deleteNode(root.left, val);
        }

        else if(root.data < val){
            root.right = deleteNode(root.right, val);
        }

        else{  //(root == val)
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3
            Node inorderSuccessor = InorderSuccessor(root.right, val);
            root.data = inorderSuccessor.data;
            root.right = deleteNode(root.right, inorderSuccessor.data);
        }

        return root;
    }


    public static Node InorderSuccessor(Node root, int val){
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void PrintInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <= y){
            PrintInRange(root.left, x, y);
            System.out.print(root.data+" ");
            PrintInRange(root.right, x, y);
        }
        else if (root.data >= y) {
            PrintInRange(root.left, x, y);
        }
        else{
            PrintInRange(root.right, x, y);
        }
    }

    public static void RootToLeafPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            RootToLeafPath(root.left, path);
            RootToLeafPath(root.right, path);
        }
        
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for (Integer it : path) {
            System.out.print(it+"->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] val = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int it : val) {
            root = insert(root, it);
        }

        inOrder(root);
        
        System.out.println();
        
        System.out.println("Found : " +search(root, 7));

        deleteNode(root, 3);

        inOrder(root);
        System.out.println();

        PrintInRange(root, 1, 5);
        System.out.println();

        RootToLeafPath(root, new ArrayList<>());
    } 
}