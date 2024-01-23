public class stackImp {
    public int size;
    public Node head;

    class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public stackImp(){
        this.size = 0;
    }

    public void push(int val){
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

    public int pop(){
        if(head == null){
            return 0;
        }
        int removed = head.val;
        head = head.next;

        size--;

        return removed;
    }

    public int peek(){
        if(head == null){
            return 0;
        }
        int peek = head.val;

        return peek;
    }

    public boolean isEmpty(){
        if(head == null){
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
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val+ " ");
            curr = curr.next;
        }
    }


    public static void main(String[] args) {

        stackImp st = new stackImp();

        st.push(1);
        st.push(4);
        st.push(8);
        st.push(9);
        st.push(41);
        st.push(26);

        st.display();
        System.out.println();

        System.out.println("Peek element in Stack is : " +st.peek());

        System.out.println("Size of Stack is : " +st.size());
        System.out.println("isEmpty Or Not : " +st.isEmpty());

        System.out.println("Removed element in stack is : " +st.pop());

        
    }
}
