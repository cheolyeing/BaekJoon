import java.io.*;
import java.util.*;

public class N1019 {
	
	static int n;
	static int[] ans = new int[10];
	
	public static void main(String[] args) throws IOException {
		setting();
		for(int i=0; i<10; i++) System.out.print(ans[i]+" ");
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count();
	}
	
	static void count() {
		int point = 1;
		int start = 1;
		
		while(start<=n) {
			while(n%10!=9 && start<=n) {
				cal(n, ans, point);
				n--;
			}
			
			if(n<start) break;
			
			while(start%10!=0 && start<=n) {
				cal(start, ans, point);
				start++;
			}
			
			start /= 10;
			n /= 10;
			
			for(int i=0; i<10; i++) {
				ans[i] += (n-start+1)*point;
			}
			
			point *= 10;
		}
	}
	
	static void cal(int x, int[] ans, int point) {
		while(x>0) {
			ans[x%10] += point;
			x /= 10;
		}
	}
}