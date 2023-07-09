package lanqiaobei.刷题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limli
 * @date 2023/2/18 20:12
 */
public class 数的分解 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();//保存不含有数字和4的数字
        //因为要求三个不同的正整数 所以 2018 2017 2016 都不行最大只能是2015
        for (int i = 1;i <=2015;i++){
            if(fun(i)) list.add(i);
        }
        System.out.println(list.size());
        int ans = 0;
        for(int i = 0; i < list.size();i++){
            for (int j = i+1; j <list.size() ; j++) {
                for (int k = j+1; k < list.size() ; k++) {
                    if((list.get(i)+list.get(j)+list.get(k))==2019) ans++;
                }
            }
        }
        System.out.println(ans);

    }
    public static boolean fun(int n){//判断n是否包含2和4
        while (n > 0){
            int b = n % 10;
            if(b == 2 || b==4) return false;
            n /= 10;
        }
        return true;
    }

}
