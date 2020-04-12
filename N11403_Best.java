import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11403_Best {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine().trim());
		boolean[][] has = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			String[] input = br.readLine().trim().split(" ");
			for (int j=0; j<n; j++) {
				has[i][j] = input[j].compareTo("1") == 0 ? true : false;
			}
		}
		
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if(!has[i][j]) {
						has[i][j] = has[i][k] && has[k][j];
					}
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(has[i][j]) {
					sb.append("1 ");
				} else {
					sb.append("0 ");
				}
			} sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}