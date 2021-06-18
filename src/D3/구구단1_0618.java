package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-18
// SWEA D3 12004
public class 구구단1_0618 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int gugudan[] = new int[81];
		int idx = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				gugudan[idx++] = i * j;
			}
		}

		for (int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			boolean result = false;

			for (int i = 0; i < 81; i++) {
				if (num == gugudan[i]) {
					result = true;
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
