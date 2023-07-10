package LeetCode_20;

import java.util.HashMap;
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                char pop = stack.size() != 0 ? stack.pop() : '#';
                if(pop != map.get(curr)){
                    return false;
                }
            }else{
                stack.push(curr);
            }
        }
        return stack.isEmpty();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "(({}))";
        boolean isValid = solution.isValid(input);
        System.out.println("Is the input valid? " + isValid);
    }
}

