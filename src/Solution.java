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

    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};

        for (int x = 0; x < nums.length; x++) {
            if (nums[x] == target) {
                range[0] = x;
                while (x < nums.length && nums[x] == target) {
                    x++;
                }

                range[1] = x;

                return range;
            }
        }

        return range;
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
     * is valid.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Character> parens = constructParenthesisMap();

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.peek() != parens.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public Map<Character, Character> constructParenthesisMap() {
        Map<Character, Character> matchingParens = new HashMap<>();
        matchingParens.put('}', '{');
        matchingParens.put(')', '(');
        matchingParens.put(']', '[');

        return matchingParens;
    }

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right,
     * level by level).
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();


        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();

                int origSize = queue.size();
                for (int x = 0; x < origSize; x++) {
                    TreeNode next = queue.poll();
                    if (next.left != null) {
                        queue.add(next.left);
                    }

                    if (next.right != null) {
                        queue.add(next.right);
                    }

                    level.add(next.val);
                }

                traversal.add(level);
            }
        }

        return traversal;
    }

    /**
     * Given a binary tree, find the leftmost value in the last row of the tree.
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();


        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();

                int origSize = queue.size();
                for (int x = 0; x < origSize; x++) {
                    TreeNode next = queue.poll();
                    if (next.left != null) {
                        queue.add(next.left);
                    }

                    if (next.right != null) {
                        queue.add(next.right);
                    }

                    level.add(next.val);
                }

                traversal.add(level);
            }
        }

        return traversal.get(traversal.size() -1).get(0);
    }

    /**
     * You need to find the largest value in each row of a binary tree.
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                int max;
                int origSize = queue.size();
                max = queue.peek().val;

                for (int x = 0; x < origSize; x++) {
                    TreeNode next = queue.poll();
                    if (next.left != null) {
                        queue.add(next.left);
                    }

                    if (next.right != null) {
                        queue.add(next.right);
                    }

                    if (next.val > max) {
                        max = next.val;
                    }
                }

                maxes.add(max);
            }
        }

        return maxes;
    }

    /**
     * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();


        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                int origSize = queue.size();
                for (int x = 0; x < origSize; x++) {
                    TreeNode next = queue.poll();
                    if (next.left != null) {
                        queue.add(next.left);
                    }

                    if (next.right != null) {
                        queue.add(next.right);
                    }

                    if (x == origSize - 1) {
                        right.add(next.val);
                    }
                }
            }

            queue.clear();
            queue.add(root);
            List<List<Integer>> traversal = new ArrayList<>();

        }

        return right;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> distanceK = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();


        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode next = queue.poll();

                if (next.left != null) {
                    if (next.left.val == target.val) {
                        distanceK.add(next.right.val);
                        root = next.left;
                        break;
                    }

                    queue.add(next.left);
                }

                if (next.right != null) {
                    if (next.right.val == target.val) {
                        distanceK.add(next.left.val);
                        root = next.right;
                        break;
                    }

                    queue.add(next.right);
                }
            }

            queue.clear();
            List<List<Integer>> traversal = new ArrayList<>();


            if (root != null) {
                queue.add(root);
                while (!queue.isEmpty()) {
                    List<Integer> level = new ArrayList<>();

                    int origSize = queue.size();
                    for (int x = 0; x < origSize; x++) {
                        TreeNode next = queue.poll();
                        if (next.left != null) {
                            queue.add(next.left);
                        }

                        if (next.right != null) {
                            queue.add(next.right);
                        }

                        level.add(next.val);
                    }

                    traversal.add(level);
                }

                if (traversal.size() > K) {
                    distanceK.addAll(traversal.get(K));
                }
            }

        }

        return distanceK;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        Map<List<Character>, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            List<Character> chars = new ArrayList<>();
            for (char c : str.toCharArray()) {
                chars.add(c);
            }

            Collections.sort(chars);

            if (anagramMap.containsKey(chars)) {
                anagramMap.get(chars).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);

                anagramMap.put(chars, newGroup);
            }
        }

        for (List<Character> anagram : anagramMap.keySet()) {
            anagrams.add(anagramMap.get(anagram));
        }

        return anagrams;
    }
}
