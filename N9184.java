import java.io.*;
import java.util.*;

public class N9184 {
	
	static int[][][] dp = new int[21][21][21];
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1 && c==-1) { break; }
			System.out.println("w("+a+", "+b+", "+c+") = "+W(a,b,c));
		}
	}
	
	static int W(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) { return 1; }
		if(a>20 || b>20 || c>20) { return W(20, 20, 20); }
		if(dp[a][b][c]!=0) { return dp[a][b][c]; }
		else {
			if(a<b && b<c) { dp[a][b][c] = W(a, b, c-1) + W(a, b-1, c-1) - W(a, b-1, c); }
			else { dp[a][b][c] = W(a-1, b, c) + W(a-1, b-1, c) + W(a-1, b, c-1) - W(a-1, b-1, c-1); }
		} return dp[a][b][c];
	}
}