import java.io.*;
import java.util.*;

public class N1431 {
	static int n;
	static ArrayList<String> serial = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) serial.add(br.readLine());
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1; j++) {
				compareTo(j);
			}
		}
		
		for(int i=0; i<n; i++) System.out.println(serial.get(i));
	}
	
	static void compareTo(int idx) {
		int a1 = idx;
		int a2 = idx + 1;
		String s1 = serial.get(a1);
		String s2 = serial.get(a2);
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1>len2) {
			change(idx); return;
		} else if(len1<len2) return;
		else {
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<len1; i++) {
				if(s1.charAt(i)-'0'<10) sum1 += s1.charAt(i)-'0';
				if(s2.charAt(i)-'0'<10) sum2 += s2.charAt(i)-'0';
			}
			if(sum1>sum2) {
				change(idx); return;
			} else if(sum1<sum2) return;
			else {
				for(int i=0; i<len1; i++) {
					if(s1.charAt(i)!=s2.charAt(i)) {
						if(s1.charAt(i)>s2.charAt(i)) {
							change(idx);
						}
						return;
					}
				}
			}
		}
	}
	
	static void change(int idx) {
		String tmp = serial.get(idx);
		serial.remove(idx);
		serial.add(idx+1, tmp);
	}
}