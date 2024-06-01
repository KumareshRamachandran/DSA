import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumEffort {
    static class Pair{
        int distance, row, col;
        public Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int diff = pair.distance, row = pair.row, col = pair.col;
            if(row == n-1 && col == m-1) return diff;
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i], nCol = col + dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), diff);
                    if (newEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newEffort;
                        pq.add(new Pair(newEffort, nRow, nCol));
                    }
                }
            }
        }
        return 0;
    }
}
