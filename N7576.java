import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7576 {
		
	static int m;
	static int n;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] tomato;
	static boolean[][] visit;
	static int day = 0;
	static Queue<Integer[]> q = new LinkedList<Integer[]>();
	static int good = 0;
	
	public static void bfs(int x, int y)
	{
		visit[x][y]=true;
		
		for (int i=0; i<4; i++)
		{
			int nx = x+dx[i], ny = y+dy[i];
			
			if(next(nx, ny))
			{
				good++;
				Integer[] pos = {nx, ny};
				q.offer(pos);
			}
		}
	}
	
	public static boolean inrange(int x, int y)
	{
		if(x>=0 && x<n && y>=0 && y<m)
			return true;
		else return false;
	}
	
	public static boolean next(int x, int y)
	{
		if(inrange(x, y) && tomato[x][y]==0 && !visit[x][y])
		{tomato[x][y] = 1; return true;}
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		int notgood = 0;
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt(); n = sc.nextInt();
		
		tomato = new int[n][m]; visit = new boolean[n][m];

		for (int i=0; i<n; i++)
		{
			for (int j=0; j<m; j++)
			{
				tomato[i][j] = sc.nextInt();
				if(tomato[i][j]==1)
				{
					Integer start[] = {i, j};
					q.offer(start); good++;
					visit[i][j] = false;
				}
				else if(tomato[i][j]==-1)
				{notgood++; visit[i][j] = true;}
				else 
				{visit[i][j] = false;}
			}
		}		
		
		while(!(good==m*n-notgood) && day<m*n)
		{
			day++;
			int len = q.size();
			for(int i=0; i<len; i++)
			{ Integer[] tmp = q.poll(); bfs(tmp[0], tmp[1]); }
		}
		
		if(good==m*n-notgood) {System.out.println(day);}
		else {System.out.println(-1);}
	}
}