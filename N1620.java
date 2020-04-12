import java.io.*;
import java.util.*;

public class N1620 {
	static int n, m;
	static String[] pocketmon;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pocketmon = new String[n+1];
		
		for(int i=1; i<=n; i++) {
			pocketmon[i] = br.readLine();
			map.put(pocketmon[i], i);
		}
		
		for(int i=0; i<m; i++) {
			solution(br.readLine());
		}
	}
	
	static void solution(String s) {
		if(65<=(int)s.charAt(0)) {
			System.out.println(map.get(s));
		} else {
			int num = Integer.parseInt(s);
			System.out.println(pocketmon[num]);
		}
	}
}