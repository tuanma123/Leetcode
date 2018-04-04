import java.util.HashMap;
import java.util.Map;

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
}