class MyHashSet {
    boolean [][] hashset;
    int buckets = 1000;
    int bucketsItems = 1001;
    public MyHashSet() {
        hashset = new boolean[buckets][];
    }
    
    public void add(int key) {
        int hf1 = key % buckets;
        int hf2 = key / bucketsItems;
        if(hashset[hf1] == null){
            hashset[hf1] = new boolean [bucketsItems];    
        }
        hashset[hf1][hf2] = true;
    }
    
    public void remove(int key) {
        int hf1 = key % buckets;
        int hf2 = key / bucketsItems;
        if(hashset[hf1] == null || hashset[hf1][hf2] == false){
            return;
        }
        hashset[hf1][hf2] = false ;
    }
    
    public boolean contains(int key) {
        int hf1 = key % buckets;
        int hf2 = key / bucketsItems;
        if(hashset[hf1] == null || hashset[hf1][hf2] == false){
            return false;
        }
        return true;
    }
}
/** 
  *Time complexity O(1) for each Operation
  *Space Complexity o(K + M) where K = number of Buckets and M = number of BucketsItems 
*/

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
