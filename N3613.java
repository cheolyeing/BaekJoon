import java.io.*;

public class N3613 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine().trim();
		if(str.length()==1) {
			if((int)str.charAt(0)<97 || (int)str.charAt(0)>122) {
				System.out.println("Error!"); System.exit(0);
			} else {
				System.out.println(str); System.exit(0);
			}
		}
		char[] input = str.toCharArray();
		
		int i = 0;
		int checker = 0;
		
		if((int)input[0]<97 || (int)input[0]>122) {System.out.println("Error!"); System.exit(0);}
		
		while(i<input.length) {
			if(input[i]=='_') {
				if(checker==2 || i+1>=input.length || (int)input[i+1]<97) {System.out.println("Error!"); System.exit(0);}
				checker = 1; i++;
				//if(i+1>=input.length) {System.out.println("Error!"); System.exit(0);}
				sb.append((char)((int)input[i]-32));
			} else if((int)input[i]<97) {
				if(checker==1) {System.out.println("Error!"); System.exit(0);}
				checker = 2;
				sb.append("_"+(char)((int)input[i]+32));
			} else {sb.append(input[i]);} i++;
		} System.out.println(sb);
	}
}