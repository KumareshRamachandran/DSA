package Weekly401;

import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(22,15));
    }
    public static int valueAfterKSeconds(int n, int k) {
        if(n==1) return 1;
        int mod = (int) 1e9 + 7;
        int[] first = new int[n];
        int[] next = new int[n];
        Arrays.fill(first, 1);
        for(int i=0; i<k; i++){
            long sum = 1;
            for(int j=1; j<n; j++){
                sum += first[j];
                sum %= mod;
                next[j] = (int) sum;
            }
            first = next;
        }
        return first[n-1];
    }
}
