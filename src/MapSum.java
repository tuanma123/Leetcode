import java.util.*;
import java.util.Map.Entry;

class MapSum {

    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        this.map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for(String s : this.map.keySet()) {
            if (s.startsWith(prefix)) {
                sum += this.map.get(s);
            }
        }

        return sum;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for(int x = 0; x < result.length; x++) {
            result[x] = 1;
        }


        return result;
    }


    /**
     * Medium
     *
     * Given a string, sort it in decreasing order based on the frequency of characters.
     * @param s
     * @return
     */

    public String frequencySort(String s) {

        class MapComparator implements Comparator<Map.Entry<Character, Integer>> {
            public int compare(Map.Entry<Character, Integer> c1, Map.Entry<Character, Integer> c2) {
                return c1.getValue().compareTo(c2.getValue());
            }
        }

        Map<Character, Integer> map = new TreeMap(new MapComparator());
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
               map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        StringBuilder string = new StringBuilder();

        for (Character c : map.keySet()) {
            for (int x = 0; x < map.get(c); x++) {
                string.append(c);
            }
        }

        return s.toString();
    }
}