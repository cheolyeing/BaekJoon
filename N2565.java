import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Pair> line = new ArrayList<>();

    static class Pair implements Comparable<Pair> {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair p) {
            return this.a - p.a;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line.add(new Pair(a, b));
        }
    }

    static void solution() {
        Collections.sort(line);
        System.out.println(n-LIS());
    }

    static int LIS() {
        int lis[] = new int[n];
        lis[0] = line.get(0).b;
        int idx = 1;

        for (int i = 1; i < n; i++) {
            int num = line.get(i).b;
            if (lis[idx-1] < num) {
                lis[idx++] = num;
            } else if (lis[0] > num) {
                lis[0] = num;
            } else {
                int tmp = Arrays.binarySearch(lis, 0, idx, num);
                lis[tmp<0 ? -tmp-1 : tmp] = num;
            }
        }
        return idx;
    }
}
