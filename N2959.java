import java.io.*;
import java.util.*;
public class N2959 {
	static int[] arr = new int[4];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) arr[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		Arrays.sort(arr);
		System.out.println(arr[0]*arr[2]);		
	}
}