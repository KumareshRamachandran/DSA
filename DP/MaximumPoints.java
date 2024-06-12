public class MaximumPoints {
    public int maximumPoints(int points[][],int n){
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][1], points[0][0]);
        dp[3] = Math.max(points[0][0],Math.max(points[0][1], points[0][2]));
        for(int day = 1; day<n; day++){
            int[] temp = new int[4];
            for(int last = 0; last<4; last++){
                temp[last] = 0;
                for(int task=0; task<3; task++){
                    if(task!=last){
                        temp[last] = Math.max(temp[last], points[day][task]+dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }
}
