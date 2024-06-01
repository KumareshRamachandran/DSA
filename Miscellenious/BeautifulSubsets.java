import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeautifulSubsets {
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{2,4,6}, 2));
    }
    public static int beautifulSubsets(int[] nums, int k) {
        int[] count = {0};
        helper(new ArrayList<>(), 0, nums, k, count);
        return count[0];
    }
    public static void helper(List<Integer> list,int idx, int[] nums, int k, int[] count){
        if(idx == nums.length){
            if(isBeautiful(new ArrayList<>(list), k)){
                count[0]++;
            }
            return;
        }
        list.add(nums[idx]);
        helper(list, idx+1, nums, k, count);
        list.removeLast();
        helper(list, idx+1, nums, k, count);
    }
    public static boolean isBeautiful(List<Integer> list, int k){
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(i!=j){
                    if(Math.abs(list.get(i)-list.get(j))==k) return false;
                }
            }
        }
        return !list.isEmpty();
    }
}
