package lanqiaobei.递归;

import java.util.HashSet;
import java.util.Set;

/**
 * @author limli
 * @date 2022/12/5 21:05
 * 基础的递归
 */
public class BaseRecursion {
    public static int step = 1;
    public static void main(String[] args) {
        //System.out.println(fic(5));
        //fic1(2,9);

//        int[] arr = new int[]{1,4,6,7};
//        System.out.println(fic2(arr,0));

        //System.out.println(fic3("abcd",3));

        //System.out.println(fic4(5));

//        int[] arr = new int[]{4,8,9,2};
//        insertSort(arr,3);
//        System.out.println(Arrays.toString(arr));
       // printhannoiTower(3,"A","B","C");
        System.out.println(numDifferentIntegers("0a0"));

    }
    /**
     * 1.求阶乘
     * 2.输出i~j
     * 3.数组求和
     * 4.反转字符串
     * 5.斐波那契数列
     * 6.最大公约数
     * 7.排序改递归
     * 8.汉诺塔
     */
    public static int fic(int n){//1.求阶乘
        if(n==1) return 1;
        return n*fic(n-1);
    }
    static void fic1(int i,int j){//2.输出i~j
        if(i > j)
            return;
        System.out.print(i+" ");
        fic1(i+1,j);
    }
    static int fic2(int[] arr,int begin){//3.数组求和
        if(begin == arr.length-1) return arr[begin];
        return arr[begin] + fic2(arr,begin+1);
    }
    static String fic3(String s,int end){//4.反转字符串
        if(end == 0) return ""+ s.charAt(0);
        return s.charAt(end) + fic3(s,end-1);
    }
    static int fic4(int N){//5.斐波那契数列
        if(N <=2 ) return 1;
        return fic4(N-1)+fic4(N-2);
    }
    static int fic5(int i,int j){//6.最大公约数
        if(j == 0) return i;
        return fic5(j,i%j);
    }
    static void insertSort(int[] arr,int k){
        if(k==0)
            return;
        //对前n-1个元素进行排序
        insertSort(arr,k-1);
        //把位置k的元素插入到前面的部分
        int x = arr[k];
        int index = k-1;
        while(index > -1&& x<arr[index]){ //满足x小于元素，这个元素后移一位
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1] = x;
    }
    static void printhannoiTower(int N,String from,String to,String help){
        if(N==1){
            System.out.println("move"+N+"from"+from+"to" +to);
        }else{
            printhannoiTower(N-1,from,help,to);
            System.out.println("move"+N+"from"+"to"+to);
            printhannoiTower(N-1,help,to,from);
        }
    }
    public static int numDifferentIntegers(String word) {
        Set<String> list = new HashSet();
        for(int i = 0;i < word.length();i++){
           if(word.charAt(i) <= '9'){ //数字
               int j = i;
               while(j < word.length() && word.charAt(j) <= '9') j++;
               while(i < j && word.charAt(i) == '0'   ) i++;
               list.add(word.substring(i,j));
               i = j;
           }
        }
        return list.size();
    }
    public static void hanuota(int n,char A,char B,char C){
        if(n==1){
            System.out.printf("第%03d步,将%03d盘子%c->%c\n",step++,n,A,C);
        }
        hanuota(n-1,A,C,B);//前n-1移动到B
        System.out.printf("第%03d步,将%03d盘子%c->%c\n",step++,n,A,C);
        hanuota(n-1,B,A,C);//完成所有n个都到C
    }

}
