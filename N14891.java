import java.io.*;

public class N14891 {
	
	static int[][] wheel = new int[4][8];
	static boolean[] spinned;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<4; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<8; j++) {
				wheel[i][j] = input[j]-'0';
			}
		}
		
		int spinTime = Integer.parseInt(br.readLine());
		
		for (int i=0; i<spinTime; i++) {
			boolean reverse = false;
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			if(input[1].equals("-1")) { reverse = true; }
			spinned = new boolean[5];
			spin(num, reverse);
			//showWheels();
		}
		int score = wheel[0][0]+wheel[1][0]*2+wheel[2][0]*4+wheel[3][0]*8;
		System.out.println(score);
	}
	
	static void spin(int num, boolean reverse) {
		if(!spinned[num]) {  
			spinned[num] = true; 
			if(num+1<=4 && wheel[num-1][2]!=wheel[num][6]) { spin(num+1, !reverse); }
			if(num-1>=1 && wheel[num-1][6]!=wheel[num-2][2]) { spin(num-1, !reverse); }
			selfSpin(num, reverse);
		} return;
	}
	
	static void selfSpin(int num, boolean reverse) {
		if(reverse) {
			int tmp = wheel[num-1][0];
			for(int i=0; i<7; i++) {
				wheel[num-1][i] = wheel[num-1][i+1];
			} wheel[num-1][7] = tmp;
		} else {
			int tmp = wheel[num-1][7];
			for(int i=0; i<7; i++) {
				wheel[num-1][7-i] = wheel[num-1][6-i];
			} wheel[num-1][0] = tmp;
		}
	}
	
	static void showWheels() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(wheel[i][j]+" ");
			} System.out.println();
		}
	}
}