import java.io.*;

public class N1075 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		n = (n/100)*100;
		
		
		for(int i = 0; i<100; i++) {
			if((n+i)%d == 0) {
				if(i<10) {
					System.out.println("0"+i);
				} else { System.out.println(i);	}
				System.exit(0);
			}
		}
	}

}
