import java.io.*;
import java.util.*;

public class N1790 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int g=1; //ÀÚ¸´¼ö
		
		for (int i=1; i<100; i++) {
			if(k>9*i*Math.pow(10, i-1)) k-=9*i*Math.pow(10, i-1);
			else {g=i; break;}
		}
		
		int num = (int)Math.pow(10, g-1);
		
		num += k/g;
		
		k -= (k/g) * g;
		
		if(k==0) {
			if(num-1>n) {
				System.out.println(-1);
			} else {
				System.out.println(((num-1)+"").charAt(g-1));
			}
		}
		else {
			if(num>n) {
				System.out.println(-1);
			} else {
				System.out.println((num+"").charAt(k-1));
			}
		}
	}
}