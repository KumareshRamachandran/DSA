import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppendCharacters {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }
    public static int appendCharacters(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++)
            j += s.charAt(i) == t.charAt(j) ? 1 : 0;
        return t.length() - j;
    }
}
