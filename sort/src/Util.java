/**
 * init some common methods for kinds of sort algorithms
 *
 * @author xuchh
 * @date 2020/4/30
 */
public class Util {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] num, int i, int j) {
        Comparable t = num[i]; num[i] = num[j]; num[j] = t;
    }

    public static void show(Comparable[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println(" ");
    }

    public static boolean isSorted(Comparable[] num) {
        for (int i = 1; i < num.length; i++) {
            if (less(num[i], num[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
