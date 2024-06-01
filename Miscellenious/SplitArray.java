import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        System.out.println(isPossibleToSplit(new int[]{10,7,10,8,8,8}));
    }
    public static boolean isPossibleToSplit(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0]; int counter = 1;
        for(int i=1; i<nums.length; i++){
            if(prev==nums[i]) counter++;
            else counter = 1;
            prev = nums[i];
            if(counter>=3) return false;
        }
        return true;
    }
}
