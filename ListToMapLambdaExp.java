import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ListToMapLambdaExp {
    public static void main(String[] args) {

        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> res = new HashMap<String, String>();
        res.put("abc", "1");
        res.put("def", "1");
        res.put("ghi", "2");

        list.add(res);

        Map<String, String> res1 = new HashMap<String, String>();
        res.put("abc1", "11");
        res.put("def1", "11");
        res.put("ghi1", "21");
        
        list.add(res1);

        System.out.println(list);
        System.out.println();

        Map<String, List<String>> ans = list.stream().flatMap(i -> i.entrySet().stream()).collect(
        Collectors.groupingBy(
            Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toList())));

        System.out.println(ans);
    }
}
