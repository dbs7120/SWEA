package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-16
// SWEA D2 1204
public class 최빈수구하기_0616 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int testcaseNum = Integer.parseInt(br.readLine());

			int scoreMem[] = new int[101]; // 0점에서 100점 메모리
			int result = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				scoreMem[Integer.parseInt(st.nextToken())]++;
			}

			int cur = scoreMem[0];

			for (int i = 0; i < 101; i++) {
				if (cur <= scoreMem[i]) {
					cur = scoreMem[i];
					result = i;
				}

			}
			bw.append("#" + testcaseNum + " " + result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

}
