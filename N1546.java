import java.io.*;
import java.util.*;

public class N1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int N = Integer.parseInt(br.readLine());
		float[] subject = new float[N];
		float max = 0;
		double sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			subject[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, subject[i]);
		} 
		
		for (int i=0; i<N; i++) {
			subject[i] = (subject[i] / max) * 100;
			sum += subject[i];
		}
		
		System.out.println((sum/N));
	}
}