import java.io.*;

public class N1371 {
	
	static int[] alpha = new int[26];
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null) {
			for (int i=0; i<s.length(); i++) {
				if(s.charAt(i)!=' ') {
					alpha[(int)(s.charAt(i)-'a')]++;
				}
			}
		}
		int max = 0;
		for(int i=0; i<26; i++) {
			if(max<alpha[i]) { max = alpha[i]; }
		}
		
		for(int i=0; i<26; i++) {
			if(max==alpha[i]) {
				System.out.print((char)((int)'a'+i));
			}
		}
	}
}