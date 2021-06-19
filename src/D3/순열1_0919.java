package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-19
// SWEA D3 9940
public class 순열1_0919 {

	static boolean result;
	static int input[], N, visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new int[N + 1];
			input = new int[N];
			result = true;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {

				input[i] = Integer.parseInt(st.nextToken());
				visited[input[i]]++;
			}

			for (int i = 1; i <= N; i++) {
				if (visited[i] > 1 || visited[i] == 0) {
					result = false;
					break;
				}
			}

			bw.append("#" + t + " " + (result ? "Yes" : "No") + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

}
