package Weekly400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Question2 {
    public static void main(String[] args) {
        System.out.println(countDays(8,  new int[][]{{2,3},{3,5},{8,8}}));
    }
    public static int countDays(int days, int[][] meetings) {
        int[] intervals = {Integer.MAX_VALUE, Integer.MIN_VALUE}; int ans = 0;
        if(meetings.length==1) intervals = meetings[0];
        for(int i=0; i<meetings.length-1; i++){
            if(meetings[i][1]==meetings[i+1][0]) {
                intervals[0] = Math.min(intervals[0], Math.min(meetings[i][0], meetings[i+1][0]));
                intervals[1] = Math.max(intervals[1], Math.max(meetings[i][1], meetings[i+1][1]));
                continue;
            }
            if(meetings[i][1]<meetings[i+1][0] ){
                ans += Math.abs(intervals[1]-meetings[i+1][0]);
            }
            if(meetings[i][0]>meetings[i+1][1] && (meetings[i+1][1]<intervals[0] && meetings[i][0]>intervals[1])){
                ans += Math.abs(intervals[0]-meetings[i+1][1]);
            }
            intervals[0] = Math.min(intervals[0], Math.min(meetings[i][0], meetings[i+1][0]));
            intervals[1] = Math.max(intervals[1], Math.max(meetings[i][1], meetings[i+1][1]));
        }
        ans += intervals[0] - 1;
        ans += days - intervals[1];
        return ans;
//        int[] vis = new int[days + 2];
//        for (int[] i : meetings) {
//            int start = i[0];
//            int end = i[1];
//            vis[start]++;
//            if (end + 1 <= days) {
//                vis[end + 1]--;
//            }
//        }
//        int temp = 0;
//        int ans = 0;
//
//        for (int day = 1; day <= days; day++) {
//            temp += vis[day];
//            if (temp == 0) {
//                ans++;
//            }
//        }
//        return ans;
    }
}
