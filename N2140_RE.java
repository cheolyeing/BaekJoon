import java.io.*;

public class N2140_RE {
	static int n;
	static char[][] map;
	static int[] d = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n+2][n+2];
		for(int i=1; i<=n; i++) {
			String s = br.readLine();
			for(int j=1; j<=n; j++) {
				map[i][j] = s.charAt(j-1);
			}
		}
	}
	
	static void solution() {
		map[2][2] = map[1][1]=='1' ? '*' : 's';
		map[2][n-1] = map[1][n]=='1' ? '*' : 's';
		map[n-1][2] = map[n][1]=='1' ? '*' : 's';
		map[n-1][n-1] = map[n][n]=='1' ? '*' : 's';
		
		for(int i=2; i<n-1; i++) {
			findMine(2, i, 1);
			findMine(n-1, i, n);
		}
		System.out.println(countMine());
	}
	
	static void findMine(int x, int y, int ox) {
		int mine=0;
		if(map[x][y-1]=='*') mine++;
		if(map[x][y]=='*') mine++;
		map[x][y+1] = map[ox][y]-'0'==mine ? 's' : '*';
		
		mine=0;
		if(map[y-1][x]=='*') mine++;
		if(map[y][x]=='*') mine++;
		map[y+1][x] = map[y][ox]-'0'==mine ? 's' : '*';
	}
	
	static int countMine() {
		int cnt=0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]=='*' || map[i][j]=='#') cnt++;
			}
		}
		return cnt;
	}
	
	static void showMap() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(map[i][j]+" ");
			} System.out.println();
		} System.out.println("---------------");
	}
}
