import java.io.*;

public class N3460 {
	
	static int t;
	static int n;
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			int a = 0;
			while(!(n<2)) {
				if(n%2==1) System.out.print(a+" ");
				n = n/2; a++;
			}
			if(n==1) System.out.println(a);
		}
	}
}