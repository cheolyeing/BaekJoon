import java.io.*;
import java.util.*;

public class N1074 {
	static int n;
	static int r;
	static int c;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		solution();
		
	}
	
	static void solution () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); br.close();
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		while(true) {
			int compare = (int)Math.pow(2, n-1);
			if(n==0) break;
			if(r<compare && c<compare) {  }
			else if(r<compare && c>=compare) {answer += compare*compare; c -= compare; }
			else if(r>=compare && c<compare) {answer += 2*compare*compare; r -= compare; }
			else {answer += 3*compare*compare; r -= compare; c -= compare; }
			
			n--;
		}
		System.out.println(answer);
	}
}