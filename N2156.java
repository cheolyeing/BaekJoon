import java.io.*;

public class N2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] grape = new int[n];
		for(int i=0; i<n; i++) {
			grape[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		
		int a = 0; int b = 0; int c = 0; int d = 0; int e = 0; int f = 0;
		
		if(n==1) {
			answer = grape[0];
		} else if (n==2) {
			answer = grape[0]+grape[1];
		} else if (n==3) {
			answer = Math.max(grape[0]+grape[1], Math.max(grape[1]+grape[2], grape[2]+grape[0]));
		} else if (n==4) {
			a = grape[0]+grape[3];
			b = grape[0]+grape[1]+grape[3];
			c = grape[0]+grape[2]+grape[3];
			d = grape[0]+grape[2];
			e = grape[1]+grape[2];
			f = grape[0]+grape[1];
			answer = Math.max(Math.max(a, b), Math.max(c, Math.max(d, e)));
		} else {
			a = grape[0]+grape[3];
			b = grape[0]+grape[1]+grape[3];
			c = grape[0]+grape[2]+grape[3];
			d = grape[0]+grape[2];
			e = grape[1]+grape[2];
			f = grape[0]+grape[1];
			for(int i=4; i<n; i++) {
				int tmp1 = grape[i]+f;
				int tmp2 = grape[i]+Math.max(d, e);
				int tmp3 = grape[i]+Math.max(a, b);
				f = e;
				e = c;
				d = b;
				a = tmp1;
				b = tmp2;
				c = tmp3;
			} answer = Math.max(Math.max(a, b), Math.max(c, e));
		} System.out.println(answer);
	}
}