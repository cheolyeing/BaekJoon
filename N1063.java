import java.io.*;

public class N1063 {
	
	static int[] king;
	static int[] stone;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		for (int i=0; i<2; i++) {
			int x = s[i].charAt(0)-'A';
			int y = s[i].charAt(1)-'1';
			int[] tmp = {x, y};
			if(i==0) king = tmp;
			if(i==1) stone = tmp;
		} n = Integer.parseInt(s[2]);
		
		for (int i=0; i<n; i++) {
			
			int[] d = move(br.readLine());
			int kx = king[0] + d[0];
			int ky = king[1] + d[1];

			if(kx==stone[0] && ky==stone[1]) {
				int sx = kx+d[0]; int sy = ky+d[1];
				if(0<=sx && sx<8 && 0<=sy && sy<8) {
					king[0] = kx; king[1] = ky;
					stone[0] = sx; stone[1] = sy;
				}
			} else {
				if(0<=kx && kx<8 && 0<=ky && ky<8) {
					king[0] = kx; king[1] = ky;
				}
			}
		}
		System.out.println((char)((int)'A'+king[0])+""+(king[1]+1));
		System.out.println((char)((int)'A'+stone[0])+""+(stone[1]+1));
	}
	
	static int[] move(String s) {
		int x = 0; int y = 0;
		if(s.equals("R")) {
			x = 1;
		} else if(s.equals("L")) {
			x = -1;
		} else if(s.equals("T")) {
			y = 1;
		} else if(s.equals("B")) {
			y = -1;
		} else if(s.equals("RT")) {
			x = 1; y = 1;
		} else if(s.equals("LT")) {
			x = -1; y =1;
		} else if(s.equals("RB")) {
			x = 1; y = -1;
		} else {
			x = -1; y = -1;
		}
		int[] tmp = {x, y};
		return tmp;
	}
}
