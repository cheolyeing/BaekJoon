import java.io.*;

public class N1159 {
	static int[] fName = new int[26];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			fName[s.charAt(0)-'a']++;
		}
	}
	
	static void solution() {
		boolean surrender = true;
		for(int i=0; i<26; i++) {
			if(fName[i]>4) {
				surrender = false;
				System.out.print((char)(i+'a'));
			}
		}
		if(surrender) System.out.println("PREDAJA");
	}
}
