import java.io.*;
import java.util.*;

public class N15954 {
	static int n, k;
	static int[] doll;
	static double avg=0, ans=Double.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
		System.out.println(Math.sqrt(ans));
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		doll = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			doll[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for(int i=0; i<n; i++) {
			for(int j=k; j<=n-i; j++) {
				double sum=0;
				for(int a=i; a<i+j; a++) {
					sum += doll[a];
				}
				avg = sum / j;
				
				double V = 0;
				for(int a=i; a<i+j; a++) {
					V += (doll[a]-avg)*(doll[a]-avg);
				}
				ans = Math.min(ans, (double)V/j);
			}
		}
	}
}