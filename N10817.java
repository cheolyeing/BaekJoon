import java.io.*;
import java.util.*;

public class N10817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(A); list.add(B); list.add(C);
		Collections.sort(list);
		System.out.println(list.get(1));
	}
}