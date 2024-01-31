package LeetCode_739;
import java.util.*;

public class Main {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        int[] temperatures1 = {73,74,75,71,69,72,76,73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println(Arrays.toString(result1));

        int[] temperatures2 = {30,40,50,60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println(Arrays.toString(result2));

        int[] temperatures3 = {30,60,90};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println(Arrays.toString(result3));
    }
}
