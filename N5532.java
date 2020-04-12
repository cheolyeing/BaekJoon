import java.util.*;
public class N5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l, a, b, c, d;
		l = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		a = a%c==0 ? a/c : a/c+1;
		b = b%d==0 ? b/d : b/d+1;
		System.out.println(l-Math.max(a, b));
	}
}