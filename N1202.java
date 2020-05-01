import java.io.*;
import java.util.*;

public class N1202 {
	static int n, k;
	static long ans=0;
	static int[] bag;
	static int[][] jewelry;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	static Comparator<int[]> comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] a1, int[] a2) {
			return a1[0]-a2[0];
		}
	};
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		jewelry = new int[n][2];
		bag = new int[k];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			jewelry[i][0] = Integer.parseInt(st.nextToken());
			jewelry[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<k; i++) bag[i] = Integer.parseInt(br.readLine());
		Arrays.sort(bag);
		Arrays.sort(jewelry, comp);
	}
	
	static void solution() {
		int idx = 0;
		for(int i=0; i<k; i++) {
			int bagSize = bag[i];
			for(int j=idx; j<n; j++) {
				if(jewelry[j][0]<=bagSize) {
					pq.add(jewelry[j][1]);
					idx++;
				} else break;
			}
			if(!pq.isEmpty()) ans += pq.poll();
		}
		System.out.println(ans);
	}
}
