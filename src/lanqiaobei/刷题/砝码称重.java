package lanqiaobei.刷题;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author limli
 * @date 2023/2/26 15:18
 */
public class 砝码称重 {
    public static void main(String[] args) {
        //防止有重复 用set 初始为{0}
        // 比如 1 4 6 依次添加到集合 添加1 set为{1,0}，4为{5,3，4,1,0}，6为{11,1,9,3,10,2,7,5,6,4,}
        //过程就是每次添加新的 就遍历集合中的元素 并对元素相加减 最后set.size-1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();//暂时存储每次添加元素所能组成的结果
        set.add(0);
        for(int i = 0;i < n;i++){
            int w = sc.nextInt();
            //由于set没有通过下标获取元素的方法 因此遍历
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()){
                Integer a = it.next();
                //加
                temp.add(a+w);
                //减
                if(a>w) temp.add(a-w);
                else temp.add(w-a);
            }
            set.addAll(temp);
        }
        System.out.println(set.size()-1);

    }
}
