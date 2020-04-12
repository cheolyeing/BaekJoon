import java.io.*;
import java.util.*;

public class N10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		String answer = Integer.toString(list.get(0))+" "+Integer.toString(list.get(list.size()-1));
		bw.write(answer); bw.flush();
	}
}