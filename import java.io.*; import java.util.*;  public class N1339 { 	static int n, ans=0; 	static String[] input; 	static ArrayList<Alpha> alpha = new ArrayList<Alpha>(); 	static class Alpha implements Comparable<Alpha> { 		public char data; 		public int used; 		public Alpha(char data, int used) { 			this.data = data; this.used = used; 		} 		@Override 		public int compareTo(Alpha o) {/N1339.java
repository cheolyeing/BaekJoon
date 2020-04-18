import java.io.*;
import java.util.*;

public class N1339 {
	static int n, ans=0;
	static String[] input;
	static ArrayList<Alpha> alpha = new ArrayList<Alpha>();
	static class Alpha implements Comparable<Alpha> {
		public char data;
		public int used;
		public Alpha(char data, int used) {
			this.data = data; this.used = used;
		}
		@Override
		public int compareTo(Alpha o) {
			// TODO Auto-generated method stub
			return o.used - this.used;
		}
	}
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new String[n];
		for(int i=0; i<n; i++) input[i] = br.readLine();
		for(int i=65; i<91; i++) alpha.add(new Alpha((char)i, 0));
	}
	
	static void solution() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<input[i].length(); j++) {
				int idx = input[i].charAt(j)-'A';
				alpha.get(idx).used += (int)Math.pow(10, input[i].length()-j-1);
			}
		}
		Collections.sort(alpha);
		for(int i=0; i<10; i++) alpha.get(i).used = 9-i;
		
		for(int i=0; i<n; i++) {
			int num = 0;
			for(int j=0; j<input[i].length(); j++) {
				for(int k=0; k<10; k++) {
					if(input[i].charAt(j)==alpha.get(k).data) {
						num = num * 10 + alpha.get(k).used; break;
					}
				}
			} ans += num;
		}
		System.out.println(ans);
	}
}
