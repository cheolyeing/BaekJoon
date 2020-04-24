import java.io.*;

public class N1439 {
	static String s;
	static int zero = 0, one = 0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
	}
	
	static void solution() {
		if(s.charAt(0)=='0') zero++;
		else one++;
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i)!=s.charAt(i-1)) {
				if(s.charAt(i)=='0') zero++;
				else one++;
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
