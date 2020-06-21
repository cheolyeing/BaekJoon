import java.io.*;
import java.util.*;

public class N1300 {
    static int n, k, ans=0;
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }

    static void solution() {
        int left = 1, right = k;
        while(left<=right) {
            long cnt = 0;
            int mid = (left+right) / 2;
            for(int i=1; i<=n; i++) {
                cnt += Math.min(mid/i, n);
            }
            if(cnt<k) left = mid+1;
            else {
                ans=mid; right=mid-1;
            }
        }
        System.out.println(ans);
    }
}
