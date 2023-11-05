import java.util.HashMap;
import java.util.Map;

class abc12345 {

    public static void main(String[] args) {
    
        String s = "aabacbebebe" ;
        int k = 3; //k unique characters
        int length = s.length();
        
        int max = 0, i =0, j=0;
        Map<Character, Integer> map = new HashMap<>();

        while( j< length) {
            char ch = s.charAt(j);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch, 1);
            }

            if (map.size() < k){
                j++;
            }
            else if(map.size() == k){
                max = Math.max(max, j-i+1);
                j++;
            }
            else {
                while(map.size() > k) {
                    char ithChar = s.charAt(i);
                    int ithCharFreq = map.get(ithChar);
                    ithCharFreq--;
                    map.put(ithChar, ithCharFreq--);

                    if(map.get(ithChar) == 0){
                        map.remove(ithChar);
                    }
                    i++;
                }
            j++;
            }
        }
        System.out.println("Size of the longest substring of k unique characater is"+max);
    }
}