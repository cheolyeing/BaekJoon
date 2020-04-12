import java.io.*;
import java.util.*;

public class N11725 {
		
		static int[] parentNum;
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine());
			parentNum = new int[num+1];
			Arrays.fill(parentNum, 0);
			
			ArrayList<ArrayList<Integer>> node = new ArrayList<ArrayList<Integer>>();
			
			for (int i=0; i<=num; i++)
			{
				node.add(new ArrayList<Integer>());
			}
			
			for (int i=1; i<num; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				node.get(a).add(b);
				node.get(b).add(a);
			}
			
			search(node, 1);
			
			for(int i=2; i<=num; i++) {
				System.out.println(parentNum[i]);
			}
		}
		
		public static void search(ArrayList<ArrayList<Integer>> node, int start) {
			Iterator it = node.get(start).iterator();
			while(it.hasNext()) {
				int child = (int)it.next();
				node.get(child).remove(node.get(child).indexOf(start));
				parentNum[child]=start;
				search(node, child);
			}
		}
	}