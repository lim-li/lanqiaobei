package lanqiaobei.基础3;

import java.util.Scanner;

/**
 * @author limli
 * @date 2022/11/26 15:39
 */
public class 递增序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] ch = new char[30][50];
        for(int i = 0;i < ch.length;i++){
            ch[i] = scanner.nextLine().toCharArray();
        }
//        for (int i = 0; i < ch.length; i++) {
//            for (int j = 0; j < ch[0].length; j++) {
//                System.out.print(ch[i][j]);
//            }
//            System.out.println();
//
//        }
        int ans = 0;
        for (int i = 0; i < ch.length ; i++) { //行
            for (int j = 0; j < ch[0].length; j++) {//列
                char p = ch[i][j];
                //同行从左往右
                for(int k = j+1;k<ch[0].length;k++){
                    if(p < ch[i][k] )
                        ans++;
                }
                //同列 从上到下
                for(int k = i+1;k< ch.length;k++ ){
                    if(p < ch[k][j])
                        ans++;
                }
                // 45度 左上右下
                for(int l = i+1,r = j+1;l< ch.length&&r<ch[0].length;l+=1,r+=1){
                    if(p < ch[l][r])
                        ans++;
                }
                //45度 左下右上
               int  l=i+1,r=j-1;
                while (l< ch.length && r>=0){
                    if (p<ch[l][r] || p>ch[l][r])
                        ans++;
                    l+=1;r-=1;
                }
            }
            //System.out.println(ans);
            
        }
        System.out.println(ans);
        scanner.close();

    }
}
