package assignment1;
import java.util.*;

public class MatrixOps {
	static int[][] read(Scanner sc, int r, int c) {
		int[][] m = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				m[i][j] = sc.nextInt();
		return m;
	}

	static void add(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + b[i][j] + " ");
			System.out.println();
		}
	}

	static void sub(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] - b[i][j] + " ");
			System.out.println();
		}
	}

	static void mul(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b[0].length; j++)
				for (int k = 0; k < b.length; k++)
					c[i][j] += a[i][k] * b[k][j];

		for (int[] r : c) {
			for (int x : r)
				System.out.print(x + " ");
			System.out.println();
		}
	}

	static void transpose(int[][] a) {
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++)
				System.out.print(a[j][i] + " ");
			System.out.println();
		}
	}

	static void checkSquare(int[][] a) {
		System.out.println(a.length == a[0].length);
	}

	static void checkDiagonal(int[][] a) {
		boolean f = true;
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				if (i != j && a[i][j] != 0)
					f = false;
		System.out.println(f);
	}

	static void checkIdentity(int[][] a) {
		boolean f = true;
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0))
					f = false;
		System.out.println(f);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(), c = sc.nextInt();
		int[][] a = read(sc, r, c);
		int[][] b = read(sc, r, c);

		add(a, b);
		sub(a, b);
		mul(a, b);
		transpose(a);
		checkSquare(a);
		checkDiagonal(a);
		checkIdentity(a);
	}

}