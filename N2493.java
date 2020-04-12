import java.io.*;

public class N2493 {
	
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		String[] num = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
	}
	
	static void solution() {
		int idx = 0;
		int tower=arr[0];
		for(int i=1; i<n; i++) {
			if(arr[i]<tower) {
				System.out.println(idx);
			} else {
				
			}
		}
	}
}