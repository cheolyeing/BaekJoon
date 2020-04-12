import java.io.*;


public class N5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int time = 0;
		
		for (int i=0; i<input.length(); i++) {
			int num = (int)input.charAt(i)-65;
			
			if(num < 16) {
				time += ((int)input.charAt(i)-65)/3 + 3;
			}
			else if(num<19) { time += 8; }
			else if(num<22) { time += 9; }
			else {time += 10; }
		} System.out.println(time);
	}
}