import java.io.*;
import java.util.*;

public class N1342 {
	static String s;
	static int ans=0, length;
	static int[] li;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		length = s.length();
		li = new int[length];
		visited = new boolean[length];
		
		for(int i=0; i<length; i++) {
			boolean overlap = false;
			
			checking :
			for(int j=0; j<i; j++) {
				if(s.charAt(i)==s.charAt(j)) {
					overlap = true;
					li[j]++; break checking;
				}
			}
			if(!overlap) li[i]++;
		}
		
		backTracking("");
		for(int i=0; i<length; i++) 
			if(li[i]>1) ans = ans / factorial(li[i]);
	}
	
	static int factorial(int n) {
		int res=1;
		for(int i=2; i<=n; i++) res *= i;
		return res;
	}
	
	static void backTracking(String res) {
		if(res.length()>1 && res.charAt(res.length()-1)==res.charAt(res.length()-2)) return;
		if(res.length()==length) {
			ans++; return;
		}
		for(int i=0; i<length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backTracking(res+s.charAt(i));
				visited[i] = false;
			}
		}
	}
}