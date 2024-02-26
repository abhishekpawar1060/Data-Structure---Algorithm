import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static class  Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BiTree {
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }   
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(" " +root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(" "+root.data);
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" "+root.data);
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node node = q.remove();
            if(node == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.println(" "+node.data);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }


        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;

    }

    public static int SumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodesSum = SumOfNodes(root.left);
        int rightNodesSum = SumOfNodes(root.right);

        return leftNodesSum + rightNodesSum + root.data;
    }

    public static void main(String[] args) {
        int[] node = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BiTree tree = new BiTree();
        Node root = tree.buildTree(node);
        // System.out.println(root.data);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();

        levelOrder(root);

        System.out.println("Total number of Nodes:" +countOfNodes(root));
        
        System.out.println("Sum of all Nodes:" +SumOfNodes(root));

    }

   
}
