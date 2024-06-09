package Weekly401;

import java.util.Arrays;

public class Question3 {
    public static void main(String[] args) {
        System.out.println(maxTotalReward(new int[]{1,6,4,3,2}));
    }
    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int reward = 0;
        for (int rewardValue : rewardValues) {
            if (reward < rewardValue) reward += rewardValue;
        }
        return reward;
    }
}
