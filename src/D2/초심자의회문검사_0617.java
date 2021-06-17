package D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-17
// SWEA D2 1989
public class 초심자의회문검사_0617 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine().trim();
			int len = str.length();
			char start = str.charAt(0);
			char end = str.charAt(len - 1);
			boolean check = true;

			for (int l = 0; l < len / 2; l++) {
				if (start == end) {
					start = str.charAt(l + 1);
					end = str.charAt(len - l - 2);
				} else {
					check = false;
					break;
				}
			}
			if (check)
				bw.append("#" + t + " 1\n");
			else
				bw.append("#" + t + " 0\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}

}
