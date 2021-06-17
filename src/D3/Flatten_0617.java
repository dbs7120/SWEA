package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-17
// SWEA D3 1208
public class Flatten_0617 {

	static int height[] = new int[100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			int maxidx = 0, minidx = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			for (int d = 0; d < dump; d++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				maxidx = 0; minidx = 0;
				for (int i = 0; i < 100; i++) {
					if (max < height[i]) {
						max = height[i];
						maxidx = i;
					}
					if (min > height[i]) {
						min = height[i];
						minidx = i;
					}
				}
				height[minidx]++;
				height[maxidx]--;
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < 100; i++) {
				if (max < height[i])
					max = height[i];
				if (min > height[i])
					min = height[i];

			}
			bw.append("#" + t + " " + (max - min) + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}
}
