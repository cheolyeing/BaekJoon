import java.io.*;
import java.util.*;
public class N3046 {
	static int r1, r2, s;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		System.out.println(2*s-r1);
	}
}