import java.util.LinkedList;
import java.util.Queue;

class Pair2{
    int first, second;
    public Pair2(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfEnclavesBFS{
    public static int numEnclaves(int[][] grid){
        Queue<Pair2> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair2(i, j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i], nCol = col + dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                    q.add(new Pair2(nRow, nCol));
                    vis[nRow][nCol]=1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1 && vis[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}
