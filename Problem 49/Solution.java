/* Solution 1*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();;
        int n = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
        
       for(String word : strs){
           String sorted = sorted(word);
           if(!map.containsKey(sorted)){
               map.put(sorted,new ArrayList<>());
           }
            map.get(sorted).add(word);
        }
        
        return new ArrayList<>(map.values());
        
    }
    
    public String sorted(String word){
        char[] toChar = word.toCharArray();
        Arrays.sort(toChar);
        return String.valueOf(toChar);
    }
}
 
/**
  * Time Complexity : O (N * (K log K))  [k log(k) => sorting the word]
  * Space Complexity : O(N * K)
  * N = nuuber of words K= Avg. Length of each word
*/


/* Prime Product Solution */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();;
        int n = strs.length;
        HashMap<Double, List<String>> map = new HashMap<>();
        
       for(String word : strs){
           double pp = primeProduct(word);
           if(!map.containsKey(pp)){
               map.put(pp,new ArrayList<>());
           }
            map.get(pp).add(word);
        }
        
        return new ArrayList<>(map.values());
        
    }
    
    public Double primeProduct(String word){
        int [] prime = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101};
        char[] toChar = word.toCharArray();
        double pp = 1;
        for(char c : toChar){
            pp *= prime[c - 'a'];
        }
        return pp;
    }
}

/**
  * Time Complexity : O (N * K)  [k log(k) => sorting the word]
  * Space Complexity : O(N * K)
  * N = nuuber of words K= Avg. Length of each word
*/
