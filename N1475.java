import java.io.*;

public class N1475 {
	
	static int[] num = new int[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0; i<s.length(); i++) {
			int n = s.charAt(i)-'0';
			if(n==9) { num[6]++; }
			else { num[n]++; }
		}
		num[6] = (num[6]+1)/2;
		int max = 0;
		for (int i=0; i<9; i++) {
			if(max<num[i]) { max = num[i]; }
		}
		System.out.println(max);
	}
}