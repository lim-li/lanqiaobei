package lanqiaobei.基础3;

/**
 * @author limli
 * @date 2022/11/24 14:10
 * 数组中只有一个数出现了一次，其他的数都出现了K次，请输出只出现1次的数
 *
 * K个k进制的数不进位相加 和为0
 * Integer.toString(n,k)将n转换为k进制的数
 */
public class NumberOf_K {
    public static void main(String[] args) {
        System.out.println(Integer.toString(10,2));
        int[] arr = new int[]{2,2,2,4,4,4,8,7,7,7,0,0,0};
        int len = arr.length;
        char[][] kRadix = new char[len][];
        int k=3;
        int maxLen = 0;
        for(int i = 0;i < len;i++) {
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;
            }
        }
        int[] resArr = new int[maxLen];
        //不进位加法
        for(int i = 0;i < len;i++){
            for(int j = 0;j < maxLen;j++){
                if(j >= kRadix[i].length)
                    resArr[j] += 0;
                else
                    resArr[j] += (kRadix[i][j] - '0');
            }
        }
        int res = 0;
        for(int i =0;i < maxLen;i++){
            res += (resArr[i] % k) * (int)(Math.pow(k,i));
        }
        System.out.println(res);
    }

}
