package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-17
// SWEA D3 1209
public class Sum_0617 {

	static int arr[][] = new int[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) { // 테케 10개 고정

			int testcaseNum = Integer.parseInt(br.readLine());
			int sumarr[] = new int[202]; // 가로 100 + 세로 100 + 대각 2
			int sum, diagonal1 = 0, diagonal2 = 0, result = Integer.MIN_VALUE;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				sum = 0;
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j]; // 가로계산

					if (i == j) {
						diagonal1 += arr[i][j]; // 대각선1저장(좌상 우하)
					}
					if (i + j == 99) {
						diagonal2 += arr[i][j]; // 대각선2저장(우상 좌하)
					}
				}
				sumarr[i] = sum; // 가로계산 저장

			}
			sumarr[200] = diagonal1;
			sumarr[201] = diagonal2;

			// 세로계산
			for (int j = 0; j < 100; j++) {
				sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += arr[i][j];
				}
				sumarr[j + 100] = sum;
			}

			// 최대값 찾기
			for (int i = 0; i < sumarr.length; i++) {
				if (result < sumarr[i])
					result = sumarr[i];
			}

			bw.append("#" + testcaseNum + " " + result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

}
