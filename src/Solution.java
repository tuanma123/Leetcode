import javafx.scene.layout.Priority;

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
        s = s.trim().replaceAll(" +", " ");

        StringBuilder reversed = new StringBuilder();
        String[] tokens = s.split(" ");

        for (int x = tokens.length - 1; x >= 0; x--) {
            if (!tokens[x].equals(" ")) {
                reversed.append(tokens[x]);

                if (x != 0) {
                    reversed.append(" ");
                }
            }
        }

        return reversed.toString();
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

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        List<Integer> top = new ArrayList<>();
        PriorityQueue<Map.Entry> pq;

        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        pq = new PriorityQueue<>(new Comparator<Map.Entry>() {
            public int compare(Map.Entry a, Map.Entry b) {
                return (int) b.getValue() - (int) a.getValue();
            }
        });

        pq.addAll(counts.entrySet());

        for (int i = 0; i < k; ++i) {
            Map.Entry e = pq.poll();
            top.add((int) e.getKey());
        }

        return top;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>  heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            heap.add(i);
        }

        for (int x = 0; x < k -1; x++) {
            heap.poll();
        }

        return heap.peek();
    }

    public int kthSmallest(int[][] matrix, int k) {
        int traveled = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] x : matrix) {
            for (int y : x) {
                pq.add(y);
            }
        }

        for (int x = 0; x < k - 1; x++) {
            pq.poll();
        }

        return pq.peek();
    }

    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList();
        PriorityQueue<Integer> nodes = new PriorityQueue<>();

        if (root != null) {
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode next= q.poll();

                nodes.add(next.val);

                if (next.left != null) {
                    q.add(next.left);
                }

                if (next.right != null) {
                    q.add(next.right);
                }
            }

            for (int x = 0; x < k -1; x++) {
                nodes.poll();
            }

            return nodes.peek();
        } else {
            return -1;
        }
    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patterns = new HashMap<>();
        Set<String> seen = new HashSet<>();

        String[] tokens = str.split(" ");

        if (tokens.length != pattern.length()) {
            return false;
        }

        for (int x = 0; x < pattern.length(); x++) {
            if (patterns.containsKey(pattern.charAt(x))) {
                if (!patterns.get(pattern.charAt(x)).equals(tokens[x])) {
                    return false;
                }
            } else {
                if (seen.contains(tokens[x])) {
                    return false;
                }

                seen.add(tokens[x]);
                patterns.put(pattern.charAt(x), tokens[x]);
            }
        }

        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {
            if (seen.contains(i)) {
                return true;
            } else {
                seen.add(i);
            }
        }

        return false;
    }

    public int[] productExceptSelf(int[] nums) {
        int product = 1;

        for (int num : nums) {
            product *= num;
        }

        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != 0) {
                nums[x] = product / nums[x];
            } else {
                nums[x] = 0;
            }
        }

        return nums;
    }

    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        if (c1.length != c2.length) {
            return false;
        }

        for (int x = 0; x < c1.length; x++) {
            if (c1[x] != c2[x]) {
                return false;
            }
        }

        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> dups = new HashMap<>();

        for (int x = 0; x < nums.length; x++) {
            int i = nums[x];

            if (dups.containsKey(i)) {
                for (int index : dups.get(i)) {
                    if (x - index <= k) {
                        return true;
                    }
                }

                dups.get(i).add(x);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(x);

                dups.put(i, indices);
            }
        }

        return false;
    }

    public double myPow(double x, int n) {
        // lul
        return Math.pow(x, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x = 0; x < m; x++) {
            pq.add(nums1[x]);
        }

        for(int x = 0; x < n; x++) {
            pq.add(nums2[x]);
        }

        int count = 0;
        while(!pq.isEmpty()) {
            nums1[count] = pq.poll();
            count++;
        }
    }

    public int missingNumber(int[] nums) {
        boolean[] found = new boolean[nums.length + 1];

        for (int x = 0; x < nums.length; x++) {
            found[nums[x]] = true;
        }


        for (int x = 0; x < found.length; x++) {
            if (!found[x]) {
                return x;
            }
        }


        return 0;
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int x = 1; x <= n; x++) {
            if (x % 5 == 0 && x % 3 == 0) {
                result.add("FizzBuzz");

            } else if (x % 5 == 0) {
                result.add("Buzz");
            } else if (x % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add("" + x);
            }
        }

        return result;
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int count = 0;

        for (char c : t.toCharArray()) {
            if (c == s.charAt(count)) {
                count++;
            }

            if (count == s.length()) {
                return true;
            }
        }

        return false;
    }

    public String frequencySort(String s) {
        Map<Character, Integer> charMapping = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (charMapping.containsKey(c)) {
                charMapping.put(c, charMapping.get(c) + 1);
            } else {
                charMapping.put(c, 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : charMapping.entrySet()) {
            pq.add(entry);
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> next = pq.poll();

            for (int x = 0; x < next.getValue(); x++) {
                result.append(next.getKey());
            }
        }

        return result.toString();
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        boolean[][] seen = new boolean[grid.length][];
        for (int x = 0; x < grid.length; x++) {
            seen[x] = new boolean[grid[x].length];
        }

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 1) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(x);
                    coord.add(y);
                    int size = dfs(grid, coord, seen);

                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }

        return maxSize;
    }

    public int dfs (int[][] grid, List<Integer> coord, boolean[][] seen) {
        Stack<List<Integer>> coords = new Stack<>();
        coords.add(coord);
        int size = 0;
        seen[coord.get(1)][coord.get(0)] = true;

        while (!coords.isEmpty()) {
            List<Integer> pair = coords.pop();
            grid[pair.get(1)][pair.get(0)] = 0;
            size++;

            List<List<Integer>> neighbors = getNeighbors(grid, pair.get(0), pair.get(1));

            for (List<Integer> neighbor : neighbors) {
                if (!seen[neighbor.get(1)][neighbor.get(0)]) {
                    coords.add(neighbor);
                    seen[neighbor.get(1)][neighbor.get(0)] = true;
                }
            }
        }

        return size;
    }

    public List<List<Integer>> getNeighbors(int[][] grid, int x, int y) {
        List<List<Integer>> neighbors = new ArrayList<>();

        if (x + 1 < grid[y].length) {
            if (grid[y][x + 1] == 1) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(x + 1);
                neighbor.add(y);

                neighbors.add(neighbor);
            }
        }
        if (x - 1 >= 0) {
            if (grid[y][x - 1] == 1) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(x - 1);
                neighbor.add(y);

                neighbors.add(neighbor);
            }
        }
        if (y + 1 < grid.length) {
            if (grid[y + 1][x] == 1) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(x);
                neighbor.add(y + 1);

                neighbors.add(neighbor);
            }
        }
        if (y - 1 >= 0) {
            if (grid[y - 1][x] == 1) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(x);
                neighbor.add(y - 1);

                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }

        int digits = (int) (Math.log10(x) + 1);
        int power = digits;
        int result = 0;

        for (int y = 0; y < digits; y++) {
            result += Math.pow(10, power) * nthDigit(x, y);
            power--;
        }

        if (negative) {
            result *= -1;
        }

        return result;
    }

    public int nthDigit (int x, int n) {
        return (int)(x /(Math.pow(10, n))) % 10;
    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'R') {
                x++;
            } else if (move == 'L') {
                x--;
            }
        }

        return x == 0 & y == 0;
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }

            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val != t2.val) {
                return false;
            }

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : nums1) {
            heap.add(i);
        }

        for (int i : nums2) {
            heap.add(i);
        }

        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            for (int x = 0; x < (length / 2) - 1; x++) {
                heap.poll();
            }

            double sum = heap.poll();
            sum += heap.poll();
            return sum / 2;
        } else {
            for (int x = 0; x < length / 2; x++) {
                heap.poll();
            }

            return heap.peek() * 1.0;
        }
    }

    public String largestNumber(int[] nums) {
        class LargerNumberComparator implements Comparator<String> {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        }

        String[] numsString = new String[nums.length];

        for (int x = 0; x < numsString.length; x++) {
            numsString[x] = nums[x] + "";
        }

        Arrays.sort(numsString, new LargerNumberComparator());

        StringBuilder toString = new StringBuilder();

        for (String num : numsString) {
            toString.append(num);
        }

        return toString.toString();
    }
}
