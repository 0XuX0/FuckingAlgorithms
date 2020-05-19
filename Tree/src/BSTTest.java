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

        tree.print();
    }
}
