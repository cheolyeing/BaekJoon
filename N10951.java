import java.io.*;
import java.util.*;

public class N10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int a = sc.nextInt(), b = sc.nextInt();
			System.out.println(a+b);
		} 
	}
}