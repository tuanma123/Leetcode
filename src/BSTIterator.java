import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BSTIterator {

    private PriorityQueue<Integer> heap;

    public BSTIterator(TreeNode root) {
        this.heap = new PriorityQueue<>();

        if (root != null) {
            Queue<TreeNode> bfs = new LinkedList<>();
            bfs.add(root);

            while (bfs.isEmpty()) {
                TreeNode next = bfs.poll();
                this.heap.add(next.val);

                if (next.left != null) {
                    bfs.add(next.left);
                }

                if (next.right != null) {
                    bfs.add(next.right);
                }
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.heap.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return this.heap.poll();
    }
}