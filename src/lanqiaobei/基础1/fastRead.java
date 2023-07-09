package lanqiaobei.基础1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author limli
 * @date 2022/12/26 11:34
 */
public class fastRead {
    public static void main(String[] args) {
        //System.in 读取的字节流 InputStreamReader 字节流向字符流转换的桥梁
        // BufferedReader 从字符输入流带缓存功能读取字符串 readLine()按行读取字符串


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while(true){
            try {
                while (((line = in.readLine()) != null)){ //只要还有行就去读取
                    String[] s = line.split(" +");//+多个空格
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    System.out.println(a+b);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    public int test(int c,long d){

        return (int)(c % d);//
    }
}
