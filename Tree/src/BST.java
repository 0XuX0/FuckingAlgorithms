import java.util.*;

/**
 * @ClassName BTS
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/10
 **/

public class BST <Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N; //以该节点为根的子树中的节点总数

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    /**
     * 中序遍历打印
     */
    public void print() {
        int[] preorder = this.preorder();
        for (int i = 0; i < preorder.length; i++) {
            System.out.print(preorder[i] + " ");
        }

    }

    public int size() {
        return size(root);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.value = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private int height(Node root) {
        int height = 1;
        int modCount = 1;
        while(modCount <= root.N) {
            modCount = modCount << 1;
            height += 1;
        }
        return height - 1;
    }

    public int[] inorder() {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return inorderList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void inorder(Node root, List<Integer> inorderList) {
        if(root.left != null) {
            inorder(root.left, inorderList);
        }
        inorderList.add((Integer) root.value);
        if(root.right != null) {
            inorder(root.right, inorderList);
        }
    }

    public int[] preorder() {
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        return preorderList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void preorder(Node root, List<Integer> preorderList) {
        preorderList.add((Integer) root.value);
        if(root.left != null) {
            preorder(root.left, preorderList);
        }
        if(root.right != null) {
            preorder(root.right, preorderList);
        }
    }

    public int[] postorder() {
        List<Integer> postorderList = new ArrayList<>();
        postorder(root, postorderList);
        return postorderList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void postorder(Node root, List<Integer> postorderList) {
        if(root.left != null) {
            postorder(root.left, postorderList);
        }
        if(root.right != null) {
            postorder(root.right, postorderList);
        }
        postorderList.add((Integer) root.value);
    }

    public int[] levelorder() {
        List<Integer> levelorderList = new ArrayList<>();
        levelorder(root, levelorderList);
        return levelorderList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void levelorder(Node root, List<Integer> levelorderList) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node head = queue.poll();
            levelorderList.add((Integer) head.value);
            if(head.left != null) {
                queue.offer(head.left);
            }
            if(head.right != null) {
                queue.offer(head.right);
            }
        }
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return floor(x.right, key);
        }
        Node t = floor(x.left, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        // 返回排名为k的节点
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        // 返回以x为根节点的子树中小于x.key的键的数量
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) +rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
