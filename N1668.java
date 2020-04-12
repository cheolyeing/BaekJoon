import java.io.*;

public class N1668 {
	static int n;
	static int[] trophy;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); trophy = new int[n];
		for (int i=0; i<n; i++) trophy[i] = Integer.parseInt(br.readLine());
		
		int hL=0; int cntL=0;
		for (int i=0; i<n; i++) {
			if(hL<trophy[i]) {
				cntL++; hL = trophy[i];
			}
		}
		
		int hR=0; int cntR=0;
		for (int i=1; i<=n; i++) {
			if(hR<trophy[n-i]) {
				cntR++; hR = trophy[n-i];
			}
		}
		System.out.println(cntL+"\n"+cntR);
	}
}