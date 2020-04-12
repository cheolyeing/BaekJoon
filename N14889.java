import java.io.*;

public class N14889 {
	
	static int n;
	static int[][] ability;
	static int ans = 10000;
	static int[] teamA;
	static int[] teamB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		teamA = new int[n/2]; teamB = new int[n/2];
		
		for (int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				ability[i][j] = Integer.parseInt(input[j]);
			}
		}
		BackTracking(0, 1); System.out.println(ans);
	}
	
	static void Calculate() {
		int powerA = 0, powerB = 0;
		for ( int i : teamA ) {
			for ( int j : teamA ) {
				if(i!=j) { powerA += ability[i][j];}
			}
		} 
		
		for ( int i : teamB ) {
			for ( int j : teamB ) {
				if(i!=j) {powerB += ability[i][j]; }
			} 
		}
		ans = Math.min(ans, Math.abs(powerA-powerB));
	}
	
	static void BackTracking(int last, int P) {
		
		if(P == n/2) {
			int b = 0;
			for (int i=0; i<n; i++) {
				boolean B = true;
				for (int j : teamA) { if(i==j) { B = false; }}
				if(B) { teamB[b] = i; b++; }
			}
			Calculate(); return;
		}
		
		for (int i=last+1; i<n; i++) {
			teamA[P] = i;
			BackTracking(i, P+1);
		}
	}
}