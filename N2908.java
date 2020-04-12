import java.io.*;
import java.util.*;

public class N2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		
		String input = br.readLine();
		String a = input.split(" ")[0];
		String b = input.split(" ")[1];
		
		int A = Integer.parseInt(new StringBuffer(a).reverse().toString());
		int B = Integer.parseInt(new StringBuffer(b).reverse().toString());
		
		System.out.println(Math.max(A, B));
		
	}
}