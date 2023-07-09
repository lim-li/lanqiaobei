package lanqiaobei.递归;

/**
 * @author limli
 * @date 2022/12/17 10:50
 * 递归遍历的理解
 */
public class shuzu {
    public static void main(String[] args) {
        int[] arr = {1,8,5,9};
        new shuzu().traverse(arr,0);

    }
    public void traverse(int[] arr,int i){
        if(i == arr.length){
            return;
        }
        //System.out.print(arr[i]+" ");
        traverse(arr,i+1);
        System.out.print(arr[i]+" ");
    }
}
