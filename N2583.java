import java.io.*;
import java.util.*;

public class N2583 {
	
	static Queue<Integer[]> q = new LinkedList<Integer[]>();
	static int[][] map;
	static boolean[][] visit;
	static int m, n;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int size = 0;
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	
	public static void dfs(int x, int y) {
		
		visit[x][y] = true;
		
		for (int i=0; i<4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			
			if(next(nx, ny)) { size++; dfs(nx, ny); }
		}
	}
	
	public static void setting()
	{
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				map[i][j] = 1; visit[i][j]=false;
			}
		}
	}
	
	public static void DrawRectangle(int x1, int y1, int x2, int y2)
	{
		for (int i=x1; i<x2; i++) {
			for (int j=y1; j<y2; j++) {
				map[j][i]=0;
			}
		}
	}
	
	public static boolean inrange(int x, int y)
	{
		if(x>=0 && x<m && y>=0 && y<n)
		{ return true; }
		else {return false;}
	}
	
	public static boolean next(int x, int y)
	{
		if(inrange(x, y) && map[x][y]==1 && !visit[x][y])
		{ visit[x][y]=true; return true;}
		else {return false;}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visit = new boolean[m][n];
		setting();
		int k = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<k; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			DrawRectangle(x1, y1, x2, y2);
		}
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				if(next(i, j))
				{
					size = 1;
					dfs(i, j);
					answer.add(size);
				}
			}
		}
		Collections.sort(answer);
		int L = answer.size();
		System.out.println(L);
		for (int i=0; i<L; i++)
		{
			System.out.print(Integer.toString(answer.get(i))+" ");
		}
	}
}