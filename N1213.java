import java.io.*;

public class N1213 {
	
	static int[] palindrome = new int[26];
	static int check = 0;
	static String answer = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		for (int i=0; i<s.length; i++) {
			palindrome[s[i]-'A']++;
		}
		for (int i=0; i<26; i++) {
			if(palindrome[i]%2==1) {
				check++;
				if(s.length%2==0) { System.out.println("I'm Sorry Hansoo"); System.exit(0); }
				else { if(check==2) {System.out.println("I'm Sorry Hansoo"); System.exit(0);} }
			}
		}
		int lastIdx = 0;
		for (int i=0; i<26; i++) {
			if(palindrome[i]!=0) {
				if(palindrome[i]%2==0) {
					while(palindrome[i]!=0) {
						answer = answer + (char)((int)'A'+i); palindrome[i] -= 2;
					}
				} else {
					while(palindrome[i]!=1) {
						answer = answer + (char)((int)'A'+i); palindrome[i] -= 2;
					} lastIdx = i;
				}
			}
		} 
		if(s.length%2==1) {
			answer = answer + (char)((int)'A'+lastIdx) + new StringBuffer(answer).reverse().toString();
		} else {
			answer = answer + new StringBuffer(answer).reverse().toString();
		}
		
		System.out.println(answer);
		}
	}

