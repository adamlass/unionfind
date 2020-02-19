package union;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("::pick number of nodes:");
        int nNodes = sc.nextInt();

        System.out.println("::do you want to use QuickUnion (write 'true') or WeightedUnion (write 'false')?");
        Boolean useQuick = sc.nextBoolean();

        UnionFind uf = new QuickUnion(nNodes);

        if (!useQuick) {
            uf = new WeightedUnion(nNodes);
        }

        System.out.println("Created " + uf.getClass().getSimpleName() + " class with " + nNodes + " nodes!");

        do {
            System.out.println("::pick a p:");
            System.out.flush();
            int p = sc.nextInt();

            System.out.println("::pick a q:");
            int q = sc.nextInt();

            if (p > nNodes - 1 || q > nNodes - 1) {
                System.out.println("Out of bounds! skipping input");
                continue;
            }

            if (uf.connected(p, q)) {
                System.out.println("Nodes was already connected!");
                continue;
            }

            uf.union(p, q);
            System.out.println("--" + p + " was connected with " + q + "--");
            
            System.out.println("-- Number of components: " + uf.count() + "--");
        } while (uf.count() != 1);
        System.out.println("--EVERYTHING IS CONNECTED!!--");

        sc.close();

    }
}
