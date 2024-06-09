public class SubArraysDivByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        int sum = 0;
        for(int i: nums){
            sum += ((i%k+k)%k);
            count[sum%k]++;
        }
        int result = count[0];
        for(int i: count){
            result += (i * (i-1)/2);
        }
        return result;
    }
}
