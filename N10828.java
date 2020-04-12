import java.io.*;
import java.util.*;

public class N10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			if(st.nextToken().equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			} else if(s.equals("top")) {
				if(stack.size()==0) System.out.println(-1);
				else System.out.println(stack.get(stack.size()-1));
			} else if(s.equals("size")) {
				System.out.println(stack.size());
			} else if(s.equals("empty")) {
				if(stack.size()==0) System.out.println(1);
				else System.out.println(0);
			} else if(s.equals("pop")) {
				if(stack.size()==0) System.out.println(-1);
				else {
					System.out.println(stack.getLast());
					stack.remove(stack.size()-1);
				}
			}
		}
		
	}
}