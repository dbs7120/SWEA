package D1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-15
// SWEA D1 2072
public class 홀수만더하기_0615 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int result;

		for (int t = 1; t <= T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) { // 문제 조건 => 10개의 수
				int temp = Integer.parseInt(st.nextToken());
				if (temp % 2 == 1)
					result += temp;
			}
			bw.append("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
