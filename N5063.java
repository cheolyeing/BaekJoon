import java.io.*;
import java.util.*;

public class N5063 {
	static String[] ans = {"advertise", "does not matter", "do not advertise"};
	static int r, e, c;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(e==r+c) System.out.println(ans[1]);
			else if(e>r+c) System.out.println(ans[0]);
			else System.out.println(ans[2]);
		}
	}
}
