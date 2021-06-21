package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2021-06-21
// SWEA D3 1225
public class 암호생성기_0621 {

	static ArrayList<Integer> number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int testcaseNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			number = new ArrayList<>();
			for (int i = 0; i < 8; i++)
				number.add(Integer.parseInt(st.nextToken()));

			int desc = 1;
			while (true) {
				int temp = number.remove(0);
				temp -= desc;

				if (temp <= 0) {
					temp = 0;
					number.add(temp);
					break;
				} else {
					number.add(temp);
				}

				desc = (desc % 5) + 1;

			}

			bw.append("#" + testcaseNum + " ");
			for (int e : number)
				bw.append(e + " ");

			bw.append("\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
