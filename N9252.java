import java.io.*;

public class N9252 {
	
	static String a;
	static String b;
	static int[][] LCS;
	static int aLength;
	static int bLength;
	
	public static void main (String[] args) throws IOException {
		setting(); lcs(a,b); System.out.println(LCS[aLength][bLength]);System.out.println(showLCS());
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		aLength = a.length();
		bLength = b.length();
		LCS = new int[aLength+1][bLength+1];
	}
	
	static void lcs(String x, String y) {
		for (int i=0; i<aLength; i++) {
			for (int j=0; j<bLength; j++) {
				LCS[i+1][j+1] = Math.max(LCS[i+1][j], LCS[i][j+1]);
				if(x.charAt(i)==y.charAt(j)) {
					LCS[i+1][j+1] = LCS[i][j]+1;
				}
			}
		}
	}
	
	static String showLCS() {
		String result = "";
		
		int i = aLength;
		int j = bLength;
		while(true) {
			if(LCS[i][j]==0) { break; }
			if(a.charAt(i-1)==b.charAt(j-1)) {
				result = a.charAt(i-1)+result;
				i--; j--;
			}
			else {
				if(LCS[i-1][j]>LCS[i][j-1]) {
					i--;
				} else {j--;}
			}
		}
		return result;
	}
}