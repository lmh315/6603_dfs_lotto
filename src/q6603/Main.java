package q6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] S;

	public static void main(String[] args) throws IOException {
		int i, j;
		int[] index;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0) break;

			S = new int[k];
			index = new int[6];
			for (i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				if (i < 6)
					index[i] = i;
			}

			do {
				for (i = 0; i < 6; i++) {
					System.out.print(S[index[i]] + " ");
				}
				System.out.println();
			} while (next_combination(index, k, 6));
			System.out.println();
		}
	}

	public static boolean next_combination(int[] arr, int n, int r) {
		int i, j;

		i = arr.length - 1;

		while (arr[i] == n - r + i) {
			i--;

			if (i < 0)
				return false;
		}
		arr[i]++;

		for (j = i + 1; j < arr.length; j++) {
			arr[j] = arr[i] + j - i;
		}

		return true;
	}
}
