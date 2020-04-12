import java.io.*;
import java.util.*;

public class N1916 {
	
	static int n;
	static int m;
	static int[][] bus;
	static int answer = Integer.MAX_VALUE;
	static int start;
	static int finish;
	static int[] algorithm;
	static boolean[] visit;
	
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
		System.out.println(algorithm[finish]);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		algorithm = new int[n+1]; visit = new boolean[n+1];
		Arrays.fill(algorithm, Integer.MAX_VALUE);
		bus = new int[m][3];
		for (int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				bus[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		visit[start] = true; algorithm[start] = 0;
		finish = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		for(int k=0; k<n; k++) {
			for(int i=0; i<m; i++) {
				if(visit[bus[i][0]]) {
					algorithm[bus[i][1]] = Math.min(algorithm[bus[i][1]], algorithm[bus[i][0]]+bus[i][2]);
					visit[bus[i][1]] = true;
				}
			}
		}
	}
}