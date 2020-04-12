import java.io.*;

public class N3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] num = new int[42];
		for(int i=0; i<42; i++) {
			num[i] = 0;
		}
		
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			num[n%42]++;
		}
		
		int ans = 0;
		for(int i=0; i<42; i++) {
			if(num[i]!=0) {
				ans++;
			}
		}
		bw.write(ans+" "); bw.flush();
	}
}