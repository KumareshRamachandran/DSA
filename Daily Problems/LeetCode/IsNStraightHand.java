import java.util.TreeMap;


public class IsNStraightHand {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize==1) return true;
        TreeMap<Integer, Integer> mpp = new TreeMap<>();
        for(int i: hand){
            mpp.put(i, mpp.getOrDefault(i, 0)+1);
        }
        while(!mpp.isEmpty()){
            var temp = mpp.firstEntry();
            int prev = temp.getKey();
            mpp.put(prev, mpp.get(prev)-1);
            if(mpp.get(prev)==0) mpp.remove(prev);
            for(int i=1; i<groupSize; i++){
                if(mpp.containsKey(prev+1)){
                    mpp.put(prev+1, mpp.get(prev+1)-1);
                    if(mpp.get(prev+1)==0) mpp.remove(prev+1);
                    prev++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
