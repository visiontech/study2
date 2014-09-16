package ua.viasat.www;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;

public class Homework3 {

	private static Scanner reader;

	private static char[] swapper(char m[], int a, int b) {// ЗАМЕНА ЕЛЕМЕНТОВ
		char temp;
		temp = m[a];
		m[a] = m[b];
		m[b] = temp;
		return m;
	}

	private static void printArr(char line[]) {
		System.out.println("\n` `  ` `  `  ` ` `");
		for (int i = 0; i < line.length; i++) {
			System.out.print(line[i] + " ");

		}
		System.out.print("\n═══════════════════");
	}

	public static void game() throws UnsupportedEncodingException,
			LineUnavailableException, InterruptedException {

		char line[] = { '☺', '_', '_', '_', '_', '_', '_', '_', '_', '_' };
		line[(int) ((Math.random() + 0.1) * 8)] = '+';
		int hp = 60;
		int fk_small = 20;
		int fk_large = 40;
		int fk_type = (((int) (Math.random() * 10)) % 4 == 0 ? 2 : 1);

		// System.out.println(fk_type);
		int id = 0;
		String inv = "empty";
		System.out.print("a <--    H/P: " + hp + " \nd -->" + "    Bag: "
				+ inv + "\n ͠͠ ͠ϟ ͠͠ ͠͠ϟ͠ ͠ ͠͠ ͠  ͠͠ϟ͠ ͠ ͠ ͠ϟ͠ ͠ ");

		printArr(line);
		while (id < line.length - 1) {

		

			reader = new Scanner(System.in);
			String read = reader.nextLine();
			if (read.matches("[d,D,В,в]") && id < line.length - 1) {
				if (line[id + 1] != '+') {

					swapper(line, id, id + 1);
					id++;
					Player.tone(500, 50, 0.1);

				} else {
					swapper(line, id, id + 1);

					inv = fk_type == 1 ? "small" : "large";
					line[id] = '_';
					id++;
					Player.tone(500, 50, 0.1);

					Player.playmelody1();
				}

			}
			if (read.matches("[1-2]") && inv != "empty") {

				switch (inv + read) {
				case "small1":
					hp += fk_small;
					inv = "empty";
					break;
				case "large2":
					hp += fk_large;
					inv = "empty";
					break;
				}
				Player.tone(500, 50, 0.1);

			}

			if (read.matches("[a,A,ф,Ф]") && id > 0) {
				swapper(line, id, id - 1);
				id--;
				Player.tone(500, 50, 0.1);

			}
			System.out.print("a <--    H/P: " + hp + " \nd -->" + "    Bag: "
					+ inv + "\n ͠͠ ͠ϟ ͠͠ ͠͠ϟ͠ ͠ ͠͠ ͠  ͠͠ϟ͠ ͠ ͠ ͠ϟ͠ ͠ ");

			printArr(line);

		}
		if (id == line.length - 1) {
			Thread.sleep(1000);
			System.out.println("\n\n\n\n\n" + "     Game Over!!!");
			Player.playmelody();
		}

	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////Квадратное
	// уравнение//////////////////////////////////////

	public static void calc() {
		double[] k = new double[3];
		char k_name[] = { 'a', 'b', 'c' };
		int i = 0;
		double x1 = 0, x2 = 0;
		System.out
				.println("Введите коефициенты a,b,c квадратного уравнения  (ax²+bx+c=0):");
		while (i < k.length) {
			System.out.println("Введите коефициент " + k_name[i] + ":>");
			Scanner reader = new Scanner(System.in);
			if (reader.hasNextDouble()) {
				k[i] = reader.nextDouble();
				i++;
			} else {
				System.out.println("Некорректный ввод! Переменная должна быть числом.");
			}

		}
		System.out.println(Arrays.toString(k));

		double D = Math.pow(k[1], 2) - 4 * k[0] * k[2];
		if (D > 0) {
			System.out.println("D = " + D+ " > 0;\n Уравнение имеет 2 дейтвительныz корня;");
			x1 = (-k[1] - Math.pow(D, 0.5)) / 2 * k[0];
			x2 = (-k[1] + Math.pow(D, 0.5)) / 2 * k[0];
		}
		if (D == 0) {
			System.out.println("D = " + D+ " > 0;\n Уравнение имеет 1 дейтвительныq корень;");
			x1 = x2 = -k[1] / 2 * k[0];
		}
		if (D < 0) {
			System.out.println("D = " + D+ " < 0;\n Корней на множестве действительных чисел нет;");
		}

		System.out.println("Ответ: x1 = " + x1 + "; x2: = " + x2 + ".");

	}

	public static void main(String[] args) throws LineUnavailableException,
			IOException, InterruptedException {
		//calc();
		 game();
	
	}
}
