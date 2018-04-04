import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    /**
     * Medium
     *
     * In English, we have a concept called root, which can be followed by some other words to form another longer word
     * - let's call this word successor. For example, the root an, followed by other, which can form another word
     * another.
     *
     * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the
     * sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the
     * shortest length.
     *
     * You need to output the sentence after the replacement.
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        StringBuilder newSentence = new StringBuilder();

        for (int x = 0; x < tokens.length; x++) {
            for (String root : dict) {
                if (tokens[x].startsWith(root)) {
                    tokens[x] = root;
                }
            }
        }

        for (int x = 0; x < tokens.length; x++) {
            if (x == 0) {
                newSentence.append(tokens[x]);
            } else {
                newSentence.append(" " + tokens[x]);
            }
        }

        return newSentence.toString();
    }
}
