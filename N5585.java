import java.util.*;

public class N5585 {
	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		int n = 1000 - sc.nextInt();
		int answer = 0;
		
		if(n>=500) {
			answer += n/500;
			n = n - (n/500) * 500;
		}
		
		if(n>=100) {
			answer += n/100;
			n = n - (n/100) * 100;
		}
		
		if(n>=50) {
			answer++;
			n-=50;
		}
		
		if(n>=10) {
			answer += n/10;
			n = n - (n/10) * 10;
		}
		
		if(n>=5) {
			answer++;
			n-=5;
		}
		
		if(n>=1) {
			answer += n;
			n = 0;
		}
		System.out.println(answer);
	}
}
