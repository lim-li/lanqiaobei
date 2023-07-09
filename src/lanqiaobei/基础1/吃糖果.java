package lanqiaobei.基础1;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/12/26 20:53
 * 小蓝有 nn 种糖果，每种数量已知。
 *
 * 小蓝不喜欢连续 22 次吃同样的糖果。问有没有可行的吃糖方案。
 *
 * 第一行是整数 n(0<n<1000000)
 * 第二行包含 n 个数，表示 n 种糖果的数量 mi，0<mi<10000000=
 *
 * 输出一行，包含一个 Yes 或 no。
 */
public class 吃糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;//统计最多糖果的数量
        long sum = 0l;//糖果所有的数量 超过int 范围
        for(int i = 0;i < n;i++){
            int x = sc.nextInt();//遇到空格就会停止扫描
            sum += x;
            max = Math.max(x,max);
        }
        /**
         *   #######
         *   %%@@$$
         *   例如上面的糖果 # 最多 每一个匹配一个 当先下面的%糖果 就不满足了
         *   故 本题可以转换为
         *   #######
         *   #######
         *   大于
         *   #######
         *   %%@@$$
         *   即 2*max > sum ? "no":"yes";
         *
         */
        System.out.println(2l * max > sum ? "No" : "Yes");//注意2l转换为 long


    }
}
