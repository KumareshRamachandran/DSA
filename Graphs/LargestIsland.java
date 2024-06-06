import java.util.HashMap;
import java.util.HashSet;

public class LargestIsland {
    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1,1},{0,1}}));
    }
    public static boolean isValid(int nRow, int nCol, int n, int m){
        return nRow>=0 && nRow<n && nCol>=0 && nCol<m;
    }
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n*n);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col]==0) continue;
                int[] dRow = {-1, 0, 1, 0}, dCol = {0, -1, 0, 1};
                for (int k = 0; k < 4; k++) {
                    int nRow = row + dRow[k];
                    int nCol = col + dCol[k];
                    if(isValid(nRow, nCol, n, n) && grid[nRow][nCol]==1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = nRow * n + nCol;
                        ds.union(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col]==1) continue;
                int[] dRow = {-1, 0, 1, 0}, dCol = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int nRow = row + dRow[ind];
                    int nCol = col + dCol[ind];
                    if(isValid(nRow, nCol, n, n)){
                        if(grid[nRow][nCol]==1){
                            components.add(ds.findUPar(nRow*n+nCol));
                        }
                    }
                }
                int sizeTotal = 0;
                for(Integer parents: components){
                    sizeTotal += ds.size[parents];
                }
                mx = Math.max(sizeTotal+1, mx);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size[ds.findUPar(cellNo)]);
        }
        return mx;
    }
}
