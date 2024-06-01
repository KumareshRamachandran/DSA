import java.util.*;

class Pair3{
    String first; int second;
    public Pair3(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class WordLadder1 {
    public static void main(String[] args) {
        System.out.println(ladderLength("ymain",
                "oecij", new ArrayList<>(List.of("ymann", "yycrj", "oecij", "ymcnj", "yzcrj",
                        "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"))));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair3> q = new LinkedList<>();
        q.add(new Pair3(beginWord, 1));
        wordList.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord)) return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = j;
                    String replacedWord = new String(replacedCharArray);
                    if(wordList.contains(replacedWord)){
                        wordList.remove(replacedWord);
                        q.add(new Pair3(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
