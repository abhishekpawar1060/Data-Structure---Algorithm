// package DataStructureAndAlgorithm.LinkedList;
public class singleLinkedListImplementation {

    public Node head = null;
    public Node tail = null;
    public int size = 0;
    
    class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
            this.next = null;

        }
    }    
    public  void addFirst(int val){
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }

        size++;

    }

    public void addLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }

        else{
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        size++;
    }

    public int removeFromFirst(){
        if(head == null){
            return -1;
        }

        int remove = head.val;
        head = head.next;

        size--;

        return remove;

    }

    public int removeFromLast(){
        if(head == null){
            return -1;
        }

        if(head.next == null){
            int remove = head.val;
            head = null;
            size--;
            return remove;
        }
        Node currNode = head;
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }

        int remove = currNode.next.val;
        currNode.next = null;
        size--;

        return remove;
    }


    public void display(){
        if(head == null){
            System.out.println("Empty Linked List");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val+ " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }


    public int size(){
        return size;
    }

    public static void main(String[] args) {
        singleLinkedListImplementation list = new singleLinkedListImplementation();

        list.addLast(4);
        list.addLast(5);

        list.addFirst(1);
        list.addFirst(0);

        list.display();

        System.out.println(list.removeFromLast());

        list.display();

        System.out.println(list.removeFromFirst());

        list.display();

        System.out.println(list.size());
    }

    
}