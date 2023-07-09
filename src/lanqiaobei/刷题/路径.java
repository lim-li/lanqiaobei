package lanqiaobei.刷题;

/**
 * @author limli
 * @date 2023/3/2 20:36
 */
public class 路径 {
    public static void main(String[] args) {
        //2021个节点
        int[][] g = new int[2022][2022];
        for(int i = 1;i <= 2021;i++){
            for(int j = 1;j <= 2021;j++){
                if(i==j) g[i][j] = 0;//自己到自己
                else if(Math.abs(i-j)> 21) g[i][j] = Integer.MAX_VALUE;//不可达
                else if(Math.abs(i-j) <= 21) g[i][j] = lcm(i,j);
            }
        }
//        System.out.println(g[1][23]);
//        System.out.println(g[3][24]);
        //floyd 求解 最短路径 三层循环
        for(int k = 1; k <= 2021;k++){//中转点
            for(int i = 1; i <= 2021;i++){
                for(int j = 1;j <= 2021;j++){
                    if(g[i][k] < Integer.MAX_VALUE && g[k][j] < Integer.MAX_VALUE && i!=j && i!=k && j!=k){
                        g[i][j] = Math.min(g[i][j],g[i][k]+g[k][j]);
                    }
                }
            }
        }
        System.out.println(g[1][2021]);
    }
    public static int gcd(int a,int b){//a和b的最大公约数
        if(b == 0) return a;
        return gcd(b,a%b);
    }
    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
}
