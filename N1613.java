import java.io.*;
import java.util.*;

public class N1613 {
	static int n, k;
	static int[][] history;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		history = new int[n+1][n+1];
		
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int bef = Integer.parseInt(st.nextToken());
			int aft = Integer.parseInt(st.nextToken());
			history[bef][aft] = -1;
			history[aft][bef] = 1;
		}
		
		int cnt = -1;
		while(cnt!=0) {
			cnt = 0;
			for(int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if(history[i][j]!=-1) continue;
					for (int k=1; k<=n; k++) {
						if(history[j][k]==-1 && history[i][k]!=-1) {
							history[i][k] = -1; history[k][i]=1; cnt++;
						}
					}
				}
			}
		}
		
		int question = Integer.parseInt(br.readLine());
		
		for (int i=0; i<question; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(history[start][end]);
		}
	}
}