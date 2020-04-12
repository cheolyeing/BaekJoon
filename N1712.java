import java.io.*;

public class N1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int a = Integer.parseInt(input.split(" ")[0]);
		int b = Integer.parseInt(input.split(" ")[1]);
		int c = Integer.parseInt(input.split(" ")[2]);
		
		if(c<=b) {
			System.out.println(-1);
		} else {
			System.out.println(a/(c-b) +1);
		}
	}
}