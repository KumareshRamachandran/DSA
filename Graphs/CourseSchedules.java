import java.util.*;

public class CourseSchedules {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for(int j: adj.get(i)){
                inDegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0) q.add(i);
        }
        int[] ans = new int[numCourses]; int k = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans[k++] = node;
            for (int i : adj.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0) q.add(i);
            }
        }
        if(numCourses==k) {
            return ans;
        }else{
            return new int[]{};
        }
    }
}
