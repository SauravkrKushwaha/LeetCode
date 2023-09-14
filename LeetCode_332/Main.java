package LeetCode_332;
import java.util.*;
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
        // Build the graph
        for (int i = 0; i < tickets.size(); i++) {
            String key = tickets.get(i).get(0);
            String value = tickets.get(i).get(1);

            if (!hm.containsKey(key)) {
                PriorityQueue<String> temp = new PriorityQueue<>();
                hm.put(key, temp);
            }

            hm.get(key).add(value);
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", hm, res);
        return res;
    }
    public void dfs(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
        PriorityQueue<String> arrivals = hm.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), hm, res);
        }
        res.addFirst(dep);
    }
}
public class Main {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        Solution solution = new Solution();
        List<String> itinerary = solution.findItinerary(tickets);

        System.out.println("Itinerary: " + itinerary);
    }
}