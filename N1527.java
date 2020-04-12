import java.io.*;
import java.util.*;
public class N1527 {
	static int a, b;
	static int sizeA, sizeB;
	static int ans=0;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		dfs(0, 0);
		System.out.println(ans);
	}
	
	static void dfs(int num, int len) {
		if(len>=10) return;
		if(num>b) return;
		if(num>=a) ans++;
		dfs(num*10+4, len+1);
		dfs(num*10+7, len+1);
	}
}