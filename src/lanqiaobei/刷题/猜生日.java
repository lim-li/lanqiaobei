package lanqiaobei.刷题;

/**
 * @author limli
 * @date 2023/2/24 13:37
 */
public class 猜生日 {
    public static void main(String[] args) {
        for(int i = 19000101;i < 20120312;i++){
            if(i % 2012==0 && i % 3==0 && i % 12 ==0){
                //
                String s = i+"";
                if(s.substring(4,6).equals("06")){
                    System.out.println(i);
                }
            }
        }
    }

}
