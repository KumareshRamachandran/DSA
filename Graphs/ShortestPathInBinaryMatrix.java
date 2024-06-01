import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    static class Pair{
        int first, second, third;
        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int) (1e9);
            }
        }
        dist[0][0] = 1;
        q.add(new Pair(1, 0, 0));
        while(!q.isEmpty()){
            Pair it = q.poll();
            int dis = it.first, r = it.second, c = it.third;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(!(i==0 && j==0)){
                        int nRow = r + i, nCol = c + j;
                        if(nRow>=0 && nRow<n && nCol>=0 && nCol<n &&
                        grid[nRow][nCol]==0 && dis + 1 < dist[nRow][nCol]){
                            dist[nRow][nCol] = 1 + dis;
                            if(nRow==n-1 && nCol==n-1) {
                                System.out.println(Arrays.deepToString(dist));
                                return dis+1;
                            }
                            q.add(new Pair(1+dis, nRow, nCol));
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        return -1;
    }
}
