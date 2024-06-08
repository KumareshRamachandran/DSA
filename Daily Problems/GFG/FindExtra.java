public class FindExtra {
    public static void main(String[] args) {
        System.out.println(findExtra(7, new int[]{2,4,6,8,9,10,12},
                new int[]{2,4,6,8,9,10}));
    }
    public static int findExtra(int n, int[] arr1, int[] arr2) {
        for(int i=0; i<n-1; i++){
            if(arr1[i]!=arr2[i]) return i;
        }
        return n-1;
    }
}
