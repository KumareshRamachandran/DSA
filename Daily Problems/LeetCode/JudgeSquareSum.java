public class JudgeSquareSum {
    public static boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while(left<=right){
            long curr = (long)Math.pow(left, 2)+(long)Math.pow(right, 2);
            if(curr==c) return true;
            if(curr>c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}
