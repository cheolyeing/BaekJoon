import java.io.*;
import java.util.*;

public class N2935 {
	static int n1, n2;
	static char op;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n1 = br.readLine().length();
		op = br.readLine().charAt(0);
		n2 = br.readLine().length();
	}
	
	static void solution() {
		if(op=='*') {
			System.out.print(1);
			for(int i=0; i<n1+n2-2; i++) System.out.print(0);
		} else {
			if(n1==n2) {
				System.out.print(2);
				for(int i=0; i<n1-1; i++) System.out.print(0);
			} else {
				if(n1<n2) {
					int tmp = n1;
					n1 = n2;
					n2 = tmp;
				}
				System.out.print(1);
				for(int i=0; i<n1-n2-1; i++) System.out.print(0);
				System.out.print(1);
				for(int i=0; i<n2-1; i++) System.out.print(0);
			}
		}
	}
}
