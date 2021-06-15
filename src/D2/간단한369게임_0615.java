package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-15
// SWEA D2 1926
public class 간단한369게임_0615 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1부터 N 까지의 369 출력(박수: '-' )
		// N범위: 10 <= N <= 1000
		int N = Integer.parseInt(br.readLine());

		String cur;
		Boolean is369 = false;
		for (int i = 1; i <= N; i++) {
			is369 = false;
			cur = String.valueOf(i);
			for (int c = 0; c < cur.length(); c++) {
				if (cur.charAt(c) == '3') {
					bw.append("-");
					is369 = true;
				}
				if (cur.charAt(c) == '6') {
					bw.append("-");
					is369 = true;
				}
				if (cur.charAt(c) == '9') {
					bw.append("-");
					is369 = true;
				}
			}
			if (!is369) {
				bw.append(cur + " ");
			} else {
				bw.append(" ");
			}

		}
		bw.flush();
		bw.close();
		br.close();

	}
}
