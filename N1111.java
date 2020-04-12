import java.io.*;
import java.util.*;

public class N1111 {
	static int n, num[], r[];
	static int a=1, b=0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n==1 || n==2) {
			System.out.println("A"); System.exit(0);
		}
		num = new int[n]; r = new int[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for (int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for (int i=0; i<n-1; i++) {
			r[i] = num[i+1] - num[i];
			if(i==1) {
				a=r[i]/r[i-1];
				b = num[i] - num[i-1] * a;
			}
			if(i>1) {
				if(a!=r[i]/r[i-1]) {
					System.out.println("B"); System.exit(0);
				}
				if(b!=num[i]-num[i-1]*a) {
					System.out.println("B"); System.exit(0);
				}
			}
		}
		System.out.println(num[n-1]*a+b);
	}
}