import java.io.*;

public class N2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int ans = 1;
		int index = 1;
		
		for(int i=0; i<8; i++) {
			int in = Integer.parseInt(br.readLine()); index++;
			if(num>in) { continue; }
			else { num = in; ans = index; }
		}
		bw.write(num+"\n"+ans); bw.flush();
	}
}