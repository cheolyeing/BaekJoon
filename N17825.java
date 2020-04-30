import java.io.*;
import java.util.*;

public class N17825 {
	static int ans = 0;
	static int[] route = new int[32];
	static int[] horse = new int[4];
	// 1~20 : mainRoute, 21~23 sub1, 24~25 sub2, 26~28 sub3, 29~31 subF
	static int[] dice = new int[10];
	
	public static void main(String[] args) throws IOException {
		setBasic();
		setting();
		solution();
	}
	
	static void setBasic() {
		for(int i=1; i<=20; i++) route[i] = i*2;
		route[21] = 13; route[22] = 16; route[23] = 19;
		route[24] = 22; route[25] = 24;
		route[26] = 28; route[27] = 27; route[28] = 26;
		route[29] = 25; route[30] = 30; route[31] = 35;
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) dice[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		backTracking(new int[10], 0);
		System.out.println(ans);
	}
	
	static void backTracking(int[] arr, int num) {
		if(num==10) {
			play(arr);
			return;
		}
		for(int i=0; i<4; i++) {
			arr[num] = i;
			backTracking(arr, num+1);
		}
	}
	
	static void play(int[] arr) {
		horse = new int[4];
		int score = 0;
		
		for(int i=0; i<10; i++) {
			int idx = arr[i];
			horse[idx] = next(horse[idx], dice[i]);
			if(!doubleCheck(horse)) return;
			if(horse[idx]!=-1) score += route[horse[idx]];
		}
		ans = Math.max(ans, score);
	}
	
	static int next(int prev, int a) {
		if(a==0) return prev;
		if(prev==-1) return prev;
		// 1~20 : mainRoute, 21~23 sub1, 24~25 sub2, 26~28 sub3, 29~31 subF
		int res = prev;
		
		if(0<=prev && prev<=20) {
			if(prev==5) {
				return next(21, a-1);
			} else if(prev==10) {
				return next(24, a-1);
			} else if(prev==15) {
				return next(26, a-1);
			} else {
				res = prev + a;
				if(res>20) return -1;
				else return res;
			}
		}
		
		if(21<=prev && prev<23) {
			return next(prev+1, a-1);
		}
		
		if(prev==24) {
			return next(prev+1, a-1);
		}
		
		if(26<=prev && prev<28) {
			return next(prev+1, a-1);
		}
		
		if(prev==23 || prev==25 || prev==28) {
			return next(29, a-1);
		}
		
		if(prev<31) return next(prev+1, a-1);
		if(prev==31) return next(20, a-1);
		return 0;
	}
	
	static boolean doubleCheck(int[] horse) {
		for(int i=0; i<4; i++) {
			for(int j=i+1; j<4; j++) {
				if(horse[i]==0 || horse[i]==-1) continue;
				if(horse[i]==horse[j]) return false;
			}
		}
		return true;
	}
}
