import java.io.*;
import java.util.*;

public class N1026 {
	
	static int n;
	static ArrayList<Integer> A = new ArrayList<Integer>();
	static ArrayList<Integer> B = new ArrayList<Integer>();
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(answer);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(i==0) A.add(n);
				if(i==1) B.add(n);
			}
		}
		Collections.sort(A);
		Collections.sort(B);
		for (int i=0; i<n; i++) {
			answer += A.get(i)*B.get(n-1-i);
		}
	}
}
