package LeetCode_136;
class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 4, 3, 2};
        int result = solution.singleNumber(nums);
        System.out.println(result);
    }
}
