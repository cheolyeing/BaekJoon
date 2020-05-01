import java.io.*;
import java.util.*;

public class N1022_RE {
	static int r1, c1, r2, c2, size;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int max = Math.max(Math.max(value(r1,c1), value(r1,c2)), Math.max(value(r2,c1), value(r2,c2)));
		int len = (max+"").length();
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				sb.append(String.format("%"+len+"d " , value(i, j)));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int value(int x, int y) {
		int m = Math.max(Math.abs(x), Math.abs(y));
		int v = 4*m*m+1;
		if(x==m) return v+(x+y)+m*2;
		else if(x==-m) return v-(y-x);
		else if(y==m) return v-(x+y)-m*2;
		else return v+(x-y);
	}
}
