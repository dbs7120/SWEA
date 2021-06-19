package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 2021-06-19
// SWEA D2 1227
// BFS 풀이
public class 미로2_0619 {
	static int map[][];
	static boolean visited[][], result;
	static int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int testcaseNum = Integer.parseInt(br.readLine());
			int startY = 0, startX = 0;
			map = new int[100][100]; // 0: 길 / 1: 벽 / 2: 출발점 / 3: 도착점
			visited = new boolean[100][100];
			result = false;

			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (map[i][j] == 2) {
						startY = i;
						startX = j;
					} else if (map[i][j] == 1) {
						visited[i][j] = true;
					}

				}
			}

			BFS(startY, startX);
			bw.append("#" + testcaseNum + " " + (result ? "1" : "0") + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void BFS(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (map[cur.y][cur.x] == 3) {
				result = true;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= 100 || nx >= 100 || visited[ny][nx])
					continue;
				q.offer(new Point(ny, nx));
				visited[ny][nx] = true;

			}
		}

	}
}
