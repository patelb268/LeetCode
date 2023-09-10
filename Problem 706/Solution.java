class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] nodes;
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    public int hashFunction(int key) {return Integer.hashCode(key) % buckets;}
    
    public Node find(Node node,int key){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key){
            prev = curr;
            curr= curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hashFunction(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node node = find(nodes[index],key);
        if(node.next == null){
             node.next = new Node (key,value);
        }else{
            node.next.val = value;
        }
      }
    
    public int get(int key) {
        int index = hashFunction(key);
        if(nodes[index] == null){
            return -1;
        }
        Node node = find(nodes[index],key);
        if(node.next == null){
             return -1;
        }else{
            return node.next.val;
        }
    }
    
    public void remove(int key) {
        int index = hashFunction(key);
        if(nodes[index] == null){
            return;
        }
        Node node = find(nodes[index],key);
        if(node.next == null){
             return;
        }else{
            node.next = node.next.next;
        }
    }
}


/**
  * Time complexity: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
  * Space complexity: O(n) - where n is the number of entries in HashMap
*/

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
