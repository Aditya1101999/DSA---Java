package DSAinJava.Graphs;
import java.util.*;
public class GCDTraversal {
    class DSU {
        int[] parent;
        int[] size;
        int components;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findPar(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = findPar(parent[u]);
        }

        public void union(int u, int v) {
            int uPar = findPar(u);
            int vPar = findPar(v);
            if (uPar == vPar)
                return;
            if (size[uPar] > size[vPar]) {
                parent[vPar] = uPar;
                size[uPar] += size[vPar];
            } else {
                parent[uPar] = vPar;
                size[vPar] += size[uPar];
            }
            components--;
        }

        public int getComponents() {
            return components;
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int factor = 2; factor * factor <= nums[i]; factor++) {
                if (nums[i] % factor == 0) {
                    if (map.containsKey(factor)) {
                        dsu.union(map.get(factor), i);
                    } else {
                        map.put(factor, i);
                    }
                    while (nums[i] % factor == 0)
                        nums[i] /= factor;
                }
            }
            if (nums[i] > 1) {
                if (map.containsKey(nums[i])) {
                    dsu.union(map.get(nums[i]), i);
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return dsu.getComponents() == 1;
    }
}
