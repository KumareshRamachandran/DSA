import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,
                        5,23,29,48,30,31},
                new int[]{2,42,38,0,43,21})));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] ans = new int[arr1.length];
        for (int j : arr1) {
            count[j]++;
        } int idx = 0;
        for (int k : arr2) {
            int size = count[k];
            for (int j = 0; j < size; j++) {
                ans[idx++] = k;
                count[k]--;
            }
        }
        for(int i=0; i<count.length; i++){
            if(count[i]!=0){
                int size = count[i];
                for (int j = 0; j < size; j++) {
                    ans[idx++] = i;
                    count[i]--;
                }
            }
        }
        return ans;
    }
}
