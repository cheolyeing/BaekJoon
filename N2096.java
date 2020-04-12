import java.io.*;
import java.util.*;

public class N2096 {
	static int n;
	public static void main(String[] args) throws IOException {
		setting();
		//solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] min = new int[n][3];
		int[][] max = new int[n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				min[i][j] = Integer.parseInt(st.nextToken());
				max[i][j] = min[i][j];
			}
		}
		
		for(int i=1; i<n; i++) {
			min[i][0] += Math.min(min[i-1][0], min[i-1][1]);
			min[i][1] += Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
			min[i][2] += Math.min(min[i-1][1], min[i-1][2]);
			
			max[i][0] += Math.max(max[i-1][0], max[i-1][1]);
			max[i][1] += Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
			max[i][2] += Math.max(max[i-1][1], max[i-1][2]);
		}
		
		System.out.println(Math.max(max[n-1][0], Math.max(max[n-1][1], max[n-1][2]))+" "+Math.min(min[n-1][0], Math.min(min[n-1][1], min[n-1][2])));
	}
	
	static void solution() {
		
	}
}