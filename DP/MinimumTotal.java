import java.util.Arrays;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];
        for(int i=0; i<dp.length; i++){
            int[] temp = new int[triangle.get(i).size()];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }
        return helper(0, 0, dp, triangle);
    }
    public int helper(int i, int j, int[][] dp, List<List<Integer>> a){
        if(i==a.size()-1) return a.getLast().get(j);
        if(dp[i][j] !=-1) return dp[i][j];
        int down = a.get(i).get(j) + helper(i, j-1, dp, a);
        int downDiagonal = a.get(i).get(j+1) + helper(i-1, j, dp, a);
        return dp[i][j] = Math.min(downDiagonal, down);
    }
}
