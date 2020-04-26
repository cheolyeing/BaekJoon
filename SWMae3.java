import java.io.*;
import java.util.*;

public class SWMae3 {
	static int n, skill[][];
	static Comparator<int[]> comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] a1, int[] a2) {
			return a1[0]-a2[0];
		}
		
	};
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		skill = new int[n][2];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			skill[i][0] = Integer.parseInt(st.nextToken());
			skill[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			System.out.println(find(i));
		}
	}
	
	static int find(int idx) {
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(skill[i][0]<skill[idx][0] && skill[i][1]>skill[idx][0]) ans++;
		}
		return ans;
	}
}
