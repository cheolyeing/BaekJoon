import java.util.*;

public class N18406 {
	public static void main (String[]v) {
		Scanner s=new Scanner(System.in);
		String a=s.next();
		int t=0;
		int l=a.length()/2;
		for(int i=0;i<l;i++) {t+=a.charAt(i)-a.charAt(i+l);}
		System.out.print((t==0)?"LUCKY":"READY");
	}
}