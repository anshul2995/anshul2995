package recursion;

public class v_permutation_level_and_options {

    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, "");
    }

    static void printPermutation(String ques, String ans) {

        if (ques.equals("")){
            System.out.println(ans);
            return;
        }

        for (int i = 0 ; i < ques.length(); i++){
            char ch = ques.charAt(i);

            String newQues = ques.substring(0, i) + ques.substring(i+1);
            printPermutation(newQues, ans + ch);
        }
    }
}
