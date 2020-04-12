import java.io.*;
import java.util.*;

public class N15650 {
	
	static int[] num;
	static int n, r;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int bef, int idx, int[] ans) {
		if(idx==r) { printArray(ans); return; }
		if(n-bef<r-idx) { return; }
		
		for(int i=bef+1; i<=n; i++) {
			ans[idx] = i;
			dfs(i, idx+1, ans);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[r];
		dfs(0, 0, ans);
		System.out.println(sb.toString());
	}
	
	static void printArray(int[] arr) {
		for(int i : arr) { sb.append(i+" "); } sb.append("\n");}
}

/*import java.io.*;
import java.util.*;

public class N15650 {
	
	static int[] num;
	static int n, r;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int bef, int idx, String ans) {
		if(idx==r) { sb.append(ans+"\n"); return; }
		if(n-bef<r-idx) { return; }
		
		for(int i=bef+1; i<=n; i++) {
			dfs(i, idx+1, ans+i+" ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		dfs(0, 0, "");
		System.out.println(sb.toString());
	}
}*/