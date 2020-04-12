import java.io.*;

public class N2661 {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		backTracking("", 0);
	}
	
	static void backTracking(String s, int len) {
		if(overlap(s, len)) return;
		if(len==n) {
			System.out.println(s); System.exit(0);
		}
		
		backTracking(s+"1", len+1);
		backTracking(s+"2", len+1);
		backTracking(s+"3", len+1);
	}
	
	static boolean overlap(String s, int len) {
		for(int i=1; i<=len/2; i++) {
			int a1 = len-i;
			int a2 = len-2*i;
			if(s.substring(a2, a1).equals(s.substring(a1, len))) return true;
		}
		return false;
	}
}