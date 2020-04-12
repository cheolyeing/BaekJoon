import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N2667 {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int number = 1;
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static int[][] map = new int[n][n];
	static int[][] visit = new int[n][n];
	
	static void dfs(int x, int y)
	{
		visit[x][y] = 1;
		
		for(int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<n && ny<n)
			{
				if(visit[nx][ny]==0 && map[nx][ny]==1)
				{
					number++;
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		
		for (int i=0; i<n; i++)
		{
			String a = sc.next();
			for(int j=0; j<n; j++)
			{
				map[i][j] = a.charAt(j)-'0';
				visit[i][j] = 0;
			}
		}
		
		int count = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				if(map[i][j]==1 && visit[i][j]==0)
				{
					count++;
					dfs(i,j);
					result.add(number);
					number = 1;
				}
			}
		}
		System.out.println(count);
		Collections.sort(result);
		for(int i=0; i<count; i++)
		{
			System.out.println(result.get(i));
		}
	}
}