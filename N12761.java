import java.io.*;
import java.util.*;

public class N12761 {

    static int A, B, N, M;
    static int[] map;

    public static void main(String[] args) throws IOException {
        read();
        solution();
        write();
    }

    public static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.close();
    }

    public static void solution() {
        map = new int[100001];
        Arrays.fill(map, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<Integer>();
        map[N] = 0;
        q.add(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map[cur] >= map[M]) continue;
            int[] next = {cur + 1, cur - 1, cur + A, cur + B, cur - A, cur - B, cur * A, cur * B};
            for (int pos : next) {
                if (inRange(pos) && map[cur] + 1 < map[pos]) {
                    map[pos] = map[cur] + 1;
                    q.add(pos);
                }
            }
        }
    }

    public static void write() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(map[M]));
        bw.flush();
        bw.close();
    }

    public static boolean inRange(int x) {
        return 0 <= x && x <= 100000;
    }
}
