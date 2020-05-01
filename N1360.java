import java.io.*;
import java.util.*;

public class N1360 {
	static int n;
	static int[][] command;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		command = new int[n][4];
		// 0:use, 1:type/undo, 2:c/t, 3:sec
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			if(input[0].equals("type")) {
				command[i][2] = (int)input[1].toCharArray()[0];
			} else {
				command[i][1] = 1;
				command[i][2] = Integer.parseInt(input[1]);
			}
			command[i][3] = Integer.parseInt(input[2]);
		}
	}
	
	static void solution() {
		for(int i=n-1; i>=0; i--) {
			if(command[i][0]==1) continue;
			if(command[i][1]==0) continue;
			int time = command[i][2];
			int sec = command[i][3];
			for(int j=i-1; j>=i-time; j--) {
				if(j<0) break;
				if(command[j][3]<sec-time) break;
				else command[j][0] = 1;
			}
			command[i][0]=1;
		}
		
		for(int i=0; i<n; i++) {
			if(command[i][0]==1) continue;
			System.out.print((char)command[i][2]);
		}
	}
}
