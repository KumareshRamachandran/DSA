import java.util.LinkedList;
import java.util.Queue;

class Pair1{
    int first, second, third;
    public Pair1(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class _01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair1> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j]==0){
                    q.add(new Pair1(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m
                && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    q.add(new Pair1(nRow, nCol, steps+1));
                }
            }
        }
        return dist;
    }
}
