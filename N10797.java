import java.io.*;
import java.util.*;

public class N10797 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		for (int i=0; i<5; i++) {
			if(n==Integer.parseInt(st.nextToken())) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}