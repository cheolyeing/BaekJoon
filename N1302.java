import java.io.*;
import java.util.*;

public class N1302 {
	static int n, max=0;
	static String[] book;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		book = new String[n];
		for(int i=0; i<n; i++) book[i] = br.readLine();
	}
	
	static void solution() {
		Arrays.sort(book);
		int cnt = 1;
		for(int i=0; i<n-1; i++) {
			if(book[i].equals(book[i+1])) {
				cnt++;
				if(cnt>max) {
					max = cnt;
					ans = book[i];
				}
			} else {
				cnt = 1;
			}
		}
		
		System.out.println(max==0 ? book[0] : ans);
	}
}
