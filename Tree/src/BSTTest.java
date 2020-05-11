import java.util.ArrayList;
import java.util.List;

/**
 * ()
 *
 * @author xuchh
 * @date 2020/5/11
 */
public class BSTTest {
    public static void main(String[] args) {
        System.out.println("BST test start");
        BST tree = new BST();

        tree.put(2,2);
        tree.put(1,1);
        tree.put(4,4);
        tree.put(3,3);

        int[] res = new int[4];
        res = tree.inorder();
        for(int i= 0; i < 4; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
