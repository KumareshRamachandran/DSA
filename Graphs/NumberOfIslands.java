import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void bfs(int row, int col, int[][] vis, char[][] grid){
        int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
        vis[row][col] = 1;
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(row, col));
        int n = grid.length, m = grid[0].length;
        while(!q.isEmpty()){
            int r = q.peek().first, c = q.peek().second;
            for (int i = 0; i < 4; i++) {
                int nRow = r + dRow[i], nCol = c + dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && grid[nRow][nCol]=='1'){
                    vis[nRow][nCol] = 1;
                    q.add(new Pair2(nRow, nCol));
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, cnt = 0;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
}
