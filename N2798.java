import java.io.*;
import java.util.*;
import java.math.*;

class N2798{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[] input = new int[N];
		line = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(input);
		int result = 0;
		for(int i = 0; i < N; i++) {
			int j = i + 1;
			int k = N - 1;
			while(j < k) {
				int sum = input[i] + input[j] + input[k];
				if(sum <= M && M-sum < M - result) {
					result = sum;
				}
				int value1 = input[i] + input[j] + input[k-1];
				int value2 = input[i] + input[j+1] + input[k];
				if(value1 > M || value2 > M){
					k--;
				} else {
					if(M - value1 < M - value2) {
						k--;
					} else {
						j++;
					}
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
	}
}