import java.io.*;
import java.util.*;

public class N1461 {
	static int n, m, book[], ans=0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		book = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) book[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		Arrays.sort(book);
		int bookM = Math.abs(Arrays.binarySearch(book, 0) + 1);
		int bookP = n - bookM;
		int max = 0;
		
		int idx = 0;
		while(bookM>0) {
			int tmp = Math.abs(book[idx]);
			ans += 2*tmp;
			if(max<tmp) max = tmp;
			bookM -= m; idx += m;
		}
		
		idx = n-1;
		while(bookP>0) {
			int tmp = Math.abs(book[idx]);
			ans += 2*tmp;
			if(max<tmp) max = tmp;
			bookP -= m; idx -= m;
		}
		System.out.println(ans-max);
	}
}
