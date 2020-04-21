import java.io.*;
import java.util.*;

public class N1145 {
	static int ans = Integer.MAX_VALUE;
	static int[] num = new int[5];
	public static void main(String[] args) throws IOException {
		setting();
		backTracking(new int[3], -1, 0);
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<5; i++) num[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution(int[] arr) {
		ans = Math.min(ans, lcm(num[arr[0]], num[arr[1]], num[arr[2]]));
	}
	
	static void backTracking(int[] arr, int num, int cnt) {
		if(cnt==3) {
			solution(arr);
			return;
		}
		for(int i=num+1; i<5; i++) {
			arr[cnt] = i;
			backTracking(arr, i, cnt+1);
		}
	}
	
	static int lcm(int a, int b, int c) {
		return lcm(lcm(a, b), c);
	}
	
	static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
	static int gcd(int a, int b) {
		if(a==b) return a;
		else {
			if(a>b) {
				if(a%b==0) return b;
				return gcd(a%b, b);
			}
			else {
				if(b%a==0) return a;
				return gcd(a, b%a);
			}
		}
	}
}
