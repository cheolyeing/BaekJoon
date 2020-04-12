import java.io.*;
import java.util.*;

public class N2455 {
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int passenger = 0;
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			passenger += in - out;
			ans = Math.max(ans, passenger);
		}
		System.out.println(ans);
	}
}