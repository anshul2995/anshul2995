package Questions;

public class Q10SonyIndia {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,8,9,-1,-2,-3};

        int count = 0;
        int i = 0, j = 0;

        while (i < arr.length && j < arr.length-1){
            if (arr[j] - arr[j+1] == -1 || arr[j] - arr[j+1] == 1) {
                j++;
            } else {
                if (j - i > 0)
                    count++;
                j++;
                i = j;
            }
        }
        if (j - i > 0)
            count++;

        System.out.println(count);
    }
}
