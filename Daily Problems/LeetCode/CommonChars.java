import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonChars {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
    public static List<String> commonChars(String[] words) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(char i: words[0].toCharArray()){
            mpp.put(i, mpp.getOrDefault(i, 0)+1);
        }
        for(int i=1; i<words.length; i++){
            HashMap<Character, Integer> temp = new HashMap<>();
            for(char j: words[i].toCharArray()){
                temp.put(j, temp.getOrDefault(j, 0)+1);
            }
            HashMap<Character, Integer> ansMpp = new HashMap<>();
            for(Character j: temp.keySet()){
                if(mpp.containsKey(j)){
                    ansMpp.put(j, Math.min(temp.get(j), mpp.get(j)));
                }
            }
            mpp = ansMpp;
        }
        List<String> ans = new ArrayList<>();
        for(Character j: mpp.keySet()){
            for(int i=0; i<mpp.get(j); i++){
                ans.add("" + j);
            }
        }
        return ans;
    }
}
