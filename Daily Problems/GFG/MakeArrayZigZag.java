import java.util.Arrays;

public class MakeArrayZigZag {
    public static void main(String[] args) {
        int[] arr = {4,3,7,8,6,2,1};
        zigZag(7, arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void zigZag(int n, int[] arr) {
        for(int i=0; i<n-1; i++){
            if(i%2==0) {
                if(arr[i]>arr[i+1]) swap(i, i+1, arr);
            }else{
                if(arr[i]<arr[i+1]) swap(i, i+1, arr);
            }
        }
    }
    public static void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
