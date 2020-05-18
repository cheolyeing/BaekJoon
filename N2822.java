import java.io.*;
import java.util.*;

public class Main {
	static int[][] score = new int[8][2];
	static boolean[] ans = new boolean[8];
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
		for(int i=0; i<8; i++) {
			score[i][0] = Integer.parseInt(br.readLine());
			score[i][1] = i+1;
		}
	}
	
	static void solution() {
		int sum=0;
		Arrays.sort(score, comp);
		for(int i=0; i<3; i++) ans[score[i][1]-1] = true;
		for(int i=3; i<8; i++) sum += score[i][0];
		System.out.println(sum);
		for(int i=0; i<8; i++) if(!ans[i]) System.out.print(i+1+" ");
	}
}
