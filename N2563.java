import java.io.*;
import java.util.*;

public class N2563 {
	static int n, ans=0;
	static int[][] paper = new int[101][101];
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			full(x, y);
		}
	}
	
	static void full(int x, int y) {
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				if(paper[i][j]==0) {
					ans++;
					paper[i][j]=1;
				}
			}
		}
	}
}
