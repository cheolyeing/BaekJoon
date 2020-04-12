import java.io.*;

public class N2224 {
	static boolean[][] logic = new boolean[53][53];
	public static void main(String[] args) throws IOException {
		// A : 65 ~ Z : 90
		// a : 97 ~ z : 122
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			char[] input = br.readLine().toCharArray();
			logic[charToInt(input[0])][charToInt(input[5])] = true;
		}
		
		for (int k=1; k<=52; k++) {
			for (int i=1; i<=52; i++) {
				if(i==k) continue;
				for (int j=1; j<=52; j++) {
					if(i==j) continue;
					if(logic[i][k] && logic[k][j]) {
						logic[i][j] = true;
					}
				}
			}
		}
		int answer = 0;
		for (int i=1; i<=52; i++) {
			for (int j=1; j<=52; j++) {
				if(i==j) continue;
				if(logic[i][j]) answer++;
			}
		}
		System.out.println(answer);
		
		for (int i=1; i<=52; i++) {
			for (int j=1; j<=52; j++) {
				if(i==j) continue;
				if(logic[i][j]) System.out.println(intToChar(i)+" => "+intToChar(j));
			}
		}
	}
	
	static int charToInt(char c) {
		int res = (int)c;
		return res>90 ? res-70 : res-64;
	}
	
	static char intToChar(int i) {
		return i>26 ? (char)(i+70) : (char)(i+64);
	}
}