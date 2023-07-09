package lanqiaobei.数学思维与技巧;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/1/29 11:35
 */
public class 递增三元组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        for (int i = 0; i < n; i++) c[i] = sc.nextInt();
        //双指针 以b为观察点 找到a中比b小的元素个数 找到c中比b大的元素个数
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            while (l < n && a[l] < b[i]) l++; //要注意先写 l<n 不然这个不满足的情况下再去取数组下标会越界
            while (r < n && c[r] <= b[i]) r++;//这个要排除 <= 的 剩下的就全部是>
            res += (long) l * (n - r);
        }
        System.out.println(res);
    }
}
