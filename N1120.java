import java.io.*;

public class N1120 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String a = input[0], b = input[1];
		int ans = 50;
		
		for(int i=0; i<=b.length()-a.length(); i++) {
			int dif = 0;
			for(int j=0; j<a.length(); j++) {
				if(! (a.charAt(j)==b.charAt(j+i))) {
					dif++;
				}
			} if(ans>dif) { ans = dif; }
		} System.out.println(ans);
	}
}