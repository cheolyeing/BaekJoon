import java.io.*;
import java.util.*;

public class N4344 {
	
	static int[] score;
	static float sum = 0;
	static int students = 0;
	static float average;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students = Integer.parseInt(st.nextToken());
			score = new int[students];
			sum = 0;
			for (int j=0; j<students; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
			average = sum / students;
			
			float count = 0;
			for (int j=0; j<students; j++) {
				if(score[j]>average) {
					count++;
				}
			} 
			float ans = (float)100 * (float)count / (float)students;
			ans = (float) (Math.round(ans*1000)/1000.0);
			System.out.println(String.format("%.3f", ans)+"%");
		}
	}
}