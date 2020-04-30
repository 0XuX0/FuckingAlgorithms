/**
 * selection sort
 *
 * @author xuchh
 * @date 2020/4/30
 */
public class SelectSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i + 1; j < N; j++) {
                if (Util.less(a[j], a[min])) {
                    min = j;
                }
            }
            Util.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Select Sort");
        Comparable[] num = {2,1,6,4,3,8,11};
        sort(num);
        Util.show(num);
    }
}
