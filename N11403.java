import java.io.*;

public class N11403 {	
	static int[][] map;
	static int[] visit;
	static int n;
	
	static void dfs(int v) {
		for (int i=0; i<n; i++) {
			if(map[v][i]==1 && visit[i]==0) {
				visit[i] = 1;
				dfs(i);
			}
		}
	} // DFS function
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Input
		n = Integer.parseInt(br.readLine());
		visit = new int[n];	map = new int[n][n];
		
		for (int i=0; i<n; i++) {
			String[] input = br.readLine().trim().split(" ");
			for (int j=0; j<n; j++) {
				map[i][j] = input[j].compareTo("1")==0 ? 1 : 0;
			}
		}
		// DFS
		for (int i=0; i<n; i++) {
			visit = new int[n];
			dfs(i);
			map[i] = visit;
		}
		// Print
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(map[i][j]==1) {sb.append("1 ");}
				else {sb.append("0 ");}
			} sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}