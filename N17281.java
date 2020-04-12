import java.io.*;
import java.util.*;
public class N17281 {
	static int inning;
	static int score=0, taja=0;
	static int[][] info;
	static boolean[] visited = new boolean[10];
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inning = Integer.parseInt(br.readLine());
		info = new int[inning+1][9];
		
		for (int i=1; i<=inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] arr = new int[9];
		backTracking(0,arr);
		System.out.println(score);
	}
	
	static void startWith(int[] arr) {
		int round = 1;
		int idx = 0;
		int player = arr[idx]-1;
		int out = 0;
		int point = 0;
		boolean[] baseball = new boolean[4];
		
		while(true) {
			if(out>=3) { out = 0; round++; baseball = new boolean[4];}
			if(round>inning) {
				if(score<point) score = point;
				break;
			}
			
			if(info[round][player]==0) out++;
			else {
				if(info[round][player]==1) {
					if(baseball[3]) point++;
					baseball[3] = baseball[2];
					baseball[2] = baseball[1];
					baseball[1] = true;
				}
				else if(info[round][player]==2) {
					if(baseball[3]) point++;
					if(baseball[2]) point++;
					baseball[3] = baseball[1];
					baseball[2] = true;
					baseball[1] = false;
				}
				else if(info[round][player]==3) {
					if(baseball[3]) point++;
					if(baseball[2]) point++;
					if(baseball[1]) point++;
					baseball[3] = true;
					baseball[2] = false;
					baseball[1] = false;
				}
				else {
					if(baseball[3]) point++;
					if(baseball[2]) point++;
					if(baseball[1]) point++;
					point++; baseball = new boolean[4];
				}
			}
			idx++;
			if(idx==9) idx = 0;
			player = arr[idx]-1;
		}
	}
	
	static void show(int arr[]) {
		for (int i=0; i<9; i++) {
			System.out.print(arr[i]+" ");
		} System.out.println();
	}
	
	static void backTracking(int idx, int[] arr) {
		if(idx==9) {
			startWith(arr);
			return;
		}
		
		if(idx==3) {
			arr[3] = 1; visited[1] = true;
			backTracking(4, arr);
		} else {
			for (int i=2; i<=9; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr[idx] = i;
					backTracking(idx+1, arr);
					visited[i] = false;
				}
			}
		}
	}
}