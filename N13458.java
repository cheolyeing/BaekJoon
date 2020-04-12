import java.io.*;

public class N13458 {
	
	static int n;
	static int[] a;
	static int b;
	static int c;
	static long answer = 0;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(answer);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		b = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		
		for (int i=0; i<n; i++) {
			int tmp = a[i] - b;
			answer++;
			
			if(tmp<=0) continue;
			else {
				if(tmp%c==0) answer+=tmp/c;
				else answer+=tmp/c+1;
			}
		}
	}
}