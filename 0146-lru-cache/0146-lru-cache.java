import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value); 
        } else {
            if (map.size() == capacity) {
                
                int lrukey = map.entrySet().iterator().next().getKey();
                map.remove(lrukey);
            }
            map.put(key, value);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */