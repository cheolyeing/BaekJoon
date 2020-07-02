import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int tree[];
    static long sum[];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[n];
        sum = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        Arrays.sort(tree);
        sum[0] = tree[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + tree[i];
        }

        int left = 0, right = 1000000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if(left==mid) break;
            long get = getTrees(mid);
            if (get < m) right = mid;
            else left = mid;
        }
        System.out.println(left);
    }

    static int upperBound(int arr[], int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= key) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    static long getTrees(int h) {
        int cutIdx = upperBound(tree, 0, n - 1, h);
        long treeNum = n - cutIdx;

        long getTree = sum[n - 1] - treeNum * h;
        if (cutIdx != 0) getTree -= sum[cutIdx - 1];

        return getTree;
    }
}
