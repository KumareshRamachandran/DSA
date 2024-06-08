import java.util.HashMap;

public class CheckSubArraySum {
    public static void main(String[] args) {
        System.out.println(checkSubArraySum(new int[]{23,2,4,6,7},6));
    }
    public static boolean checkSubArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            int remainder = total % k;
            if(!mpp.containsKey(remainder)){
                mpp.put(remainder, i);
            } else if(i-mpp.get(remainder)>1){
                return true;
            }
        }
        return false;
    }
}
