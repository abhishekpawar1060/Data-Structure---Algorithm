import java.util.HashMap;
import java.util.Map;

class LRUCache{
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    static class Node{
        public Node prev, next;
        int key, value;
        Node(int _key, int _value){
            key = _key;
            value = _value;
        }
    }

    public LRUCache(int _capacity){
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(3);
        
        obj.put(1, 5);
        obj.put(2, 78);
        obj.put(3, 45);
        obj.put(4, 15);
        System.out.println(obj.get(2));

        


    }
}