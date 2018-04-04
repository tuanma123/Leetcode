import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution {

    /**
     * Easy
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int x = 0; x < nums.length / 2; x++) {
            sum += nums[x * 2];
        }

        return sum;
    }

    /**
     * Easy
     *
     * Write a function that takes a string as input and returns the string reversed.
     * @param s
     * @return
     */
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for(int x = s.length() - 1; x >= 0; x--) {
            result.append(s.charAt(x));
        }

        return result.toString();
    }
}
