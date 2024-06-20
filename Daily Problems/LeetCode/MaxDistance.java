import java.util.Arrays;

public class MaxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1, end = position[position.length-1] - position[0];
        int res = 0;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(Position(position,m,mid)){
                res = mid;
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return res;
    }
    public boolean Position(int [] position , int m , int barrier){
        int cnt =1 , pos = position[0];
        for(int i = 1; i< position.length;i++){
            if(position[i] - pos >= barrier){
                cnt++;
                pos = position[i];
            }
            if(cnt==m) return true;
        }
        return false;
    }
}
