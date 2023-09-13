class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                max += 2;
                set.remove(ch);
            }
        }
        
        if(!set.isEmpty()) max += 1;
        return max;
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity: O(1)
  */
