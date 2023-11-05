package recursion;

public class s_printKeyCombination_level_and_Options {

    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno","pqrs","tu","vwx", "yz"};

    public static void main(String[] args) {
        String str = "678";
        printKeyCombo(str, "");
    }

    static void printKeyCombo (String ques, String ans){
        if (ques.equals("")) {
            System.out.println(ans);
            return;
        }

        int ch = ques.charAt(0);
        int chInt = ch - '0';

        for ( int i = 0 ; i < codes[chInt].length(); i++) {
            char c = codes[chInt].charAt(i);
            printKeyCombo(ques.substring(1), ans + c);
        }
    }
}
