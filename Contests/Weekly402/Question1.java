package Weekly402;

import java.util.HashMap;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs(new int[]{12,12,30,24,24}));
    }
    public static int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        for(int i=0; i<hours.length; i++){
            for (int j = 0; j < hours.length; j++) {
                if(i!=j){
                    if((hours[i]+hours[j])%24==0) ans++;
                }
            }
        }
        return ans/2;
    }
}
