import java.io.*;
import java.util.*;

public class N1756 {
	static int d, n, oven[], pizza[];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		oven = new int[d];
		pizza = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<d; i++) oven[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) pizza[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		for(int i=0; i<d-1; i++) {
			if(oven[i+1]>oven[i]) {
				oven[i+1] = oven[i];
			}
		}
		int idx = d;
		int p = 0;
		
		while(true) {
			idx--;
			if(idx<0) {
				System.out.println(0);
				System.exit(0);
			}
			if(pizza[p]<=oven[idx]) {
				p++; //System.out.println(idx);
			}
			if(p==n) {
				System.out.println(idx+1);
				System.exit(0);
			}
		}
	}
}
