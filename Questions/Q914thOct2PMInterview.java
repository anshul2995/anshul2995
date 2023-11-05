package Questions;

public class Q914thOct2PMInterview {

    public static void main(String[] args) {

//        String str1 = "gram";
//        //[1, 0 , 1, 1, 1,0,0,0];
//        String str2 = "armg";
//
//
//        if (str1.length() != str2.length()){
//            return;
//        }
//
//        int[] count = new int[26];
//        Arrays.fill(count, 1);
//
//        for (int i = 0 ; i < str1.length(); i++){
//            char ch = str1.charAt(i);
//            char ch2 = str2.charAt(i);
//            count[ch-'a']++;
//            count[ch2-'a']--;
//        }
//
////        for (int i = 0 ; i < str2.length(); i++){
////            char ch = str2.charAt(i);
////            count[ch-'a']--;
////        }
//
//        for (int i = 0 ; i < count.length; i++){
//            if (count[i]!=0) {
//                System.out.println("Not a anagram");
//                return;
//            }
//        }
//        System.out.println("Anagram");


        //String str = "Ab,cd,e$&";
        //output= ed,cb,A$&

        String str1 = "A$&b,cd,e";
//      e$&d,cb,a

//
        char[] chArray = str1.toCharArray();
        int i = 0, j = chArray.length - 1;

        String newStr = "";

        while (i <= j) {
            char chI = chArray[i];
            char chJ = chArray[j];
            boolean flagI = false, flagJ = false;
            if (!((chI >= 'A' && chI <= 'Z') || (chI >= 'a' && chJ <= 'z'))) {
                flagI = true;
                i++;
            }
            if (!((chJ >= 'A' && chJ <= 'Z') || (chJ >= 'a' && chJ <= 'z'))) {
                flagJ = true;
                j--;
            }
            if (!flagI && !flagJ) {
                char temp = chArray[i];
                chArray[i] = chJ;
                chArray[j] = temp;
                i++;
                j--;
            }
        }


        System.out.println(new String(chArray));

//        list.stream()
//                .sort((Employee e1, Employee e2) -> {
//                    if (e1.getSalary() - e2.getSalary() == 0)
//                        return e2.getDesgination() - e1.getDesgination()
//                    else
//                        return e1.getSalary() - e2.getSalary()
//                })
//    }

    }
}

//Employee {
//    id,
//            name,
//            List < Department > d
//}
//
//Deparment {
//    id,
//    String name;
//}
//
//
//
//
//Employee
//       1 1
//       1 2
//       2 1
//
//
//Deparment
//     1 HR
//`