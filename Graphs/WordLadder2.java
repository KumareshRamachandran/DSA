import java.util.*;
import java.lang.*;
import java.io.*;

public class WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(beginWord); q.add(ls);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            List<String> vec = q.poll();
            if(vec.size()>level){
                level++;
                for(String i: usedOnLevel) st.remove(i);
            }
            String word = vec.getLast();
            if(word.equals(endWord)){
                if(ans.isEmpty()) ans.add(vec);
                else if(ans.getFirst().size()==vec.size()) ans.add(vec);
            }
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = j;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        vec.add(replacedWord);
                        q.add(new ArrayList<>(vec));
                        usedOnLevel.add(replacedWord);
                        vec.removeLast();
                    }
                }
            }
        }
        return ans;
    }
}


// A comparator function to sort the answer.
class comp implements Comparator < ArrayList < String >> {

    public int compare(ArrayList < String > a, ArrayList < String > b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++)
            x += a.get(i);
        for (int i = 0; i < b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        String startWord = "der", targetWord = "dfs";
        List<String> wordList = new ArrayList<>(List.of(
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        ));

        Solution obj = new Solution();
        List<List<String>> ans = obj.findSequences(startWord, targetWord, wordList);

        // If no transformation sequence is possible.
        if (ans.size() == 0)
            System.out.println(-1);
        else {
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

class Solution {
    public List<List<String>> findSequences(String startWord, String targetWord,
                                                           List<String> wordList) {

        Set <String> st = new HashSet<>(wordList);
        Queue<List<String >> q = new LinkedList < > ();
        List <String> ls = new ArrayList < > ();
        ls.add(startWord);
        q.add(ls);
        List<String> usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(startWord);
        int level = 0;
        List < List < String >> ans = new ArrayList < > ();
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            List < String > vec = q.peek();
            q.remove();
            if (vec.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    st.remove(it);
                }
            }
            String word = vec.get(vec.size() - 1);
            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        List < String > temp = new ArrayList < > (vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;
    }
}

