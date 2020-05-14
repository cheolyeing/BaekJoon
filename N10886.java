import java.io.*;
import java.util.*;

public class N10886 {
	static int n, zero=0, one=0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			if(Integer.parseInt(br.readLine())==0) zero++;
			else one++;
		}
	}
	
	static void solution() {
		System.out.println("Junhee is " + (one>zero ? "" : "not ") + "cute!");
	}
}
