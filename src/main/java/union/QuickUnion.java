package union;

public class QuickUnion extends UnionFind {
    public QuickUnion(int nNodes) {
        super(nNodes);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        compIds[pRoot] = qRoot;

        counter--;
    }

    @Override
    public int find(int p) {
        while (compIds[p] != p) {
            p = compIds[p];
        }
        return p;

    }

    
}