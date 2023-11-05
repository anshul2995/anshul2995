import java.util.HashMap;
import java.util.Map;

class abc09{
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println("Longest length of the subarray which contains all the unqiue characters in it:"+longestSubstrDistinctChars(s));
    }

    static int longestSubstrDistinctChars(String s){
        
        int i =0, j=0;
        int size = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        while (j<size){
            char ch = s.charAt(j);
            
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
            
            if (map.size() == j-i+1){
                max = Math.max(max, j-i+1);
                j++;
            } else if (map.size() < j-i+1) { //window contain some characters which are not unique
                while (map.size() < j-i+1){
                    char charAtI = s.charAt(i);
                    int freqAtI = map.get(charAtI);
                    freqAtI -- ;
                    map.put(charAtI, freqAtI);
                    
                    if(map.get(charAtI) == 0)
                        map.remove(charAtI);
                    
                    i++;
                }
                j++;
            }
        }
        return max;   
    }
}
