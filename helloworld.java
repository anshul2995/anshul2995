import java.util.*;
class HelloWorld {
    public static void main(String[] args) {

        int ans = getAns(new int[]{127,15,3,8,10});

        System.out.println(ans);
    }

    private static int getAns(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }

        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (!set.contains(value)) {
                set.add(value);
            } else {
                while (set.contains(value)) {
                    value--;
                    ans++;
                }
                if (value != 0)
                    set.add(value);
            }
        }
        return ans;
    }
}
