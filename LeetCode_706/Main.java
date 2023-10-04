package LeetCode_706;
import java.util.*;
class MyHashMap {

    private static final int CAPACITY = 10000; // You can choose a different capacity as needed.

    private LinkedList<Entry>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[CAPACITY];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists in the bucket and update the value if found.
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If the key doesn't exist in the bucket, add a new entry.
        buckets[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return -1; // Key not found.
        }

        // Search for the key in the bucket and return its value if found.
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1; // Key not found.
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return; // Key not found, nothing to remove.
        }

        // Search for the key in the bucket and remove it if found.
        Iterator<Entry> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private int getIndex(int key) {
        return key % CAPACITY;
    }

    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        System.out.println("put(1, 1)");
        hashMap.put(1, 1);
        System.out.println("put(2, 2)");
        hashMap.put(2, 2);
        System.out.println("get(1): " + hashMap.get(1)); // Output should be 1
        System.out.println("get(3): " + hashMap.get(3)); // Output should be -1
        System.out.println("put(2, 1)");
        hashMap.put(2, 1);
        System.out.println("get(2): " + hashMap.get(2)); // Output should be 1
        System.out.println("remove(2)");
        hashMap.remove(2);
        System.out.println("get(2): " + hashMap.get(2)); // Output should be -1
    }
}


