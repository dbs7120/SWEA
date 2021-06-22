package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-22
// SWEA D4 7733
public class 치즈도둑_0622 {
	static int N, cheese[][], result, maxDay, cnt;
	static int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			result = -1;
			maxDay = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, cheese[i][j]);
				}
			}

			for (int day = 0; day <= maxDay; day++) {
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] == day) {
							cheese[i][j] = 0;
						}
					}
				}
				cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] != 0 && !visited[i][j]) { // DFS 횟수 카운터로 상하좌우 이어져있는지 판단
							DFS(i, j);
							cnt++;
						}
					}
				}
				result = Math.max(result, cnt);

			}
			bw.append("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static void DFS(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || cheese[ny][nx] == 0)
				continue;
			visited[ny][nx] = true;
			DFS(ny, nx);
		}

	}

}
