import java.io.*;
import java.util.*;

public class N1049 {
	static int n;
	static int m;
	static int[][] price;
	static int answer = Integer.MAX_VALUE;
	static int pack = Integer.MAX_VALUE;
	static int one = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		price = new int[m][2];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			if(p<pack) { pack = p; }
			if(o<one) { one = o; }
		} 
		if(answer>n*one) { answer = n*one; }
		if(n/6 > 0) {
			if(n%6==0) {
				if(answer>pack*(n/6)) { answer = pack*(n/6); } 
			} else {
				if(answer>pack*(n/6) + one*(n%6)) { answer = pack*(n/6) + one*(n%6); }
				if(answer>pack*(n/6+1)) { answer = pack*(n/6+1); }
			}
		} else { if(answer>pack) {answer=pack;}}
		System.out.println(answer);
	}
}