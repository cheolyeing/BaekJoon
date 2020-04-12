import java.io.*;
import java.util.*;

public class N1427 {
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int size = s.length();
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = (int)s.charAt(i) - (int)'0';
		}
		/*
		Arrays.sort(arr);
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}*/
		
		for(int i=0; i<size; i++) {
			for(int j=i; j<size; j++) {
				if(arr[i]<arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for(int i:arr) sb.append(i);
		System.out.print(sb);
	}
}