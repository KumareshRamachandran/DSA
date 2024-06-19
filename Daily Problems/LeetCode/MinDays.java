public class MinDays {
    public int minDays(int[] bloomDay, int m, int k) {
        long temp = (long) m*k;
        if(temp>bloomDay.length) return -1;
        int low = (minAndMax(bloomDay))[0], high = (minAndMax(bloomDay))[1];
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(possible(bloomDay, mid, m, k)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    public static boolean possible(int[] arr, int day,int  m,int k){
        int cnt = 0, noOf = 0;
        for (int j : arr) {
            if (j <= day) cnt++;
            else {
                noOf += (cnt / k);
                cnt = 0;
            }

        }
        noOf += (cnt/k);
        return noOf >= m;
    }
    public static int[] minAndMax(int[] arr){
        int min = arr[0], max = arr[0];
        for(int i: arr){
            if(min>i) min = i;
            if(max<i) max = i;
        }
        return new int[]{min, max};
    }
}
