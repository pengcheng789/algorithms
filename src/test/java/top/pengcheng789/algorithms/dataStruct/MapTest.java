package top.pengcheng789.algorithms.dataStruct;

import top.pengcheng789.algorithms.map.HashMap;

import java.util.Map;

/**
 * @autor pen
 */
public class MapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zhigu", "bolin");
        map.put("yaomei", "cuiying");
        map.put("fenghua", "run");
        String value = map.remove("zhigu");
        System.out.println("remove: " + value);
        System.out.println("size: " + map.size());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
