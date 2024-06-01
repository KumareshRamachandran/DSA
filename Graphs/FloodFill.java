import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PairTwo{
    int row, col;
    public PairTwo(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class FloodFill {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0,0,0},{0,1,0}}, 1, 1, 2)));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<PairTwo> q = new LinkedList<>();
        int toChange = image[sr][sc];
        image[sr][sc] = color;
        int n = image.length, m = image[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        q.add(new PairTwo(sr, sc));
        int[][] vis = new int[n][m];
        while(!q.isEmpty()){
            PairTwo pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = pair.row + drow[i];
                int ncol = pair.col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol]==toChange && vis[nrow][ncol]==0){
                    image[nrow][ncol] = color;
                    q.add(new PairTwo(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return image;
    }
}
