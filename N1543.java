import java.io.*;

public class N1543 {
	static String finder;
	static String txt;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		txt = br.readLine();
		finder = br.readLine();
	}
	
	static int solution() {
		int fL = finder.length();
		int tL = txt.length();
		int ans = 0;
		int idx = 0;
		
		while(idx+fL<=tL) {
			if(txt.substring(idx, idx+fL).equals(finder)) {
				idx += fL; ans++;
			} else idx++;
		}
		return ans;
	}
}
