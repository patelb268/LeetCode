/* using HashMap */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();
        
        
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            //check for s->t mapping
            if(sMap.containsKey(charS) && sMap.get(charS) != charT ){
                return false;
            }
            else{
                sMap.put(charS,charT);
            }

            //check for t->s mapping
            if(tMap.containsKey(charT) && tMap.get(charT) != charS ){
                return false;
            }
            else{
                tMap.put(charT,charS);
            }
        }
        return true;
        
    }
}

/* using constant space char array */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        char [] S = new char[100];
        char [] T = new char[100];
        
        
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            //check for s->t mapping
            if(S[charS - ' '] != 0 && S[charS - ' '] != charT){
                return false;
            }
            else{
                S[charS - ' '] = charT;   
            }

            //check for t->s mapping
            if(T[charT - ' '] != 0 && T[charT - ' '] != charS){
               return false;
            }
            else{
               T[charT - ' '] = charS;
            }
        }
        return true;
        
    }
}


/**
  * Time Complexity : O(N)
  * Space Complexity : O(1)
  */
