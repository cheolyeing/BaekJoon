import java.io.*;

public class N10798 {
	static char[][] input = new char[5][15];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) input[i][j] = s.charAt(j);
			for(int j=s.length(); j<15; j++) input[i][j] = ' ';
		}
	}
	
	static void solution() {
		String output = "";
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(input[j][i]!=' ') output += input[j][i];
			}
		}
		System.out.println(output);
	}
}
