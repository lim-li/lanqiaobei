package lanqiaobei.搜索.dfs;

/**
 * @author limli
 * @date 2023/2/3 11:51
 */
public class binString {
    public static int cnt = 0;//全局记录总共调用多少次递归 也就是dfs函数
    public static void main(String[] args) {
        dfs(0,"");

    }
    public static void dfs(int depth,String bin){
        cnt++;
        System.out.printf("dg(%d,%s)\n",depth,bin);
        if(depth==4){
            System.out.println(bin);
            return;
        }
        dfs(depth+1,bin+"0");
        dfs(depth+1,bin+"1");
    }
}
