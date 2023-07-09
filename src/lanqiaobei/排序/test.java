package lanqiaobei.排序;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author limli
 * @date 2023/2/24 18:27
 */
public class test {
    public static void main(String[] args) {
        int[] arr = {1,5,0,3,5};
        Set<Integer> a = new HashSet<>();
        Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
       int max = arr[arr.length-1];
       int ans = 0;
       for(int i = 0;i < arr.length;i++){
           if(arr[i]!=0&&max>0){
               ans ++;
               max -= arr[i];
           }
       }
        System.out.println(ans);
    }
}
