/**
 * insertion sort
 *
 * @author xuchh
 * @date 2020/4/30
 */
public class InsertSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Util.less(a[j], a[j - 1]); j--) {
                Util.exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("This is insert sort");
        Comparable[] num = {2,1,6,4,3,8,11};
        sort(num);
        Util.show(num);
    }
}
