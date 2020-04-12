import java.io.*;
import java.util.*;
public class N2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		
		while(true) {
			if(list.size()==1) {
				System.out.println(list.get(0)); break;
			}
			list.poll();
			int tmp = list.poll();
			list.add(tmp);
		}
	}
}