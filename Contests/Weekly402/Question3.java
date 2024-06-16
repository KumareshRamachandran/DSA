package Weekly402;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[]{7,1,6,3}));
    }
    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int j : power) {
            mpp.put(j, mpp.getOrDefault(j, 0) + 1);
        }
        long max = 0;
        List<Integer> keySet = new ArrayList<>(mpp.keySet());
        Collections.sort(keySet, Collections.reverseOrder());
        for(int j: keySet) {
            long ans = 0;
            List<Integer> neg = new ArrayList<>();
            neg.add(j-1); neg.add(j+1);
            neg.add(j-2); neg.add(j+2);
            for(int i: keySet){
                if(!neg.contains(i)) {
                    ans += (long) mpp.get(i) * i;
                    neg.add(i-1); neg.add(i+1);
                    neg.add(i-2); neg.add(i+2);
                }
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}
