import java.io.*;
import java.math.*;

public class N10827 {
	
	static BigInteger answer = new BigInteger("1");
	static BigInteger a;
	static int n;
	static int dot = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		if(s[0].contains(".")) {
			String[] tmp = s[0].split("\\.");
			dot = tmp[1].length();
			a = new BigInteger(tmp[0]+tmp[1]);
		} else {
			a = new BigInteger(s[0]);
		}
		int m = Integer.parseInt(s[1]);
		
		for (int i=0; i<m; i++) {
			answer = answer.multiply(a);
		}
		
		if(dot==0) {
			System.out.println(answer);
		} else {
			dot = dot*m;
			String ans = answer.toString();
			if(ans.length()>dot) {
				ans = ans.substring(0,ans.length()-dot)+"."+ans.substring(ans.length()-dot,ans.length());
			} else {
				int length = ans.length();
				for(int i=0; i<dot-length; i++) {
					ans = "0"+ans;
				} ans = "0."+ans;
			}
			
			System.out.println(ans);
		}
	}
}
