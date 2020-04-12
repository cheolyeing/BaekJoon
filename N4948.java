import java.io.*;
import java.util.*;

public class N4948 {
	
	static int n = 123456*2;
	static boolean[] prime = new boolean[n+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		primeSetting();
		while((num=sc.nextInt())!=0) {
			System.out.println(numOfPrime(num));
		}
	}
	
	static void primeSetting() {
		prime[1] = true;
		for (int i=2; i<=n; i++) {
			if(!prime[i]) {
				for (int j=2*i; j<=n; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
	
	static int numOfPrime(int num) {
		int ans = 0;
		
		for(int i=num+1; i<=num*2; i++) {
			if(!prime[i]) ans++;
		}
		return ans;
	}
}