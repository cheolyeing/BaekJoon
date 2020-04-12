import java.io.*;

public class N1436 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int a = 665;
		
		while (n>0) {
			if(new String(++a+"").indexOf("666")>=0) {
				n--;
			}
		} 
		System.out.print(a);		
	}
}