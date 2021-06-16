package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-16
// SWEA D3 1206
public class View_0616 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) { // 테케 갯수 고정
			int len = Integer.parseInt(br.readLine());
			boolean map[][] = new boolean[255][len]; // 빌딩 높이는 최대 255
			int result = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int l = 0; l < len; l++) {
				int height = Integer.parseInt(st.nextToken());
				for (int h = 0; h < height; h++) {
					map[h][l] = true;
				}
			}

			for (int i = 0; i < 255; i++) {
				for (int j = 2; j < len - 2; j++) { // 좌우 두칸 여백
					if (map[i][j] && !map[i][j - 2] && !map[i][j - 1] && !map[i][j + 1] && !map[i][j + 2])
						result++;
				}
			}
			bw.append("#" + t + " " + result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

}
