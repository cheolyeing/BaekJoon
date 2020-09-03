import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Line[] line;

    static class Line implements Comparable<Line> {
        public int left;
        public int right;

        public Line(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Line other) {
            if (this.left == other.left) {
                return this.right - other.right;
            } else return this.left - other.left;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = new Line[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(line);
    }

    static void solution() {
        int answer = 0;
        int left = -1000000000;
        int right = -1000000000;

        for (int i = 0; i < n; i++) {
            if (line[i].right <= right) continue;
            left = Math.max(right, line[i].left);
            right = line[i].right;
            answer += right - left;
        }

        System.out.println(answer);
    }
}
