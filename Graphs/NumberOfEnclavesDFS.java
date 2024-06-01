public class NumberOfEnclavesDFS {
    public static void dfs(int row, int col, int[][] vis, int[][] grid,
                           int[] dRow, int[] dCol){
        vis[row][col] = 1;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m &&
            vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                dfs(nRow, nCol, vis, grid, dRow, dCol);
            }
        }
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==0) vis[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(i, 0, vis, grid, dRow, dCol);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                dfs(i, m-1, vis, grid, dRow, dCol);
            }
        }
        for (int i = 0; i < m; i++) {
            if(grid[0][i]==1 && vis[0][i]==0){
                dfs(0, i, vis, grid, dRow, dCol);
            }
            if(grid[n-1][i]==1 && vis[n-1][i]==0){
                dfs(n-1, i, vis, grid, dRow, dCol);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j]==0) count++;
            }
        }
        return count;
    }
}

