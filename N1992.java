import java.io.*;
import java.util.*;

public class N1992 {
	static int n, img[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		img = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				img[i][j] = s.charAt(j)-'0';
			}
		}
	}
	
	static void solution() {
		System.out.println(dfs(0, 0, n, n, ""));
	}
	
	static String dfs(int x1, int y1, int x2, int y2, String s) {
		if(zip(x1, y1, x2, y2)) return img[x1][y1]+"";
		s += dfs(x1, y1, x1+(x2-x1)/2, y1+(y2-y1)/2, "");
		s += dfs(x1, y1+(y2-y1)/2, x1+(x2-x1)/2, y2, "");
		s += dfs(x1+(x2-x1)/2, y1, x2, y1+(y2-y1)/2, "");
		s += dfs(x1+(x2-x1)/2, y1+(y2-y1)/2, x2, y2, "");
		return s.length()==1 ? s : "("+s+")";
	}
	
	static boolean zip(int x1, int y1, int x2, int y2) {
		int s = img[x1][y1];
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				if(s!=img[i][j]) return false;
			}
		}
		return true;
	}
}
