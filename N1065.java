import java.io.*;
import java.util.*;

public class N1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(hansu(n));
		
	}
	
	static int hansu(int n) {
		int ans = 0;
		
		int length = Integer.toString(n).length();
		
		if(length>=3) {
			ans += 99;
			for(int i=100; i<=n; i++) {
				if(i==1000) { continue; }
				else {
					if( (i/100)-(i/10)%10 == (i/10)%10 - i%10 ) {
						ans++;
					}
				}
			}
		} else {
			ans = n;
		}
		return ans;
	}
}