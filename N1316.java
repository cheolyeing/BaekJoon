import java.io.*;

public class N1316 {
	
	static int ans = 0;
	static boolean[] checker = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			String input = br.readLine();
			checker = new boolean[26];
			GroupChecker(input);
		} System.out.println(ans);
	}
	
	static void GroupChecker(String input) {
		for (int i=0; i<input.length()-1; i++) {
			int tmp = (int)input.charAt(i)-97;
			if(input.charAt(i) == input.charAt(i+1)) {
				continue;
			}
			else {
				if(!checker[tmp]) {checker[tmp] = true;}
				else {return;}
			}
		}
		
		int tmp = (int)input.charAt(input.length()-1)-97;
		if(!checker[tmp]) {ans++;}
		return;
	}
}