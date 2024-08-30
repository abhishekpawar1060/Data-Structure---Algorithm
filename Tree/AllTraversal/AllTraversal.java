
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversal {
    public static class Node{
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
        int idx = -1;
        public Node buildTree(int[] node){
            idx++;
            if(node[idx] == -1){
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;
        }
    }



    public static List<Integer> iterativePreOrder(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            int size = s.size();
            for(int i = 0; i < size; i++){
                Node node = s.pop();
                res.add(node.data);

                if(node.right != null){
                    s.push(node.right);
                }
                if(node.left != null){
                    s.push(node.left);
                }
            }
        }
        return res;
    }


    public static List<Integer> iterativeInOrder(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<Node> s = new Stack<>();
        Node node = root;
        while (true) {
            if(node != null){
                s.push(node);
                node = node.left;
            }else{
                if(s.isEmpty()){
                    break;
                }
                node = s.pop();
                res.add(node.data);
                node = node.right;
            }
        }

        return res;
    }

    public static List<Integer> iterativePostOrder(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        // Stack<Node> s1 = new Stack<>();
        // Stack<Node> s2 = new Stack<>();
        
        // s1.push(root);

        // while(!s1.isEmpty()){
        //     root = s1.pop();
        //     s2.push(root);
        //     if(root.left != null){
        //         s1.push(root.left);
        //     }
        //     if(root.right != null){
        //         s1.push(root.right);
        //     }
        // }

        // while(!s2.isEmpty()){
        //     res.add(s2.pop().data);
        // }


        // By Using the 1 Stack
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (curr != null || !s.isEmpty()) {
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }else{
                Node temp = s.peek().right;
                if(temp == null){
                    temp = s.pop();
                    res.add(temp.data);
                    while(!s.isEmpty() && temp == s.peek().right){
                        temp = s.pop();
                        res.add(temp.data);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        int[] node = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BiTree tree = new BiTree();
        Node root = tree.buildTree(node);

        System.out.println(iterativePreOrder(root));
        System.out.println(iterativeInOrder(root));
        System.out.println(iterativePostOrder(root));
    }
}
