public class Disjoint{
    int[] parent, size;
    Disjoint(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUPar(int x){
        if(parent[x]==x) return x;
        return parent[x] = findUPar(parent[x]);
    }
    public void union(int x, int y){
        int pu = findUPar(x);
        int pv = findUPar(y);
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}