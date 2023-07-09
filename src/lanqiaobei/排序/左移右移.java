package lanqiaobei.排序;

import sun.java2d.pipe.SpanIterator;

import java.util.*;

/**
 * @author limli
 * @date 2023/1/25 20:38
 */
public class 左移右移 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        HashSet<Integer> set = new HashSet<>();//
//        ArrayList<Integer> left = new ArrayList<>();
//        ArrayList<Integer> right = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            String c = sc.next();
//            if(c.equals("L")) left.add(sc.nextInt());
//            if(c.equals("R")) right.add(sc.nextInt());
//        }
//        for (int i = 0; i < left.size(); i++) set.add(left.get(i));
//        for (int i = 0; i < right.size(); i++)  set.add(right.get(i));
//        Set<Integer> ans = new HashSet<>();
//        int leftsize = left.size()-1;
//        while(leftsize>=0){
//            ans.add(left.get(leftsize));
//            leftsize--;
//        }
//        for(Integer i=1;i <= n;i++){
//            if(!set.contains(i)) {
//                ans.add(i);
//            }
//        }
//        ans.addAll(right);
//        Iterator<Integer> it = ans.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next()+" ");
//        }
        //新的方法
        int[][] e = new int[n+1][2];
        for(int i = 1;i <= n;i++) {
            e[i][0] = e[i][1] = i;
        }
        int min = 1,max = n;//这个数值的定义 就很厉害 每次都能满足移动到最左边或者最右边
        while(m-->0){
            char c = sc.next().charAt(0);
            int x = sc.nextInt();
            e[x][1] = (c=='L' ? --min:++max);//精髓
        }
        Arrays.sort(e,1,n+1,((o1,o2)->o1[1]-o2[1]));//按照e的第二列数值排序
        for (int i = 1; i <= n; i++) {
            System.out.print(e[i][0]+" ");
        }
    }
}
