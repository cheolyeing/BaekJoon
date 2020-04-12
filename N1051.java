import java.io.*;

public class N1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s.split(" ")[0]);
		int m = Integer.parseInt(s.split(" ")[1]);
		char[][] map = new char[n][m];
		int large = 0;
		
		for (int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i=1; i<=Math.min(n,  m); i++) {
			for (int a=0; a<n-i; a++) {
				for (int b=0; b<m-i; b++) {
					if(map[a][b]==map[a][b+i] && map[a][b+i]==map[a+i][b] && map[a+i][b]==map[a+i][b+i]) {
						large = i;
					}
				}
			}
		} System.out.println((large+1)*(large+1));
	}
}