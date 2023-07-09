package lanqiaobei.搜索.dfs;


/**
 * @author limli
 * @date 2023/3/20 21:30
 * lt200
 */
public class 岛屿数量 {
        public int numIslands(char[][] grid) {
            int islandNum = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        infect(grid, i, j);
                        islandNum++;
                    }
                }
            }
            return islandNum;
        }

    private void infect(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[0].length || grid[i][j] == '0'){
            return ;
        }
        grid[i][j] = '0';
        infect(grid,i+1,j);
        infect(grid,i-1,j);
        infect(grid,i,j+1);
        infect(grid,i,j-1);
    }


}
