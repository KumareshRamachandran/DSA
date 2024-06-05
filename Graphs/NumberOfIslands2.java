import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public static boolean isValid(int nRow, int nCol, int n, int m){
        return nRow>=0 && nRow<n && nCol>=0 && nCol<m;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        Disjoint ds = new Disjoint(n*m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int j = 0; j < 4; j++) {
                int nRow = row + dRow[j];
                int nCol = col + dCol[j];
                if(isValid(nRow, nCol, n, m)){
                    if(vis[nRow][nCol]==1){
                        int nodeNo = row * m + col;
                        int adjNodeNo = nRow * m + nCol;
                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                            cnt--;
                            ds.union(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
