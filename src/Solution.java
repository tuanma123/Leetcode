import java.util.*;

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

    /**
     * Medium
     *
     * Given an input string, reverse the string word by word.
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int start = 0;
        if (s.startsWith(" ")) {

            for (int y = 0; y < s.length(); y++) {
                if (s.charAt(y) != ' ') {
                    break;
                }
                start++;
            }
         }
        s = s.substring(start, s.length());

        String[] tokens = s.split(" ");
        StringBuilder sentence = new StringBuilder();

        for (int x = tokens.length - 1; x >= 0; x--) {
            if (x == 0) {
                sentence.append(tokens[x]);
            } else {
                sentence.append(" " + tokens[x]);
            }
        }

        return sentence.toString();
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        if (s.length() <= 1) {
            return s.length();
        }

        for (int x = 0; x < s.length(); x++) {
            Set<Character> seen = new HashSet<>();
            seen.add(s.charAt(x));

            int y = x + 1;
            while (y < s.length() && !seen.contains(s.charAt(y))) {
                seen.add(s.charAt(y));
                y++;

            }

            if (seen.size() > maxLength) {
                maxLength = seen.size();
            }
        }

        return maxLength;
    }

    /**
     * Merge k sorted linked lists and return it as one sorted list.
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        for (ListNode list : lists) {
            while(list != null) {
                heap.add(list.val);
                list = list.next;
            }
        }

        if (heap.size() > 0) {
            ListNode sorted = new ListNode(heap.poll());

            while (!heap.isEmpty()) {
                ListNode newNode = new ListNode(heap.poll());

                newNode.next = sorted;
                sorted = newNode;

            }

            return sorted;
        } else {
            return null;
        }
    }
}
