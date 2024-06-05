import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        Disjoint ds = new Disjoint(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                } else{
                    ds.union(i, mapMailNode.get(mail));
                }
            }
        }
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<String>();
        }
        for(Map.Entry<String, Integer> it: mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).getFirst());
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }
}
