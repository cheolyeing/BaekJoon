import java.io.*;
import java.util.*;

public class N2023 {
	static boolean[] num;
	static int n, max;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		max = (int)Math.pow(10, n);
		dfs(2);
		dfs(3);
		dfs(5);
		dfs(7);
	}
	
	static boolean primeCheck(int s) {
		
		for (int i=2; i<=Math.sqrt(s); i++) {
			if(s%i==0) return false;
		}
		return true;
	}
	
	static void dfs(int s) {
		if(s>Math.pow(10, n-1)) {
			if(primeCheck(s)) {
				System.out.println(s);
				return;
			}
		}
		for (int i=1; i<10; i+=2) {
			if(primeCheck(10*s+i)) dfs(10*s+i);
		}
	}
}