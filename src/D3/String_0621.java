package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-21
// SWEA D3 1213
public class String_0621 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int testcaseNum = Integer.parseInt(br.readLine());
			String find = br.readLine();
			String str = br.readLine();
			int result = 0;
			boolean flag = true;

			for (int i = 0; i <= str.length() - find.length(); i++) {
				flag = true;
				if (str.charAt(i) == find.charAt(0)) {
					for (int j = 1; j < find.length(); j++) {
						if (flag && i + j < str.length() && str.charAt(i + j) != find.charAt(j))
							flag = false;

					}
					if (flag)
						result++;
				}
			}
			bw.append("#" + testcaseNum + " " + result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}

}
