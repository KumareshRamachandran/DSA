import javax.imageio.ImageTranscoder;
import java.util.Arrays;

public class NutsAndBolts {
    public static void main(String[] args) {
        char[] nuts = {'@','%','$','#','^'};
        char[] bolts = {'$','#','@','%','^'};
        matchPairs(nuts.length, nuts, bolts);
        System.out.println(Arrays.toString(bolts));
    }
    static void matchPairs(int n, char[] nuts, char[] bolts) {
        Arrays.sort(nuts);
        Arrays.sort(bolts);
    }
}
