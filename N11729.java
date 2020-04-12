import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11729 {
	
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Hanoi(n, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
	}
	
	static void Hanoi(int n, int a, int b, int c) {
		if(n==1) {
			sb.append(a+" "+c); sb.append("\n"); count++;
		}
		else if(n==2) {
			sb.append(a+" "+b); sb.append("\n");
			sb.append(a+" "+c); sb.append("\n");
			sb.append(b+" "+c); sb.append("\n"); count+=3;
		}
		
		else if(n==3) {
			sb.append(a+" "+c); sb.append("\n");
			sb.append(a+" "+b); sb.append("\n");
			sb.append(c+" "+b); sb.append("\n");
			sb.append(a+" "+c); sb.append("\n");
			sb.append(b+" "+a); sb.append("\n");
			sb.append(b+" "+c); sb.append("\n");
			sb.append(a+" "+c); sb.append("\n");
			count += 7;
		}
		else {
			Hanoi(n-1, a, c, b);
			sb.append(a+" "+c); sb.append("\n"); count++;
			Hanoi(n-1, b, a, c);
		}
	}
}