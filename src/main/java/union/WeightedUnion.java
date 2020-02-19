package union;

public class WeightedUnion extends UnionFind {
    private int[] compRoots;

    public WeightedUnion(int nNodes) {
        super(nNodes);

        compRoots = new int[nNodes];
        for (int i = 0; i < nNodes; i++)
            compRoots[i] = 1;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        if (compRoots[i] < compRoots[j]) {
            compIds[i] = j;
            compRoots[j] += compRoots[i];
        } else {
            compIds[j] = i;
            compRoots[i] += compRoots[j];
        }

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
