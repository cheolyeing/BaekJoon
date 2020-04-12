import java.io.*;
import java.util.*;

public class N1915 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m+1];
		int ans = 0;
		
		for (int i=1; i<=n; i++) {
			String input = br.readLine();
			for (int j=1; j<=m; j++) {
				map[i][j] = input.charAt(j-1)-'0';
				if(map[i][j]==1) {
					map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
					ans = Math.max(ans, map[i][j]);
				}
			}
		} System.out.println(ans*ans);
	}
}