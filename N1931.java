import java.io.*;
import java.util.*;

public class N1931 {
	
	static int n;
	static int[][] time;
	static int front = 0;
	static int back = 0;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		time = new int[n][2];
		
		for (int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			time[i][0] = Integer.parseInt(s[0]);
			time[i][1] = Integer.parseInt(s[1]);
		}
		
		Arrays.sort(time, (o1, o2) -> {
			if(o1[1]==o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int comp = time[0][1];
		int small = -1;
		boolean plus = true;
		//showArray();
		for(int i=0; i<n; i++) {
			if(time[i][0]>=small) {
				if(time[i][0]==small&&time[i][1]==small) {
					answer++;
				} else { answer++; small = time[i][1]; }
				//System.out.println(i);
			}
		}
		System.out.println(answer);
		//showArray();
	}
	
	static void showArray() {
		for (int i=0; i<n; i++) {
			System.out.println(time[i][0]+" "+time[i][1]);
		}
	}
}