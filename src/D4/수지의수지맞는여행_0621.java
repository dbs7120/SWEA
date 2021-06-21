package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-21
// SWEA D4 7699
public class 수지의수지맞는여행_0621 {
	static int R, C, map[][], result;
	static boolean alphabet[];
	static int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[R][C];
			alphabet = new boolean[26]; // 아스키코드 대문자 A~Z

			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			alphabet[map[0][0] - 'A'] = true;
			DFS(0, 0, 1);
			bw.append("#" + t + " " + result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void DFS(int y, int x, int cnt) {
		result = Math.max(result, cnt);

		if (result == 26) // 가지치기 (모든 알파벳을 다 보면 최대이므로 모든 그래프 바로 종료)
			return;

		for (int d = 0; d < 4; d++) {

			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= R || nx >= C || alphabet[map[ny][nx] - 'A'])
				continue;
			alphabet[map[ny][nx] - 'A'] = true;
			DFS(ny, nx, cnt + 1);
			alphabet[map[ny][nx] - 'A'] = false; // 한 DFS 다돌면 방문 해제

		}

	}

}
