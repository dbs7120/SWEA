package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-15
// SWEA D2 1974
public class 스도쿠검증_0615 {

	static int sudoku[][] = new int[9][9]; // 입력으로 들어오는 모든 숫자는 1~9 정수임

	// 3X3 체크
	// 성공시 true 실패시 false
	public static boolean checkSquare(int y1, int y2, int x1, int x2) {
		boolean check[] = new boolean[9];

		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				if (check[sudoku[i][j] - 1])
					return false;
				else
					check[sudoku[i][j] - 1] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		testcase: for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 가로줄
			for (int i = 0; i < 9; i++) {
				boolean check[] = new boolean[9];
				for (int j = 0; j < 9; j++) {
					if (check[sudoku[i][j] - 1]) {
						// 스도쿠 실패
						bw.append("#" + t + " 0\n");
						continue testcase;
					} else {
						check[sudoku[i][j] - 1] = true;
					}

				}
			}

			// 세로줄
			for (int i = 0; i < 9; i++) {
				boolean check[] = new boolean[9];
				for (int j = 0; j < 9; j++) {
					if (check[sudoku[j][i] - 1]) {
						// 스도쿠 실패
						bw.append("#" + t + " 0\n");
						continue testcase;
					} else {
						check[sudoku[j][i] - 1] = true;
					}

				}
			}

			// 정사각형 체크
			for (int i = 0; i < 3; i++) {
				if (!checkSquare(0, 3, i * 3, i * 3 + 3)) {
					bw.append("#" + t + " 0\n");
					continue testcase;
				}
				if (!checkSquare(3, 6, i * 3, i * 3 + 3)) {
					bw.append("#" + t + " 0\n");
					continue testcase;
				}
				if (!checkSquare(6, 9, i * 3, i * 3 + 3)) {
					bw.append("#" + t + " 0\n");
					continue testcase;
				}
			}

			bw.append("#" + t + " 1\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
