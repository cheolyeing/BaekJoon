import java.util.*;
public class N1699 {
	static int n;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n+1];
		for (int i=1; i<=n; i++) {
			num[i] = num[i-1]+1;
			for (int j=1; j<=Math.sqrt(i); j++) {
				num[i] = Math.min(num[i], num[i-j*j]+1);
			}
		}
		System.out.println(num[n]);
	}
}