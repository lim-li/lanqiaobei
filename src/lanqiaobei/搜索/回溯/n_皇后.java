package lanqiaobei.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limli
 * @date 2023/3/19 15:57
 */
public class n_皇后 {
    List<List<String>> list = new ArrayList<>();
    public static void main(String[] args) {

    }
    //输入棋盘的长度 输出皇后可以放得位置
    public List<List<String>> solveNqueens(int n){
        //'.'代表棋盘 ‘Q’代表皇后 初始化棋盘
        ArrayList<String> board = new ArrayList<>();
        for(int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < n;j++){
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backtrack(board);
        return list;
    }

    private void backtrack(ArrayList<String> board) {
    }


}
