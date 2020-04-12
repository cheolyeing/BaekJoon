import java.io.*;
import java.util.*;

public class N14501 {
	
	static int n;
	static int[][] work;
	static int answer = 0;
	
	public static void main (String[] args) throws IOException {
		setting(); addAll();
		System.out.println(findMax());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		work = new int[n][2];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void add (int k) {
		int tmp = work[k][1];
		for (int i=1; i<=10; i++) {
			if(k-i<0) { break; }
			if(i>=work[k-i][0]) {
				tmp = Math.max(tmp, work[k][1]+work[k-i][1]);
			}
		} work[k][1] = tmp;
	}
	
	static void addAll () {
		for (int i=0; i<n; i++) {
			add(i);
		}
	}
	
	static int findMax () {
		int max = 0;
		for (int i=1; i<=10; i++) {
			if(n-i<0) { break; }
			if(work[n-i][0]<=i) { max = Math.max(max, work[n-i][1]);}
		}
		return max;
	}
}