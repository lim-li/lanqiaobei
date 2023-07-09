package lanqiaobei.基础2;

/**
 * @author limli
 * @date 2023/1/3 17:27
 * 一只青蛙一张嘴, 两只眼睛四条腿...二十只青蛙二卜张嘴, 四十只眼睛八十条腿
 */
public class 数青蛙 {
    public static void main(String[] args) {
        //(一)只青蛙(一)张嘴,(两)只眼睛(四)条腿 10个不变字体
        int count=0;
        count += 10*20; //20个不变字体
        //第一个参数（一）只青蛙 和 第二个参数 (一)张嘴
        count += 10*2;
        count += 2*10*2;
        //第三个参数 (两)只眼睛 最大为40
        count += 5;
        count += 5*2;
        count += 10*3-2;
        //第四个参数 (四)条腿 最大为80
        count += 2*1;
        count += 3*2;
        count += 15*3-3;
        System.out.println(count);






    }
}
