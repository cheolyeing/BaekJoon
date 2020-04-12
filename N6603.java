import java.io.*;
import java.util.*;

public class N6603 {
	
	static int n;
	static String[] nums;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		
		while(!s.equals("0")) {
			st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			nums = new String[n];
			visit = new boolean[n];
			for (int i=0; i<n; i++) { nums[i] = st.nextToken();	}
			
			String[] ans = new String[6];
			dfs(-1, 0, ans);
			
			sb.append("\n");
			s = br.readLine();
		} System.out.println(sb.toString());
	}
	
	static void dfs(int bef, int idx, String[] ans) {
		if(idx==6) { showArray(ans); return; }
		if(n-bef-1<6-idx) { return; }
		for (int i=bef+1; i<n; i++) {
			ans[idx]=nums[i];
			dfs(i, idx+1, ans);
		}
	}
	
	static void showArray(String[] ans) {
		for (String i : ans) { sb.append(i+" "); }
		sb.append("\n");
	}
}