package recursion;

public class r_printSubsequence_level_And_Options {

    public static void main(String[] args) {
        String s = "abc";
        printAllSubsequence(s, "");
    }

    static void printAllSubsequence(String ques, String ans) {

        if (ques.equals("")){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        printAllSubsequence(ques.substring(1), ans + ch);  // Yes
        printAllSubsequence(ques.substring(1), ans + "");  // No
    }
}
