import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static int start, end;
    static boolean visited[];
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
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

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<Node>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            max = W > max ? W : max;

            adj.get(A).add(new Node(B, W));
            adj.get(B).add(new Node(A, W));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        System.out.println(binarySearch(start, end));
    }

    static long binarySearch(int from, int to) {
        long left = 1;
        long right = max;
        long mid;
        long ans = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (canGo(from, to, mid)) {
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    static boolean canGo(int from, int to, long weight) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        visited = new boolean[n + 1];

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == to) return true;

            for (Node next : adj.get(cur)) {
                if (!visited[next.to] && next.weight >= weight) {
                    q.add(next.to);
                    visited[next.to] = true;
                }
            }
        }
        return false;
    }
}
