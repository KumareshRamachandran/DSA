public class SurroundedRegion {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] vis = new int[n][m];
        int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(0, i, vis, board, dRow, dCol);
            }
            if(vis[n-1][i]==0 && board[n-1][i]=='O'){
                dfs(n-1, i, vis, board, dRow, dCol);
            }
        }
        for (int i = 0; i < n; i++) {
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i, 0, vis, board, dRow, dCol);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i, m-1, vis, board, dRow, dCol);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void dfs(int row, int col, int[][] vis, char[][] board,
                           int[] dRow, int[] dCol) {
        vis[row][col] = 1;
        int n = board.length, m = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, vis, board, dRow, dCol);
            }
        }
    }
}
