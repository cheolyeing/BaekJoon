import java.io.*;
import java.util.*;

public class N1197 {

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static int v, e, root[], answer = 0;
    static Node[] edge;

    static class Node implements Comparable<Node> {
        public int e1, e2, w;

        public Node(int e1, int e2, int w) {
            this.e1 = e1;
            this.e2 = e2;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w > node.w ? 1 : -1;
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        root = new int[v + 1];
        edge = new Node[e];

        for (int i = 1; i <= v; i++) root[i] = i;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edge[i] = new Node(e1, e2, w);
        }
    }

    static void solution() {
        Arrays.sort(edge);
        int visited = 0;

        for (Node node : edge) {
            int e1 = node.e1;
            int e2 = node.e2;
            int w = node.w;

            if (visited == v - 1) break;
            if (makeCycle(e1, e2)) continue;
            union(e1, e2);

            answer += w;
            visited++;
        }
        System.out.println(answer);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) root[y] = x;
            else root[x] = y;
        }
    }

    static int find(int x) {
        if (x == root[x]) return x;
        else return root[x] = find(root[x]);
    }

    static boolean makeCycle(int x, int y) {
        return find(x) == find(y);
    }
}
