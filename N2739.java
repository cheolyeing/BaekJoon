import java.io.*;

public class N2739 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i=1; i<10; i++) {
			String result = Integer.toString(n)+" * "+Integer.toString(i)+" = "+Integer.toString(n*i);
			System.out.println(result);
		}
	}
}