import java.io.*;

public class N1152 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine().trim();
		
		String[] count = input.split(" ");
		
		if(count[0].length()==0) {System.out.println(0);}
		else { System.out.println(count.length);}		
	}
}