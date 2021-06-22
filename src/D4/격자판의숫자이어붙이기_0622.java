package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 격자판의숫자이어붙이기_0622 {

	static char board[][];
	static HashSet<String> numbers; // ArraysList의 경우 시간초과남
	static int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	static class Point {
		int y, x;
		String str;

		public Point(int y, int x, String str) {
			this.y = y;
			this.x = x;
			this.str = str;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			numbers = new HashSet<>();
			board = new char[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					board[i][j] = st.nextToken().charAt(0);
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					BFS(i, j);
//					DFS(i, j, "");
				}
			}
			bw.append("#" + t + " " + numbers.size() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void BFS(int y, int x) { // BFS 풀이
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x, "" + board[y][x]));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.str.length() > 7) {
				return;
			} else if (cur.str.length() == 7) {
				if (!numbers.contains(cur.str))
					numbers.add(cur.str);
			}

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;
				if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4)
					continue;
				q.offer(new Point(ny, nx, cur.str + board[ny][nx]));
			}

		}

	}

	private static void DFS(int y, int x, String str) { // DFS 풀이
		if (str.length() == 7) {
			if (!numbers.contains(str)) {
				numbers.add(str);
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4)
				continue;
			DFS(ny, nx, str + board[ny][nx]);
		}

	}

}
