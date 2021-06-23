package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-23
// SWEA D3 1215
public class 회문1_0623 {
	static char board[][];
	static int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());
			int result = 0;
			board = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String line = br.readLine();
				for (int j = 0; j < 8; j++) {
					board[i][j] = line.charAt(j);
				}
			}
			if (length == 1) {
				result = 64; // 길이 1이면 그냥 전체임
			} else {
				String temp = "";

				// 가로 검사
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						boolean flag = true;
						for (int l = 0; l < length; l++) {
							if (j + l >= 8) {
								flag = false;
								break;
							}
							temp += board[i][j + l];
						}
						if (flag) {
							boolean isPalindrome = true;
							for (int l = 0; l < length / 2; l++) { // 회문 체크
								if (temp.charAt(l) != temp.charAt(temp.length() - l - 1)) {
									isPalindrome = false;
									break;
								}
							}
							if (isPalindrome)
								result++;

						}
						temp = "";

					}
				}

				// 세로 검사
				for (int j = 0; j < 8; j++) {
					for (int i = 0; i < 8; i++) {
						boolean flag = true;
						for (int l = 0; l < length; l++) {
							if (i + l >= 8) {
								flag = false;
								break;
							}
							temp += board[i + l][j];
						}
						if (flag) {
							boolean isPalindrome = true;
							for (int l = 0; l < length / 2; l++) { // 회문 체크
								if (temp.charAt(l) != temp.charAt(temp.length() - l - 1)) {
									isPalindrome = false;
									break;
								}
							}
							if (isPalindrome)
								result++;

						}
						temp = "";
					}
				}

			}
			bw.append("#" + t + " " + result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}
}
