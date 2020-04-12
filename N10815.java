import java.io.*;
import java.util.*;

public class N10815 {
	static int n, m, ans = 0;
	static int[] card, check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) card[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		check = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) check[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		Arrays.sort(card);

		for(int i=0; i<m; i++) {
			if(cardHas(check[i])) sb.append("1 ");
			else sb.append("0 ");
		}
		System.out.println(sb);
	}
	
	static boolean cardHas(int num) {
		return Arrays.binarySearch(card, num)>=0;
	}
}