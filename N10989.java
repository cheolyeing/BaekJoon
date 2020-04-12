import java.io.*;
import java.util.*;

public class N10989 {
	static int n, max=0;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] ans = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int[] cnt = new int[max+1];
		for(int i=0; i<n; i++) {
			cnt[arr[i]]++;
		}
		
		for(int i=1; i<=max; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for(int i=0; i<n; i++) {
			int num = arr[i];
			ans[--cnt[num]] = num;
		}
		
		for(int i=0; i<n; i++) {
			bw.write(ans[i]+"\n");
		}
		bw.flush();
	}
}