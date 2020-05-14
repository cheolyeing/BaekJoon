import java.io.*;
import java.util.*;

public class N1188 {
	static int n, m, ans=0, sub=0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		System.out.println(m-gcd(n, m));
	}
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
}
