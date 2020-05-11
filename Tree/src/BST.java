
/**
 * @ClassName BTS
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/10
 **/

public class BST {
    private Node root;

    public int size() {
        return size(root);
    }

    public int get(int key) {
        return get(root, key).value;
    }

    public void put(int key, int val) {
        root = put(root, key, val);
    }

    public void print() {

    }

    private class Node {
        private int key;
        private int value;
        private Node left, right;
        private int N; //以该节点为根的子树中的节点总数

        public Node(int key, int value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private Node get(Node x, int key) {
        if (x == null) return null;
        if (x.key < key) return get(x.right, key);
        else if (x.key > key) return get(x.left, key);
        else return x;
    }

    private Node put(Node x, int key, int val) {
        if(x == null) return new Node(key, val, 1);
        if (x.key < key) x.left = put(x.right, key, val);
        else if (x.key > key) x.right = put(x.left, key, val);
        else x.value = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //TODO 递归遍历
    //TODO 层次遍历
    //TODO 是否对称
    //TODO 前序 中序 后序
    //TODO 最大深度 最小深度
}
