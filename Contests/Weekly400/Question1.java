package Weekly400;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(minimumChairs("EEEEEEE"));
    }
    public static int minimumChairs(String s) {
        int e = 0, l = 0, ans = 0;
        for(char i: s.toCharArray()){
            if(i=='E') {
                e++;
                ans = Math.max(e, ans);
            }
            if(i=='L') e--;
        }
        return ans;
    }
}
