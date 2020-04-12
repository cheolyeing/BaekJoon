import java.io.*;
import java.util.*;

public class N11399 {
	
	static int n;
	static int[] atm;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		atm = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		} Arrays.sort(atm);
		
		for (int i=0; i<n; i++) {
			answer += atm[i]*(n-i);
		}
		System.out.println(answer);
	}
}