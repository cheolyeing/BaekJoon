import java.io.*;
import java.util.*;

public class N5596 {
	static int[] score = new int[2];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				score[i] += Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		System.out.println(Math.max(score[0], score[1]));
	}
}
