import java.io.*;
import java.util.*;
public class N2617 {
	static int n, m, ans=0;
	static boolean[][] weightH, weightL;
	static int[] numHeavy;
	static int[] numLight;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		weightH = new boolean[n+1][n+1];
		weightL = new boolean[n+1][n+1];
		numHeavy = new int[n+1]; numLight = new int[n+1];
		Arrays.fill(numHeavy, -1); Arrays.fill(numLight, -1);
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			weightH[a][b] = true;
			weightL[b][a] = true;
		}
		
		for (int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			dfsH(i, i, 0);
			visited = new boolean[n+1];
			dfsL(i, i, 0);
		}
		
		for (int i=1; i<=n; i++) {
			if(numHeavy[i]>n/2 || numLight[i]>n/2) ans++;
		}
		System.out.println(ans);
	}
	
	static void dfsH(int start, int idx, int num) {
		visited[idx] = true;
		numHeavy[start]++;
		for (int i=1; i<=n; i++) {
			if(weightH[idx][i] && !visited[i])
				dfsH(start, i, num+1);
		}
	}
	
	static void dfsL(int start, int idx, int num) {
		visited[idx] = true;
		numLight[start]++;
		for (int i=1; i<=n; i++) {
			if(weightL[idx][i] && !visited[i])
				dfsL(start, i, num+1);
		}
	}
}