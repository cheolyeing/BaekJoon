import java.io.*;

public class N2753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		
		if(year%400==0) {
			System.out.println("1");
		} else {
			if(year%100==0) {
				System.out.println("0");
			} else if(year%4==0) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}
}