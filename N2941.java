import java.io.*;

public class N2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int answer = input.length();
		
		for(int i=1; i<input.length(); i++) {
			if(input.charAt(i)=='=') {
				if(input.charAt(i-1)=='c' || input.charAt(i-1)=='s') {
					answer--;
				}
				
				else if(input.charAt(i-1)=='z') {
					if(i>1) {
						if(input.charAt(i-2)=='d') { answer -= 2; }
						else { answer--;}
					}
					else {answer--;}
				}
			}
			
			if(input.charAt(i)=='-') {
				if(input.charAt(i-1)=='c' || input.charAt(i-1)=='d') {
					answer--;
				}
			}
			
			if(input.charAt(i)=='j') {
				if(input.charAt(i-1)=='l' || input.charAt(i-1)=='n') {
					answer--;
				}
			}
		} System.out.println(answer);
	}
}