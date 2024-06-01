import java.util.Stack;

public class LengthOfHistogram {
    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = stk.peek()+1;
            stk.push(i);
        }
        for (int i = n-1; i>=0; i--) {
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()) rightSmall[i] = 0;
            else rightSmall[i] = stk.peek()+1;
            stk.push(i);
        }
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        return maxA;
    }
}
