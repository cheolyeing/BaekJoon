import java.io.*;
import java.util.*;

public class Main {
    static int n, k, ans=0;
    static String[] word;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        word = new String[n];
        for (int i = 0; i < n; i++)
            word[i] = br.readLine();

        k = Integer.parseInt(br.readLine());
    }

    static void solution() {
        backTracking(new int[n], 0, new boolean[n]);
        System.out.println(ans);
    }

    static boolean magicWord(int arr[]) {
        String s = "";
        for(int i=0; i<n; i++) s += word[arr[i]];

        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(magicWordCheck(s, i)) cnt++;
        }
        return cnt==k;
    }

    static boolean magicWordCheck(String s, int i) {
        for(int j=0; j<s.length(); j++) {
            if(s.charAt(j)!=s.charAt((i+j)%s.length())) return false;
        }
        return true;
    }

    static void backTracking(int arr[], int num, boolean visited[]) {
        if(num==n) {
            if(magicWord(arr)) ans++;
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            arr[num] = i;
            visited[i] = true;
            backTracking(arr, num+1, visited);
            visited[i] = false;
        }
    }
}
