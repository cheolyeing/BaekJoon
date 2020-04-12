import java.io.*;
import java.util.*;

public class N5397 {
	static String s, c4;
	static char[] string, exp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine(); c4 = br.readLine();
		string = new char[s.length()];
		exp = new char[c4.length()];
	}
	
	static String solution () {
		
		for(int i=0; i<c4.length(); i++)
			exp[i] = c4.charAt(i);
		
		int idx = 0;
		int len = c4.length();
		
		for(int i=0; i<s.length(); i++) {
			string[idx++] = s.charAt(i);
			
			if(string[idx-1]==exp[len-1]) {
				if(idx<len) continue;
				boolean del = true;
				
				for(int j=1; j<len; j++) {
					if(string[idx-1-j]!=exp[len-1-j]) {
						del = false; break;
					}
				}
				if(del) idx -= len;
			}
		}
		if(idx==0) return "FRULA";
		else {
			String res = "";
			for(int i=0; i<idx; i++) res += string[i];
			return res;
		}
	}
}