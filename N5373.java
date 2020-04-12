import java.io.*;
import java.util.*;

public class N5373 {
	static class Piece {
		char up, down, left, right, front, back;
		public Piece(char u, char d, char l, char r, char f, char b) {
			this.up = u; this.down = d;
			this.left = l; this.right = r;
			this.front = f; this.back = b;
		}
		public void spin(char side, boolean clockwise) {
			switch (side) {
			case 'U' :
				if(clockwise) {
					char tmp = this.back;
					this.back = this.left;
					this.left = this.front;
					this.front = this.right;
					this.right = tmp;
				} else {
					char tmp = this.back;
					this.back = this.right;
					this.right = this.front;
					this.front = this.left;
					this.left = tmp;
				}
				break;
			case 'D' :
				if(!clockwise) {
					char tmp = this.back;
					this.back = this.left;
					this.left = this.front;
					this.front = this.right;
					this.right = tmp;
				} else {
					char tmp = this.back;
					this.back = this.right;
					this.right = this.front;
					this.front = this.left;
					this.left = tmp;
				}
				break;
			case 'L' :
				if(clockwise) {
					char tmp = this.up;
					this.up = this.back;
					this.back = this.down;
					this.down = this.front;
					this.front = tmp;
				} else {
					char tmp = this.up;
					this.up = this.front;
					this.front = this.down;
					this.down = this.back;
					this.back = tmp;
				}
				break;
			case 'R' :
				if(!clockwise) {
					// u f d b >> b u f d
					char tmp = this.up;
					this.up = this.back;
					this.back = this.down;
					this.down = this.front;
					this.front = tmp;
				} else {
					char tmp = this.up;
					this.up = this.front;
					this.front = this.down;
					this.down = this.back;
					this.back = tmp;
				}
				break;
			case 'F' :
				if(clockwise) {
					char tmp = this.up;
					this.up = this.left;
					this.left = this.down;
					this.down = this.right;
					this.right = tmp;
				} else {
					char tmp = this.up;
					this.up = this.right;
					this.right = this.down;
					this.down = this.left;
					this.left = tmp;
				}
				break;
			case 'B' :
				if(!clockwise) {
					char tmp = this.up;
					this.up = this.left;
					this.left = this.down;
					this.down = this.right;
					this.right = tmp;
				} else {
					char tmp = this.up;
					this.up = this.right;
					this.right = this.down;
					this.down = this.left;
					this.left = tmp;
				}
				break;
			}
		}
	}
	static Piece[][][] cube;
	static int n;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			cubeInitializing();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				String command = st.nextToken();
				char d = command.charAt(0);
				boolean clockwise = command.charAt(1)=='+';
				cubing(d, clockwise);
				//showCube();
			}
			showUp();
		}
	}
	
	static void showUp() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[j][i][0].up);
			} System.out.println();
		}
	}
	
	static void cubing(char d, boolean clockwise) {
		switch(d) {
		case 'U' :
			if(clockwise) {
				Piece tmp1 = cube[2][0][0];
				cube[2][0][0] = cube[0][0][0];
				cube[0][0][0] = cube[0][2][0];
				cube[0][2][0] = cube[2][2][0];
				cube[2][2][0] = tmp1;
				Piece tmp2 = cube[2][1][0];
				cube[2][1][0] = cube[1][0][0];
				cube[1][0][0] = cube[0][1][0];
				cube[0][1][0] = cube[1][2][0];
				cube[1][2][0] = tmp2;
			} else {
				Piece tmp1 = cube[2][0][0];
				cube[2][0][0] = cube[2][2][0];
				cube[2][2][0] = cube[0][2][0];
				cube[0][2][0] = cube[0][0][0];
				cube[0][0][0] = tmp1;
				Piece tmp2 = cube[2][1][0];
				cube[2][1][0] = cube[1][2][0];
				cube[1][2][0] = cube[0][1][0];
				cube[0][1][0] = cube[1][0][0];
				cube[1][0][0] = tmp2;
			}
			break;
		case 'D' :
			if(!clockwise) {
				Piece tmp1 = cube[2][0][2];
				cube[2][0][2] = cube[0][0][2];
				cube[0][0][2] = cube[0][2][2];
				cube[0][2][2] = cube[2][2][2];
				cube[2][2][2] = tmp1;
				Piece tmp2 = cube[2][1][2];
				cube[2][1][2] = cube[1][0][2];
				cube[1][0][2] = cube[0][1][2];
				cube[0][1][2] = cube[1][2][2];
				cube[1][2][2] = tmp2;
			} else {
				Piece tmp1 = cube[2][0][2];
				cube[2][0][2] = cube[2][2][2];
				cube[2][2][2] = cube[0][2][2];
				cube[0][2][2] = cube[0][0][2];
				cube[0][0][2] = tmp1;
				Piece tmp2 = cube[2][1][2];
				cube[2][1][2] = cube[1][2][2];
				cube[1][2][2] = cube[0][1][2];
				cube[0][1][2] = cube[1][0][2];
				cube[1][0][2] = tmp2;
			}
			break;
		case 'L' :
			if(clockwise) {
				Piece tmp1 = cube[0][0][2];
				cube[0][0][2] = cube[0][2][2];
				cube[0][2][2] = cube[0][2][0];
				cube[0][2][0] = cube[0][0][0];
				cube[0][0][0] = tmp1;
				Piece tmp2 = cube[0][0][1];
				cube[0][0][1] = cube[0][1][2];
				cube[0][1][2] = cube[0][2][1];
				cube[0][2][1] = cube[0][1][0];
				cube[0][1][0] = tmp2;
			} else {
				Piece tmp1 = cube[0][0][2];
				cube[0][0][2] = cube[0][0][0];
				cube[0][0][0] = cube[0][2][0];
				cube[0][2][0] = cube[0][2][2];
				cube[0][2][2] = tmp1;
				Piece tmp2 = cube[0][0][1];
				cube[0][0][1] = cube[0][1][0];
				cube[0][1][0] = cube[0][2][1];
				cube[0][2][1] = cube[0][1][2];
				cube[0][1][2] = tmp2;
			}
			break;
		case 'R' :
			if(!clockwise) {
				Piece tmp1 = cube[2][0][2];
				cube[2][0][2] = cube[2][2][2];
				cube[2][2][2] = cube[2][2][0];
				cube[2][2][0] = cube[2][0][0];
				cube[2][0][0] = tmp1;
				Piece tmp2 = cube[2][0][1];
				cube[2][0][1] = cube[2][1][2];
				cube[2][1][2] = cube[2][2][1];
				cube[2][2][1] = cube[2][1][0];
				cube[2][1][0] = tmp2;
			} else {
				Piece tmp1 = cube[2][0][2];
				cube[2][0][2] = cube[2][0][0];
				cube[2][0][0] = cube[2][2][0];
				cube[2][2][0] = cube[2][2][2];
				cube[2][2][2] = tmp1;
				Piece tmp2 = cube[2][0][1];
				cube[2][0][1] = cube[2][1][0];
				cube[2][1][0] = cube[2][2][1];
				cube[2][2][1] = cube[2][1][2];
				cube[2][1][2] = tmp2;
			}
			break;
		case 'F' : 
			if(clockwise) {
				Piece tmp1 = cube[0][2][0];
				cube[0][2][0] = cube[0][2][2];
				cube[0][2][2] = cube[2][2][2];
				cube[2][2][2] = cube[2][2][0];
				cube[2][2][0] = tmp1;
				Piece tmp2 = cube[1][2][0];
				cube[1][2][0] = cube[0][2][1];
				cube[0][2][1] = cube[1][2][2];
				cube[1][2][2] = cube[2][2][1];
				cube[2][2][1] = tmp2;
			} else {
				Piece tmp1 = cube[0][2][0];
				cube[0][2][0] = cube[2][2][0];
				cube[2][2][0] = cube[2][2][2];
				cube[2][2][2] = cube[0][2][2];
				cube[0][2][2] = tmp1;
				Piece tmp2 = cube[1][2][0];
				cube[1][2][0] = cube[2][2][1];
				cube[2][2][1] = cube[1][2][2];
				cube[1][2][2] = cube[0][2][1];
				cube[0][2][1] = tmp2;
			}
			break;
		case 'B' :
			if(!clockwise) {
				Piece tmp1 = cube[0][0][0];
				cube[0][0][0] = cube[0][0][2];
				cube[0][0][2] = cube[2][0][2];
				cube[2][0][2] = cube[2][0][0];
				cube[2][0][0] = tmp1;
				Piece tmp2 = cube[1][0][0];
				cube[1][0][0] = cube[0][0][1];
				cube[0][0][1] = cube[1][0][2];
				cube[1][0][2] = cube[2][0][1];
				cube[2][0][1] = tmp2;
			} else {
				Piece tmp1 = cube[0][0][0];
				cube[0][0][0] = cube[2][0][0];
				cube[2][0][0] = cube[2][0][2];
				cube[2][0][2] = cube[0][0][2];
				cube[0][0][2] = tmp1;
				Piece tmp2 = cube[1][0][0];
				cube[1][0][0] = cube[2][0][1];
				cube[2][0][1] = cube[1][0][2];
				cube[1][0][2] = cube[0][0][1];
				cube[0][0][1] = tmp2;
			}
			break;
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				switch(d) {
				case 'U' :
					cube[i][j][0].spin('U', clockwise); break;
				case 'D' :
					cube[i][j][2].spin('D', clockwise); break;
				case 'L' :
					cube[0][i][j].spin('L', clockwise); break;
				case 'R' :
					cube[2][i][j].spin('R', clockwise); break;
				case 'F' :
					cube[i][2][j].spin('F', clockwise); break;
				case 'B' :
					cube[i][0][j].spin('B', clockwise); break;
				}
			}
		}
	}
	
	static void cubeInitializing() {
		cube = new Piece[3][3][3];
		// ³ôÀÌ 0
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				for(int z=0; z<3; z++) {
					cube[x][y][z] = new Piece('.', '.', '.', '.', '.', '.');
				}
			}
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				cube[i][j][0].up = 'w';
				cube[i][j][2].down = 'y';
				cube[0][i][j].left = 'g';
				cube[2][i][j].right = 'b';
				cube[i][0][j].back = 'o';
				cube[i][2][j].front = 'r';
			}
		}
		//showCube();
	}
	
	static void showCube() {
		System.out.println("----UP----");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[i][j][0].up);
			} System.out.println();
		}
		
		System.out.println("---DOWN---");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[i][j][2].down);
			} System.out.println();
		}
		
		System.out.println("---LEFT---");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[0][i][j].left);
			} System.out.println();
		}
		
		System.out.println("---RIGH---");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[2][i][j].right);
			} System.out.println();
		}
		
		System.out.println("---FRON---");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[i][2][j].front);
			} System.out.println();
		}
		
		System.out.println("---BACK---");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(cube[i][0][j].back);
			} System.out.println();
		}
	}
}