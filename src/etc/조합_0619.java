package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-19
// nCr 결과 출력
public class 조합_0619 {
	static int N, R, arr[];
	static boolean visited[];
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			result = 0;
			arr = new int[R];
			visited = new boolean[N];
			comb(0, 0);
			bw.append("#" + t + " " + (result % 1234567891) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void comb(int cnt, int idx) {
		if (cnt == R) {
			result++;
			return;
		}
		for (int i = idx; i < N; i++) {
			if (visited[i])
				continue;
			arr[cnt] = i + 1;
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}

	}

}
