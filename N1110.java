import java.io.*;

public class N1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int cycle = 1;
		int New = Cycle(n);
		
		while(New!=n) {
			New = Cycle(New);
			cycle++;
		}
		bw.write(Integer.toString(cycle)); bw.flush();
	}
	
	public static int Cycle(int n) {
		return (n%10)*10 + ((n/10)+(n%10))%10;
	}
}