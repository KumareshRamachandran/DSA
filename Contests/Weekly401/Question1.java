package Weekly401;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(numberOfChild(3,5));
    }
    public static int numberOfChild(int n, int k) {
        int i=0; boolean up = true, down = false;
        while(k>0){
            if(up) i++;
            if(down) i--;
            if(i==n) {
                down = true; up = false;
                i = n-2;
            }
            if(i==0){
                up = true; down = false;
            }
            k--;
        }
        return i;
    }
}
