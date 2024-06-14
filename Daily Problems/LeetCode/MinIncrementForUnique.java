import java.util.*;

public class MinIncrementForUnique {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1,2,2,3,3,3,3,3,3,3,4,4,4,4,4}));
    }
    public static int minIncrementForUnique(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i]<=nums[i-1]){
                int newValue = nums[i-1]+1;
                total += newValue - nums[i];
                nums[i] = newValue;
            }
        }
        return total;
    }
}
