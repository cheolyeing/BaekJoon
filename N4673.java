import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class N4673 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		for (int i=0; i<10001; i++) {
			list1.add(i);
			int app = selfnum(i);
			if(app<10001) {
				list2.add(app);
			}
		}
		list1.removeAll(list2);
		for (int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}
	
	public static int selfnum(int n) {
		int ans;
		
		if(n<10) {
			ans = 2*n;
		} else if(n<100) {
			ans = n + n/10 + n%10;
		} else if(n<1000) {
			ans = n + n/100 + (n/10)%10 + n%10;
		} else if(n<10000) {
			ans = n + n/1000 + (n/100)%10 + (n/10)%10 + n%10;
		} else {ans = 10001; }
		return ans;
	}
}
