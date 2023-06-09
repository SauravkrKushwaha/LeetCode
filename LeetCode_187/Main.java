package LeetCode_187;
import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<=s.length()-10;i++){
            String substring = s.substring(i,i+10);
            map.put(substring,map.getOrDefault(substring,0)+1);
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> item : map.entrySet()){
            if(item.getValue()>1){
                list.add(item.getKey());
            }
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example input string
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        // Find repeated DNA sequences
        List<String> repeatedSequences = solution.findRepeatedDnaSequences(input);
        // Print the repeated sequences
        for (String sequence : repeatedSequences) {
            System.out.println(sequence);
        }
    }
}

