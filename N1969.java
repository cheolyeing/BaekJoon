import java.io.*;

public class N1969 {
	
	static int n;
	static int m;
	static int[][] map;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[4][m];
		
		for(int i=0; i<n; i++) {
			char[] dna = br.readLine().toCharArray();
			for (int j=0; j<m; j++) {
				if(dna[j]=='A') {
					map[0][j]++;
				} else if(dna[j]=='C') {
					map[1][j]++;
				} else if(dna[j]=='G') {
					map[2][j]++;
				} else {
					map[3][j]++;
				}
			}
		}
		
		for(int i=0; i<m;i++) {
			boolean status = true;
			int max = Math.max( Math.max(map[0][i], map[1][i]), Math.max(map[2][i], map[3][i]) );
			for(int j=0; j<4; j++) {
				
				if(map[j][i] == max && status) {
					if(j==0) System.out.print("A");
					else if(j==1) System.out.print("C");
					else if(j==2) System.out.print("G");
					else System.out.print("T");
					status = false;
				} else {
					ans += map[j][i];
				}
			} 
		} System.out.println("\n"+ans);
	}
}