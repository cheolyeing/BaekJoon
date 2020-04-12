import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15652 {
	
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		r = Integer.parseInt(input[1]);
		
		int[] ans = new int[r];
		dfs(1, 0, ans);
		System.out.println(sb.toString());
	}
	
	static void dfs(int bef, int idx, int[] ans) {
		if(idx==r) {
			printArray(ans); return;
		}
		for(int i=bef; i<=n; i++) {
			ans[idx] = i;
			dfs(i, idx+1, ans);
		}
	}
	
	static void printArray(int[] arr) {
		for(int i : arr) { 
			sb.append(i+" "); 
		} sb.append("\n");
	}
}