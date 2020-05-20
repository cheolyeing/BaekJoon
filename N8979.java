import java.io.*;
import java.util.*;

public class N8979 {
	static int n, k, t, score[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		score = new int[n][4];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
				if(score[i][0]==k) t = i;
			}
		}
	}
	
	static void solution() {
		int rank = 1;
		for(int i=0; i<n; i++) {
			if(score[i][1]>score[t][1]) rank++;
			if(score[i][1]==score[t][1]) {
				if(score[i][2]>score[t][2]) rank++;
				if(score[i][2]==score[t][2])
					if(score[i][3]>score[t][3]) rank++;
			}
		}
		System.out.println(rank);
	}
}
