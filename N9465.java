import java.io.*;
import java.util.*;

public class N9465 {
	static int n;
	static int[][] sticker;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for (int test_case=1; test_case<=tc; test_case++) {
			n = Integer.parseInt(br.readLine());
			sticker = new int[2][n+1];
			for (int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=1; j<=n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i=2; i<=n; i++) {
				sticker[0][i] += Math.max(sticker[1][i-2], sticker[1][i-1]);
				sticker[1][i] += Math.max(sticker[0][i-2], sticker[0][i-1]);
			}
			System.out.println(Math.max(sticker[0][n], sticker[1][n]));
		}
	}
}