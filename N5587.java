import java.io.*;
import java.util.*;
public class N5587 {
	static int n;
	static ArrayList<Integer> sg = new ArrayList();
	static ArrayList<Integer> gs = new ArrayList();
	static boolean[] s, g;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			sg.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(sg);
		
		for (int i=1; i<=2*n; i++) {
			if(!sg.contains(i)) {
				gs.add(i);
			}
		}
		turn(true, 0);
	}
	
	static void turn(boolean first, int lastCard) {
		if(sg.size()==0) {
			System.out.println(gs.size()+"\n"+0);
			System.exit(0);
		}
		if(gs.size()==0) {
			System.out.println(0+"\n"+sg.size());
			System.exit(0);
		}
		boolean made = false;
		if(first) {
			for (int i=0; i<sg.size(); i++) {
				if(sg.get(i)>lastCard) {
					lastCard = sg.get(i);
					sg.remove(i);
					made = true;
					break;
				}
			}
		} else {
			for (int i=0; i<gs.size(); i++) {
				if(gs.get(i)>lastCard) {
					lastCard = gs.get(i);
					gs.remove(i);
					made = true;
					break;
				}
			}
		}
		if(!made) lastCard = 0;
		turn(!first, lastCard);
	}
}