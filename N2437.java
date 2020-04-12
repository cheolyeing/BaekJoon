import java.io.*;
import java.util.*;

public class N2437 {
	
	static int n;
	static int[] weight;
	static long sum = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		weight = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weight);
	}
	
	static void solution() {
		if(weight[0]>1) {System.out.println(1); System.exit(0); }
		for(int i=0; i<n; i++) {
			sum += weight[i];
			if(i+1==n) { System.out.println(sum+1); System.exit(0); }
			if(sum+1<weight[i+1]) { System.out.println(sum+1); System.exit(0);}
		}
	}
}