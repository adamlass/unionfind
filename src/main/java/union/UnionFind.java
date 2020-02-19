package union;

public abstract class UnionFind {
    protected int counter;
    protected int[] compIds;

    
    public UnionFind(int nNodes) {
        counter = nNodes;
        compIds = new int[nNodes];
        for (int i = 0; i < nNodes; i++)
            compIds[i] = i;
    }
    
    public int count() {
        return counter;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public abstract void union(int p, int q);
    public abstract int find(int p);
}