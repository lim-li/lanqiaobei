package lanqiaobei.基础1;
import java.util.Scanner;
/**
 * @author limli
 * @date 2023/1/7 18:35
 */
public class 字符统计 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s = scan.next();
        int[] arr = new int[26];
        for(int i = 0; i < s.length();i++){
            arr[s.charAt(i) - 'A']++;
        }
        String res = "";
        int max = 0;
        for(int i = 0;i < 26;i++){
            max = Math.max(max,arr[i]);
        }
        int j = 0;
        for(int i = 0;i < 26;i++){
            if(arr[i] == max){
                res += (char)('A'+i);
            }
        }
        System.out.println(res);
        scan.close();
    }
}
