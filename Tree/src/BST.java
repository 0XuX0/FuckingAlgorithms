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

    public void print(Node root) {
        int height = height(root);

        System.out.println(root.value);
        System.out.println(root.right.value);
        System.out.println(root.right.right.value);
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

    public int[] levelorder() {
        List<Integer> levelorderList = new ArrayList<>();
        inorder(root, levelorderList);
        return levelorderList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void levelorder(Node root, List<Integer> levelorderList) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node head = queue.poll();
            levelorderList.add((Integer) head.value);
            if(root.left != null) {
                queue.offer(root.left);
            }
            if(root.right != null) {
                queue.offer(root.right);
            }
        }
    }

    //TODO 递归遍历
    //TODO 是否对称
    //TODO 前序 中序 后序
}
