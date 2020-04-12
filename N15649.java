import java.io.*;
import java.util.*;

public class N15649 {
	
	static int[] num;
	static int n, r;
	static boolean[] visit;
	
	public static void dfs(int idx, int[] ans) {
		if(idx==r) { printArray(ans); return; }
		
		for(int i=1; i<=n; i++) {
			if(!visit[i]) {
				ans[idx] = i; visit[i]=true;
				dfs(idx+1, ans);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];
		
		int[] ans = new int[r];
		dfs(0, ans);
	}
	
	static void printArray(int[] arr) {
		for(int i : arr) { System.out.print(i+" "); } System.out.println();}
}