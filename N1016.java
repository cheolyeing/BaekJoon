import java.io.*;
import java.util.*;

public class N1016 {
	static long min, max;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
	}
	
	static void solution() {
		int end = (int)Math.sqrt(max);
		boolean[] check = new boolean[1000001];
		for(long i=2; i<=end; i++) {
			long square = i*i;
			long start = ((min-1)/square+1) * square;
			for(long a=start; a<=max; a+=square) {
				check[(int)(a-min)] = true;
			}
		}
		int cnt = 0;
		for(int i=0; i<=(max-min); i++) {
			if(check[i]) cnt++;
		}
		System.out.println(max-min-cnt+1);
	}
}
