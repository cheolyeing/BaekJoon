import java.io.*;

public class N4641 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while(!(s=br.readLine()).equals("-1")) {
			String[] num = s.split(" ");
			int[] arr = new int[num.length-1];
			
			for (int i=0; i<num.length-1; i++) {
				arr[i] = Integer.parseInt(num[i]);
			}
			
			int answer = 0;
			
			for (int i=0; i<arr.length; i++) {
				for (int j=0; j<arr.length; j++) {
					if(i==j) continue;
					if(arr[i]*2==arr[j]) answer++;
				}
			} System.out.println(answer);
		}
	}
}