public class PadovanSequence {
    public static void main(String[] args) {
        System.out.println(padovanSequence(3));
    }
    public static int padovanSequence(int n)
    {
        if(n<3) return 1;
        int pre3 = 1, pre2 = 1, pre1 = 1;
        for(int i=3; i<=n; i++){
            int ans = pre2 + pre3;
            ans %= (int) 1e9 + 7;
            pre3 = pre2;
            pre2 = pre1;
            pre1 = ans;
        }
        return pre1;
    }
}
