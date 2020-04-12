import java.io.*;
import java.util.*;

public class N14890 {
	
	static int[][] map;
	static int[][] remap;
	static int n;
	static int l;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		setting(); remap = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				remap[i][j] = map[j][i];
			}
		}
		
		for (int i=0; i<n; i++) {
			check(map[i]); 
			//System.out.println("<가로"+(i+1)+"<"+answer+">>");
			check(remap[i]);
			//System.out.println("<세로"+(i+1)+"<"+answer+">>");
		}
		
		System.out.println(answer);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for (int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
	}
	
	static void check(int[] line) {
		int checker = line[0];
		boolean down = false;
		boolean up = false;
		if(l==1) { up = true; }
		boolean canGo = true;
		int stack = 1;
		
		for (int i=1; i<n; i++) {
			if(down) {
				if(l==1) {
					down = false;
					if(checker==line[i]) {
						stack = 1; up = true;
					} else if(checker-line[i]==1) {
						stack = 1; up = false; down = true; checker = line[i];
					} else if(line[i]-checker==1 && up) {
						up = true; checker = line[i]; stack = 1; down = false;
					} else { break; }
				}
				else if(checker==line[i]) { stack++; if(stack>=l) {down = false; stack=0;}}
				else { break; }
			} else {
				if(checker == line[i]) { stack++; if(stack>=l) {up = true;}}
				else {
					if(line[i]-checker==1 && up) {
						checker = line[i]; stack = 1; if(stack<l) {up = false;} 
					} else if(checker-line[i]==1) {
						down = true; checker = line[i]; stack = 1; up = false;
					} else {
						break;
					}
				}
			} if(i==n-1) { 
				if(down) {
					if(stack>=l) {answer++;}} 
				else{answer++;}
			} 
		}
	}
}