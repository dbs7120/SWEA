package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-19
// SWEA D4 1226
// DFS 풀이
public class 미로1_0619 {

	static int map[][];
	static boolean visited[][], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int testcaseNum = Integer.parseInt(br.readLine());
			int startX = 0, startY = 0;
			map = new int[16][16]; // 0: 길 / 1: 벽 / 2: 출발점 / 3: 도착점
			visited = new boolean[16][16];
			result = false;

			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (map[i][j] == 2) {
						startY = i;
						startX = j;
					} else if (map[i][j] == 1) {
						visited[i][j] = true;
					}
				}
			}

			DFS(startY, startX);
			bw.append("#" + testcaseNum + " " + (result ? "1" : "0") + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static void DFS(int y, int x) {
		if (map[y][x] == 3) {
			result = true;
			return;
		}

		visited[y][x] = true;

		if (y + 1 < 16 && !visited[y + 1][x])
			DFS(y + 1, x);
		if (y - 1 > 0 && !visited[y - 1][x])
			DFS(y - 1, x);
		if (x + 1 < 16 && !visited[y][x + 1])
			DFS(y, x + 1);
		if (x - 1 > 0 && !visited[y][x - 1])
			DFS(y, x - 1);

	}

}
