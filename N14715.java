import java.io.*;
import java.util.*;

public class N14715 {
	static int n;
	static boolean[] check = new boolean[1000001];
	static int[] prime = new int[1000001];
	static int num = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		prime();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}
	
	static void solution () {
		int tmp = factor();
		int idx = 1;
		
		if(tmp==0||tmp==1) System.out.println(0);
		else {
			while(true) {
				if(tmp<=Math.pow(2, idx)) {
					System.out.println(idx); break;
				} idx++;
			}
		}
	}
	
	static int factor() {
		int res  = 0;
		
		Loop :
		while(true) {
			
			for (int i=0; i<n; i++) {
				
				if(n==1) break Loop;
				
				while(n%prime[i]==0) {
					n = n/prime[i]; res++;
				}	
			}
		}
		return res;
	}
	
	static void prime() {
		for (int i=2; i<=n; i++) {
			if(!check[i]) {
				int tmp = 2*i;
				while(tmp<n) {
					check[tmp] = true;
					tmp += i;
				}
			}
		}
		
		int idx = 0;
		
		for (int i=2; i<=n; i++) {
			if(!check[i]) {
				prime[idx++] = i;
			}
		}
		num = idx;
	}
}