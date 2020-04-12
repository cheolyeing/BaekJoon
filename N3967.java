import java.io.*;
public class N3967 {
	
	static int[][] magicStar = new int[5][9];
	static boolean[] visit = new boolean[13];
	static int[][] pos = {{0,4}, {1,1}, {1,3}, {1,5}, {1,7}, {2,2}, {2,6}, {3,1}, {3,3}, {3,5}, {3,7}, {4,4}};
	
	public static void main(String[] args) throws IOException {
		setting();
		backTracking(0);
	}
	
	static void backTracking(int idx) {
		if(idx==12) { 
			if(magicStar[1][1]+magicStar[2][2]+magicStar[3][3]+magicStar[4][4]!=26) {return;}
			if(magicStar[1][7]+magicStar[2][6]+magicStar[3][5]+magicStar[4][4]!=26) {return;}
			show(); System.exit(0); }
		if(idx==5) { if(magicStar[1][1]+magicStar[1][3]+magicStar[1][5]+magicStar[1][7]!=26) {return;}} 
		if(idx==8) { if(magicStar[0][4]+magicStar[1][3]+magicStar[2][2]+magicStar[3][1]!=26) {return;}} 	
		if(idx==11) { if(magicStar[3][1]+magicStar[3][3]+magicStar[3][5]+magicStar[3][7]!=26) {return;}}
		if(idx==11) { if(magicStar[0][4]+magicStar[1][5]+magicStar[2][6]+magicStar[3][7]!=26) {return;}} 
		int[] xy = pos[idx];
		int x = xy[0], y = xy[1];
		if(magicStar[x][y]==0) {
			for (int k=1; k<=12; k++) {
				if(!visit[k]) {
					visit[k] = true;
					magicStar[x][y]=k;
					backTracking(idx+1);
					visit[k] = false;
					magicStar[x][y]=0;
				}
			}
		} else {backTracking(idx+1);}
	}

	static void show() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				if(magicStar[i][j]==0) {
					sb.append('.');
				} else {
					sb.append((char)(magicStar[i][j]+(int)'A'-1));
				}
			} sb.append("\n");
		} System.out.println(sb);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<5; i++) {
			String input = br.readLine().trim();
			for(int j=0; j<9; j++) {
				if(input.charAt(j)=='.') { continue; }
				else {
					if(input.charAt(j)=='x') {
						magicStar[i][j] = 0;
					} else {
						magicStar[i][j] = charToInt(input.charAt(j));
						visit[magicStar[i][j]] = true;
					}
				}
			}
		}
	}
	
	static int charToInt(char c) { return (int)c-'A'+1; }
}