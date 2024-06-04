import java.util.HashMap;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(char i: s.toCharArray()){
            mpp.put(i, mpp.getOrDefault(i, 0)+1);
        }
        int ans = 1; boolean isOdd = false;
        for(char i: mpp.keySet()){
            if(mpp.get(i)%2==1) isOdd=true;
            ans += mpp.get(i)/2;
        }
        if(isOdd) ans += 1;
        return ans;
    }
}
