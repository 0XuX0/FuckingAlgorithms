/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/5
 **/
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Util.less(a[j],a[j-h]); j -= h) {
                    Util.exch(a,j,j-h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Shell Sort");
        Comparable[] num2 = {"L","E","E","A","M","H","L","E","P","S","O","L","T","S","X","R"};
        sort(num2);
        Util.show(num2);
    }
}
