package LeetCode_1282;
import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> groups = new HashMap<>();
        for(int i = 0;i<groupSizes.length;i++){
            int size = groupSizes[i];
            if(!groups.containsKey(size)){
                groups.put(size,new ArrayList<>());
            }
            groups.get(size).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int size : groups.keySet()){
            List<Integer> people = groups.get(size);
            List<Integer> tempGroup = new ArrayList<>();
            for (int person : people) {
                tempGroup.add(person);
                if (tempGroup.size() == size) {
                    result.add(new ArrayList<>(tempGroup));
                    tempGroup.clear();
                }
            }
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};

        Solution solution = new Solution();
        List<List<Integer>> result = solution.groupThePeople(groupSizes);

        // Print the result
        for (List<Integer> group : result) {
            System.out.println(group);
        }
    }
}
