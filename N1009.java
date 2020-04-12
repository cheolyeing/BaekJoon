import java.util.*;

public class N1009 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int i=0; i<TestCase; i++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			
			int[] list = new int[4];
			list[0] = a*a*a*a%10;
			list[1] = list[0]*a % 10;
			list[2] = list[1]*a % 10;
			list[3] = list[2]*a % 10;
			
			if(list[b%4] != 0) {
				System.out.println(list[b%4]);
			} else { System.out.println(10);}
		}
	}
}