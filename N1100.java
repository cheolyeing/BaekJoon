import java.io.*;

public class N1100 {
	static char[][] chess = new char[8][8];
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<8; i++) {
			chess[i] = br.readLine().toCharArray();
		}
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if((i+j)%2==0 && chess[i][j]=='F') answer++;
			}
		}
		System.out.println(answer);
	}

}
