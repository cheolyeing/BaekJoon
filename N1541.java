import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1541 {
	public static void main(String[] args) throws IOException {
		N1541 main = new N1541();
		main.solve();
	}
	void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int s = 0;
		int r = 0;
		boolean f = true;
		for(int i = 0; i <= str.length(); i++) {
			if(i == str.length() || str.charAt(i) == '+' || str.charAt(i) == '-') {
				if(f)
					r += Integer.parseInt(str.substring(s, i));
				else
					r -= Integer.parseInt(str.substring(s, i));
				s = i+1;
				if(i != str.length() && str.charAt(i) == '-') f= false;
			}
		}
		System.out.println(r);
	}
}