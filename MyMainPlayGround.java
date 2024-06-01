import java.util.ArrayList;
import java.util.Arrays;

public class MyMainPlayGround {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));
    }
    public static int[] singleNumber(int[] nums) {
        Arrays.sort(nums); int[] ans = {0, 0}; int k = 0, start = 0;
        if(nums[0]!=nums[1]) {
            ans[k++] = nums[0]; start = 1;
        }
        if(nums[nums.length-2]!=nums[nums.length-1]){
            ans[k++] = nums[nums.length-1];
        }
        if(k==2) return ans;
        for (int i = start; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]) {
                ans[k++] = nums[i];
            } else{
                i++;
            }
        }
        return ans;
    }
}
