import java.io.*;
import java.util.*;
import java.awt.*;

public class N2819 {
	static int n, m, left=0, right=0, up=0, down=0, onX=0, onY=0;
	static int[] pos = {0, 0};
	static int[] checkX, checkY;
	static char[] command;
	static long dist=0;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		checkX = new int[n];
		checkY = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			checkX[i] = x; checkY[i] = y;
			posCheck(x, y);
		}
		
		Arrays.sort(checkX);
		Arrays.sort(checkY);
		
		command = br.readLine().toCharArray();
	}
	
	static void posCheck(int x, int y) {
		if(x>0) {
			down++; dist += x;
		}
		else if(x<0) {
			up++; dist -= x;
		}
		else onX++;
		if(y>0) {
			right++; dist += y;
		}
		else if(y<0) {
			left++; dist -= y;
		}
		else onY++;
	}
	
	static void solution() {
		for(int i=0; i<m; i++) {
			char c = command[i];
			int diff = 0;
			switch(c) {
				case 'S' :
					pos[1]++;
					if(onY!=0) {
						left += onY;
						onY = 0;
					}
					checkOnY();
					if(onY!=0) {
						right -= onY;
					}
					diff = left - right - onY;
					break;
				case 'J' :
					pos[1]--;
					if(onY!=0) {
						right += onY;
						onY = 0;
					}
					checkOnY();
					if(onY!=0) {
						left -= onY;
					}
					diff = right - left - onY;
					break;
				case 'I' :
					pos[0]++;
					if(onX!=0) {
						up += onX;
						onX = 0;
					}
					checkOnX();
					if(onX!=0) {
						down -= onX;
					}
					diff = up - down - onX;
					break;
				case 'Z' :
					pos[0]--;
					if(onX!=0) {
						down += onX;
						onX = 0;
					}
					checkOnX();
					if(onX!=0) {
						up -= onX;
					}
					diff = down - up - onX;
					break;
				default :
					break;
			}
			dist += diff;
			System.out.println(dist);
		}
	}
	
	static void checkOnX() {
		int idx = Arrays.binarySearch(checkX, pos[0]);
		if(idx<0) return;
		else {
			int num = 0;
			int idxU = idx, idxD = idx;
			while(true) {
				if(idxU>=n) break;
				if(checkX[idxU++]==pos[0]) num++;
				else break;
			}
			while(true) {
				if(idxD<0) break;
				if(checkX[idxD--]==pos[0]) num++;
				else break;
			}
			onX = num-1;
		}
	}
	
	static void checkOnY() {
		int idx = Arrays.binarySearch(checkY, pos[1]);
		if(idx<0) return;
		else {
			int num=0;
			int idxU = idx, idxD = idx;
			while(true) {
				if(idxU>=n) break;
				if(checkY[idxU++]==pos[1]) num++;
				else break;
			}
			while(true) {
				if(idxD<0) break;
				if(checkY[idxD--]==pos[1]) num++;
				else break;
			}
			onY = num-1;
		}
	}
}
