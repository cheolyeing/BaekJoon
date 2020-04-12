import java.io.*;

public class N2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int res = A*B*C;
		int[] ans = new int[10];
		for(int i=0; i<10; i++) {
			ans[i] = 0;
		}
		String[] array = Integer.toString(res).split("");
		
		for(int i=0; i<array.length; i++) {
			ans[Integer.parseInt(array[i])]++;
		}
		
		for(int i=0; i<10; i++) {
			bw.write(ans[i]+"\n");
		} bw.flush();
	}
}