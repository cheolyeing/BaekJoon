import java.io.*;

public class N9020 {
	
	static int tc;
	static int[] arr;
	static int max = 0;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		arr = new int[tc];
		
		for (int i=0; i<tc; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max<arr[i]) max = arr[i];
		}
		
		prime = new boolean[max+1]; prime[1] = true;
		for (int i=2; i<=Math.sqrt(max); i++) {
			if(!prime[i]) {
				for(int j=i+i; j<=max; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for (int i=0; i<tc; i++) {
			partition(arr[i]);
		}
	}
	
	static void partition(int num) {
		
		for(int i=num/2; i<num; i++) {
			int j = num-i;
			if(!prime[i]&&!prime[j]) {
				System.out.println(i>j?j+" "+i:i+" "+j); break;
			}
		}
	}
}