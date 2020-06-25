import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int a[], b[], c[], d[];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        long arr[] = new long[n * n];
        long brr[] = new long[n * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx] = a[i] + b[j];
                brr[idx] = c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        long ans = 0;
        for (int i = 0; i < n * n; i++) {
            ans += upperBound(brr, -arr[i]) - lowerBound(brr, -arr[i]);
        }
        System.out.println(ans);
    }

    static int upperBound(long[] arr, long num) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int lowerBound(long[] arr, long num) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
