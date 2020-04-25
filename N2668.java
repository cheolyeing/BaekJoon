import java.io.*;
import java.util.*;

public class N2668 {
	static int n, arr[];
	static boolean[] visited, explore;
	static HashSet<Integer> hs = new HashSet<Integer>();
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		for(int i=1; i<=n; i++) {
			goDFS(i);
		}
		System.out.println(hs.size());
		ArrayList<Integer> li = new ArrayList<Integer>(hs);
		Collections.sort(li);
		for(int i : li) System.out.println(i);
	}
	
	static void goDFS(int i) {
		if(!visited[i]) {
			explore = new boolean[n+1];
			dfs(i);
		}
	}
	
	static void dfs(int i) {
		if(explore[i]) {
			explore = new boolean[n+1];
			putHash(i);
			return;
		}
		explore[i] = true;
		dfs(arr[i]);
	}
	
	static void putHash(int i) {
		if(explore[i]) return;
		hs.add(i);
		explore[i] = true;
		visited[i] = true;
		putHash(arr[i]);
	}
}
