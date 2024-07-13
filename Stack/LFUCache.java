import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    final int capacity;
    int currSize;
    int minFreq;
    Map<Integer, DDLNode> cache;
    Map<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    class DDLNode{
        int key, val, freq;
        DDLNode next, prev;

        public DDLNode(int key, int value){
            this.key = key;
            this.val = value;
            this.freq = 1;
        }
    }

    class DoubleLinkedList{
        int listSize;
        DDLNode head, tail;
        public DoubleLinkedList(){
            this.listSize = 0;
            this.head = new DDLNode(0,0);
            this.tail = new DDLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DDLNode currNode){
            DDLNode nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listSize++;
        }

        public void removeNode(DDLNode currNode){
            DDLNode prevNode = currNode.prev;
            DDLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

    public int get(int key){
        DDLNode currNode = cache.get(key);
        if(currNode == null){
            return -1;
        }
        updateNode(currNode);
        return currNode.val;
    }

    public void put(int key, int value){
        if(capacity == 0){
            return;
        }

        if(cache.containsKey(key)){
            DDLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }else{
            currSize++;
            if(currSize > capacity){
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }

            minFreq = 1;
            DDLNode newNode = new DDLNode(key, value);

            DoubleLinkedList currList = freqMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DDLNode currNode){
        int currFreq = currNode.freq;
        DoubleLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(currNode);

        if(currFreq == minFreq && currList.listSize == 0){
            minFreq++;
        }

        currNode.freq++;

        DoubleLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoubleLinkedList());
        newList.addNode(currNode);
        freqMap.put(currNode.freq, newList);
    }


    public static void main(String[] args) {
        LFUCache obj = new LFUCache(3);
        
        obj.put(1, 10);
        obj.put(2, 20);
        obj.put(3, 30);
        obj.put(4, 40);
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(4));

        obj.put(5, 50);

        System.out.println(obj.get( 4));
        System.out.println(obj.get( 1));
    }
}
