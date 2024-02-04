public class QueueImpl {

    Node head;
    int size;

    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public void add(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }


    public int remove(){
        if(head == null){
            return -1;
        }

        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        int removed = currNode.next.val;
        currNode.next = null;
        size--;

        return removed;
    }

    public int peek(){
        if(head == null){
            return -1;
        }

        Node currNode = head;
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        int peeked = currNode.next.val;
        return peeked;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }

        return false;
    }

    public int size(){
        return size;
    }

    public void display(){
        if(head == null){
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.val);
            currNode = currNode.next;
        }

    }
    public static void main(String[] args) {
        QueueImpl q = new QueueImpl();

        q.add(4);
        q.add(1);
        q.add(9);
        q.add(2);
        q.add(7);

        q.display();

        System.out.println("Size of Queue : "+q.size());
        System.out.println("Is empty or not : "+q.isEmpty());

        System.out.println("Peek element of queue : "+q.peek());
        System.out.println("removed element of Queue : "+q.remove());
        System.out.println("removed element of Queue : "+q.remove());
        
        System.out.println("Size of Queue : "+q.size());

    }
    
}

