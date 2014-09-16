package ua.viasat.www;

import java.util.Arrays;

public class Matrix {

	public static void mult(double[][] m, int pow) {

		// double [][] m = new double[3][3];
		int id = 1;

		// double[][] m = { { 1, 1 }, { 0, 1 } };
		double[][] temp = new double[m.length][m[0].length];
		double[][] res = new double[m.length][m[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				temp[i][j] = m[i][j];
			}
		}

		while (id < pow) {

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[0].length; j++) {
					res[i][j] = 0;
					for (int k = 0; k < m.length; k++) {

						res[i][j] += temp[i][k] * m[k][j];
					}

				}
			}

			id++;

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[0].length; j++) {
					temp[i][j] = res[i][j];
				}
			}

		}

		System.out.println(Arrays.deepToString(res));

	}

	public static void main(String[] args) {
		double[][] m = { { 1, 5, 1}, { 0, 1.2, 1 } };
		mult(m, 300);
	}
}
