import java.io.*;
import java.util.*;

public class N11052 {
	static int n;
	static int[] cards;
	static int sum = 0;
	static int[] value;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cards = new int[n+1]; value = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) { cards[i] = Integer.parseInt(st.nextToken()); }
		
		
		System.out.println(cardPrice(n));
	}
	
	static int cardPrice(int n) {
		if(n==0) { return 0; }
		if(n==1) { return cards[1]; }
		else {
			int max = cards[n];
			for (int i=1; i<=n/2; i++) {
				if(value[n-i]==0) { value[n-i] = cardPrice(n-i); }
				if(value[i]==0) { value[i] = cardPrice(i); }
				else { if(max < value[n-i]+value[i]) { max = value[n-i]+value[i]; } }
			} return max;
		}
	}
}