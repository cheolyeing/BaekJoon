import java.io.*;
import java.util.*;

public class N1089 {
	static char[][][] num = {
			{{'#', '#', '#'},{'#', '.', '#'},{'#', '.', '#'},{'#', '.', '#'},{'#', '#', '#'}},
			{{'.', '.', '#'},{'.', '.', '#'},{'.', '.', '#'},{'.', '.', '#'},{'.', '.', '#'}},
			{{'#', '#', '#'},{'.', '.', '#'},{'#', '#', '#'},{'#', '.', '.'},{'#', '#', '#'}},
			{{'#', '#', '#'},{'.', '.', '#'},{'#', '#', '#'},{'.', '.', '#'},{'#', '#', '#'}},
			{{'#', '.', '#'},{'#', '.', '#'},{'#', '#', '#'},{'.', '.', '#'},{'.', '.', '#'}},
			{{'#', '#', '#'},{'#', '.', '.'},{'#', '#', '#'},{'.', '.', '#'},{'#', '#', '#'}},
			{{'#', '#', '#'},{'#', '.', '.'},{'#', '#', '#'},{'#', '.', '#'},{'#', '#', '#'}},
			{{'#', '#', '#'},{'.', '.', '#'},{'.', '.', '#'},{'.', '.', '#'},{'.', '.', '#'}},
			{{'#', '#', '#'},{'#', '.', '#'},{'#', '#', '#'},{'#', '.', '#'},{'#', '#', '#'}},
			{{'#', '#', '#'},{'#', '.', '#'},{'#', '#', '#'},{'.', '.', '#'},{'#', '#', '#'}},
	};
	static int n, length;
	static boolean[][] visited;
	static ArrayList<Integer> floor = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[100][n+1];
		char[] tmp = br.readLine().toCharArray();
		length = tmp.length;
		char[][] sign = new char[5][length];
		sign[0] = tmp;
		for (int i=1; i<5; i++) {
			sign[i] = br.readLine().toCharArray();
		}
		
		String out = number(sign);
		solution(out, n, 0);
		
		for(int i=0; i<floor.size(); i++) System.out.println(floor.get(i));
	}
	
	static void solution(String out, int time, int idx) {
		if(time<0 || idx>n) return;
		
		int now = Integer.parseInt(out);
		if(!visited[now][idx]) {floor.add(now); visited[now][idx] = true;}
		else return;
		solution(out, time, idx+1);
		
		for(int i=idx; i<out.length(); i++) {
			String s1 = out.substring(0, i);
			String s2 = out.substring(i+1, out.length());
			switch (out.charAt(i)) {
				
				case '0' : 
					solution(s1+8+s2, time-1, i+1);
				case '1' :
					solution(s1+7+s2, time-2, i+1);
					solution(s1+4+s2, time-4, i+1);
					solution(s1+3+s2, time-6, i+1);
					solution(s1+0+s2, time-7, i+1);
					solution(s1+9+s2, time-7, i+1);
					solution(s1+8+s2, time-8, i+1);
				case '2' :
					solution(s1+8+s2, time-2, i+1);
				case '3' :
					solution(s1+9+s2, time-1, i+1);
					solution(s1+8+s2, time-2, i+1);
				case '4' :
					solution(s1+9+s2, time-3, i+1);
					solution(s1+8+s2, time-4, i+1);
				case '5' :
					solution(s1+6+s2, time-1, i+1);
					solution(s1+9+s2, time-1, i+1);
					solution(s1+8+s2, time-2, i+1);
				case '6' :
					solution(s1+8+s2, time-2, i+1);
				case '7' :
					solution(s1+0+s2, time-5, i+1);
					solution(s1+9+s2, time-5, i+1);
					solution(s1+8+s2, time-6, i+1);
				case '8' :
					return;
				case '9' :
					solution(s1+8+s2, time-1, i+1);
				default :
			}
		}
	}
	
	static String number(char[][] sign) {
		String res="";
		int idx=0;
		while(4*idx<length) {
			for(int k=0; k<10; k++) {
				boolean number = true;
				Loop :
				for(int i=0; i<5; i++) {
					for(int j=0; j<3; j++) {
						if(sign[i][4*idx+j]!=num[k][i][j]) break Loop;
					}
				}
				if(number) {
					res = res + k;
					idx++;
					break;
				}
			}
		}
		return res;
	}
	
	static int check(char[][] arr) {

		for (int k=0; k<10; k++) {
			boolean number = true;
			Loop :
			for (int i=0; i<5; i++) {
				for (int j=0; j<3; j++) {
					if(arr[i][j]!=num[k][i][j]) break Loop;
				}
			}
			if(number) return k;
		}
		return 0;
	}
	

}