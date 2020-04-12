import java.io.*;

public class N17822 {
	static int n, m, t;
	static int[][] circle;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		t = Integer.parseInt(s[2]);
		circle = new int[n][m];
		
		for (int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				circle[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);
	
			spin(x, d, k, i);
		}
		
		int answer = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				answer += circle[i][j];
			}
		} System.out.println(answer);
	}
	
	static void spin(int x, int d, int k, int time) {
		if(x==1) {delete(); return;}
		
		if(d==0) k *= -1;
		int[] tmp = new int[m];
		
		for(int i=0; i<n; i++) {
			if((i+1)%x!=0) continue;
			for(int j=0; j<m; j++) {
				tmp[j] = circle[i][(j+k+m)%m];
			}
			for(int j=0; j<m; j++) {
				circle[i][j] = tmp[j];
			}
		}
		if(time==0) delete();
		else delete();
	}
	
	static void delete() {
		
		boolean remove = false;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(Math.abs(circle[i][j])==Math.abs(circle[i][(j+1)%m]) ) {
					circle[i][j] = (-1) * Math.abs(circle[i][j]);
					circle[i][(j+1)%m] = (-1) * Math.abs(circle[i][j]);
				}
			}
		}
		
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<m; j++) {
				if(circle[i][j]==0) continue;
				if(Math.abs(circle[i][j])==Math.abs(circle[i+1][j])) {
					circle[i][j] = (-1) * Math.abs(circle[i][j]);
					circle[i+1][j] = (-1) * Math.abs(circle[i][j]);
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(circle[i][j]<0) {circle[i][j] = 0; remove = true;}
			}
		}
		
		if(!remove) {
			int sum = 0;
			int num = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if(circle[i][j]==0) continue;
					sum += circle[i][j]; num++;
				}
			}
			float average = sum/(float)num;
			//System.out.println(average);
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if(circle[i][j]==0) continue;
					else if(circle[i][j]<average) circle[i][j]++;
					else if(circle[i][j]>average) circle[i][j]--;
				}
			}
		}
	}
	
	static void show() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.print(circle[i][j]+" ");
			} System.out.println();
		}System.out.println("\n-------------");
	}
}