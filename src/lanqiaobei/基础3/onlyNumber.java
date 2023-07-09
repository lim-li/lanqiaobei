package lanqiaobei.基础3;

import java.util.Arrays;
import java.util.Random;

/**
 * @author limli
 * @date 2022/11/18 16:12
 * 数组大小为1001且数组中存储1~1000数字，其中有一个数字重复找到这个数字
 * 异或 ：
 *      偶数个相同数字异或得到0
 *      奇数个相同数字异或得到数字本身
 *      0^a = a 即0和任何数异或得本身
 *      异或的本质就是相同为0 不同为1
 *      相差1的两个数 异或等于大数加一 比如:3^4=5
 */
public class onlyNumber {
    public static void main(String[] args) {
        int N = 11;//改为1001
        int[] arr = new int[N];
        for(int i = 0;i < arr.length-1;i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
        //最后一个位置随机生成一个数字
        arr[arr.length-1] = new Random().nextInt(N-1);
        //随机放入一个下标中
        int index = new Random().nextInt(N-1);
        int a = 0;
        a = arr[index];
        arr[index] = arr[arr.length-1];
        arr[arr.length-1] = a;
        System.out.println(Arrays.toString(arr));
        //找出数组中重复的元素 [1, 8, 3, 4, 5, 6, 7, 8, 9, 10, 2] 异或 x1分别与1~10和arr[0~10]异或找到重复的
        int x1 = 0;
        for(int i = 0;i < N;i++ ){
            x1 = x1^arr[i];
        }
        for(int i = 1;i<N;i++){
            x1 = x1^i;
        }
        System.out.println(x1);
        System.out.println("=======================");
        //使用额外数组来解决 数组下标对应相应的数 下标所对应的元素值代表出现次数
        int[] helper = new int[N];
        for(int i = 0;i< arr.length;i++){
            helper[arr[i]]++;
        }
        for(int i = 0;i< helper.length;i++){
            if(helper[i]==2){
                System.out.println(i);
            }
        }
    }
}
