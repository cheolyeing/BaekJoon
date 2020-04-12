import java.io.*;
import java.util.*;

public class N1759 {
	
	static int L;
	static int C;
	static char[] c;
	
	public static void main(String[] args) throws IOException {
		setting();
		String s = "";
		backTracking(s, 0);
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		c = new char[C];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++) {
			c[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(c);
	}
	
	static void backTracking(String a, int idx) {
		if(a.length()==L && check(a)) { System.out.println(a); return; }
		
		for(int i=idx; i<C; i++) {
			backTracking(a+c[i], i+1);
		}
		
		return;
	}
	
	static boolean check (String s) {
		int ja = 0;
		int mo = 0;
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') {
				mo++;
			} else {
				ja++;
			}
		}
		if(ja>=2 && mo>=1) return true;
		else return false;
	}
}