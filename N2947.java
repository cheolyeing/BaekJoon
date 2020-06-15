import java.io.*;
import java.util.*;

public class N2947 {
	static int[] arr = new int[5];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<5; i++) arr[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		for(int i=0; i<5; i++) bubble();
	}
	
	static void bubble() {
		for(int i=0; i<4; i++) {
			if(arr[i]>arr[i+1]) {
				int tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
				showArr();
			}
		}
	}
	
	static void showArr() {
		for(int i=0; i<5; i++) System.out.print(arr[i]+" ");
		System.out.println();
	}
}
