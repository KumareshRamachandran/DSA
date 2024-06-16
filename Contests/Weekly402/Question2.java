package Weekly402;

import java.util.HashMap;

public class Question2 {
    public static long countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        long cnt = 0;
        for (int i : hours) {
            int rem = i % 24;
            int cRem = (24 - rem) % 24;
            if (mpp.containsKey(cRem)) {
                cnt += mpp.get(cRem);
            }
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);
        }
        return cnt;
    }
}
