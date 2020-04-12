import java.io.*;
import java.util.*;

public class N9935 {
	static String s, exp;
	static char[] ans, bomb;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		setting();
		solution(new Stack<Character>(), s);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		exp = br.readLine();
		ans = new char[s.length()];
		bomb = new char[exp.length()];
	}
	
	static void solution(Stack<Character> stack, String s) {
		for(int i=0; i<exp.length(); i++)
			bomb[i] = exp.charAt(i);
		int len = exp.length();
		
		int idx = 0;
		
		for(int i=0; i<s.length(); i++) {
			ans[idx++] = s.charAt(i);
			if(ans[idx-1]==bomb[len-1]) {
				if(idx-len<0) continue;
				boolean c = false;
				for(int j=0; j<len; j++) {
					
				}
			}
		}
		
	}
}