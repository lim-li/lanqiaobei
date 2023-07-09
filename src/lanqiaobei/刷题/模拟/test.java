package lanqiaobei.刷题.模拟;

/**
 * @author limli
 * @date 2023/3/5 18:45
 */
public class test {
    public static void main(String[] args) {
        int i = 1,j=1,z = 1;
        int count=0;
        one:
       for(i = 0;i <= 25;i++){
           for(j = 0;j <= 25;j++){
               for(z = 0;z <=25;z++){
                   count++;
                   if(count==2023)
                      break one;
               }
           }
       }
        System.out.println(i);
        System.out.println(j);
        System.out.println(z);
    }
}
