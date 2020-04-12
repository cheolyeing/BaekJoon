import java.io.*;
import java.util.*;
public class N1138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[n+1];
		for (int i=1; i<=n; i++) {
			int cnt = 0;
			for (int j=1; j<=n; j++) {
				if(cnt==arr[i] && ans[j]==0) {
					ans[j] = i; break;
				}
				if(ans[j]==0) cnt++;
			}
		}
		
		for (int i=1; i<=n; i++) System.out.print(ans[i]+" ");
	}
}