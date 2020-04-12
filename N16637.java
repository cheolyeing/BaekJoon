import java.util.*;
import java.io.*;
public class N16637 {
	static int n, size, answer=-Integer.MAX_VALUE;
	static ArrayList<Integer> number = new ArrayList<Integer>();
	static ArrayList<Character> operator = new ArrayList<Character>();
	
	static int idx=0, op=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		backTracking(false, 0, s);
		System.out.println(answer);
	}
	
	static void backTracking(boolean open, int idx, String s) {
		//if(!open) System.out.println(s + " = " + calculator(finalCalculator(s)));
		
		if(!open) {
			answer = Math.max(answer, calculator(finalCalculator(s)));
			for (int i=idx; i<s.length()-1; i++) {
				if(i==0 || s.charAt(i-1)=='+' || s.charAt(i-1)=='-' || s.charAt(i-1)=='*' || s.charAt(i-1)=='/')
					backTracking(true, i+3, s.substring(0,i)+"("+s.substring(i,s.length())); 
			}
		} else {
			int op = 0;
			for (int i=idx; i<=s.length(); i++) {
				if(i==s.length() || s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/') {
					op++;
					if(op<2) backTracking(false, i+1, s.substring(0,i)+")"+s.substring(i,s.length()));
				}
			}
		}
	}
	
	static String finalCalculator(String s) {
		boolean exist = false;
		int start = 0;
		int finish = 0;
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				exist = true;
				start = i;
			}
			if(true && s.charAt(i)==')') {
				finish = i; break;
			}
		}
		if(!exist) return s;
		else {
			if(start==0 && finish==s.length()-1) {
				return finalCalculator(finalCalculator(s.substring(start+1, finish)));
			} else if(start==0) {
				return finalCalculator(calculator(s.substring(start+1, finish))+finalCalculator(s.substring(finish+1,s.length())));
			} else if(finish==s.length()-1) {
				return finalCalculator(finalCalculator(s.substring(0, start)) + calculator(s.substring(start+1, finish)));
			} else {
				return finalCalculator(finalCalculator(s.substring(0, start)) + calculator(s.substring(start+1, finish)) + finalCalculator(s.substring(finish+1, s.length()))); 
			}
		}
	}
	
	static int calculator(String s) {
		
		for (int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)=='+') {
				return calculator(s.substring(0,i))+calculator(s.substring(i+1,s.length()));
			} else if(s.charAt(i)=='-') {
				if(i==0 || s.charAt(i-1)=='+' || s.charAt(i-1)=='-' || s.charAt(i-1)=='*' || s.charAt(i-1)=='/') {
					continue;
				}
				return calculator(s.substring(0,i))-calculator(s.substring(i+1,s.length()));
			} else if(s.charAt(i)=='*') {
				return calculator(s.substring(0,i))*calculator(s.substring(i+1,s.length()));
			} else if(s.charAt(i)=='/') {
				return calculator(s.substring(0,i))/calculator(s.substring(i+1,s.length()));
			} 
		}
		return Integer.parseInt(s);
	}
}