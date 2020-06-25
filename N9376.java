import java.io.*;
import java.util.*;

public class Main {

    static int h, w;
    static int d[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int cnt[][];
    static char map[][];
    static int visited[][];
    static Point prisoner[];

    static class Point {
        public int x, y, k;

        public Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        char[] a = new char[2];
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            prisoner = new Point[2];
            int pNum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = input.charAt(j - 1);
                    if (map[i][j] == '$') {
                        prisoner[pNum++] = new Point(i, j, 1);
                    }
                }
            }
            solution();
        }
    }

    static void solution() {
        cnt = new int[h + 2][w + 2];

        bfs(prisoner[0]);
        add(cnt, visited);
        bfs(prisoner[1]);
        add(cnt, visited);
        bfs(new Point(0, 0, 1));
        add(cnt, visited);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < h + 2; i++) {
            for (int j = 0; j < w + 2; j++) {
                answer = Math.min(answer, cnt[i][j]);
            }
        }
        System.out.println(answer-2);
    }

    static void bfs(Point pos) {
        visited = new int[h + 2][w + 2];
        for (int i = 0; i < h + 2; i++) for (int j = 0; j < w + 2; j++) visited[i][j] = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        q.add(pos);
        visited[pos.x][pos.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                Point np = new Point(p.x + d[i][0], p.y + d[i][1], p.k);
                if (inRange(np) && np.k < visited[np.x][np.y] && map[np.x][np.y] != '*') {


                    visited[np.x][np.y] = np.k;
                    if (map[np.x][np.y] == '#') {
                        np.k++;
                    }
                    q.add(np);
                }
            }
        }
    }

    static void add(int[][] cnt, int[][] arr) {
        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                cnt[i][j] += arr[i][j];
            }
        }
    }

    static boolean inRange(Point p) {
        return p.x >= 0 && p.x < h + 2 && p.y >= 0 && p.y < w + 2;
    }
}
