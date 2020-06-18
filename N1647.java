import java.io.*;
import java.util.*;

public class N1647 {
    static int n, m, answer = 0;
    static int parent[];
    static PriorityQueue<Road> pq = new PriorityQueue<>();

    static class Road implements Comparable<Road> {
        int h1, h2, w;

        public Road(int h1, int h2, int w) {
            this.h1 = h1;
            this.h2 = h2;
            this.w = w;
        }

        @Override
        public int compareTo(Road road) {
            return this.w < road.w ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Road(h1, h2, w));
        }
    }

    static void solution() {
        int connect = 0;

        while(connect<n-2) {
            Road r = pq.poll();

            if (connect == n - 2) break;
            if (makeCycle(r.h1, r.h2)) continue;

            union(r.h1, r.h2);
            answer += r.w;

            connect++;
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    static boolean makeCycle(int x, int y) {
        return find(x) == find(y);
    }
}
