package ua.viasat.www;

import java.util.Arrays;
import java.util.Scanner;

public class Homework2 {

	public static void task1_1() { // 1.отсортировать массив пузырьковым методом
		// вариант1
		int temp;
		int a[] = { 9, 5, 7, 6, 0, 3, 1, 2, 4, 8 };
		System.out.println("INPUT: " + Arrays.toString(a) + "\n");
		for (int k = 0; k < a.length - 1; k++) {
			for (int i = 0; i < a.length - 1 - k; i++) {
				if (a[i + 1] < a[i]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}
		System.out.println("OUTPUT: " + Arrays.toString(a) + "\n");
	}

	public static void task1_2() { // 1.отсортировать массив метод класса Arrays
		// вариант2
		int temp;
		int a[] = { 9, 5, 7, 6, 0, 3, 1, 2, 4, 8 };
		Arrays.sort(a);
		System.out.println(Arrays.toString(a) + "\n");
	}

	public static void task2(int year) {
		/*
		 * Создать массив из 12 элементов, каждый элемент является колличеством
		 * дней месяца. Заполнить масив в цикле минимальным количеством строк.
		 */
		System.out.println("Year: " + year + "\n");
		int a[] = new int[12];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = 31 - k;
			k = i < 6 ? (i % 2 != 0 ? 0 : 1) : (i % 2 == 0 ? 0 : 1);
			a[1] = year % 4 == 0 ? 29 : 28;
		}

		System.out.println(Arrays.toString(a) + "\n");
	}

	public static void task3_1(int n) {
		/*
		 * 3.В цикле вывести 21 число фибоначчи
		 */
		System.out.println("Кол-во чисел: " + n + "\n");
		int feb[] = new int[3];
		feb[0] = 0;
		feb[1] = 1;
		System.out.println(feb[0]);
		System.out.println(feb[1]);
		for (int i = 0; i < n - 2; i++) {
			feb[2] = feb[1] + feb[0];
			feb[0] = feb[1];
			feb[1] = feb[2];
			System.out.println(feb[2]);
		}
	}

	private static int[] swapper(int m[], int a, int b) {// ЗАМЕНА ЕЛЕМЕНТОВ
		int temp;
		temp = m[a];
		m[a] = m[b];
		m[b] = temp;
		return m;
	}

	public static void task4() {
		// 4. Сделать реверс масива

		int temp;
		int a[] = { 9, 5, 7, 6, 0, 3, 1, 2, 4, 8, 0 };
		System.out.println("INPUT: " + Arrays.toString(a) + "\n");
		for (int i = 0; i < a.length / 2; i++) {
			a = swapper(a, i, a.length - 1 - i);

		}
		System.out.println(Arrays.toString(a) + "\n");
	}

	public static void task5() {
		// 5. с клавиатуры вводится число, вывести - четное оно или не четное
		boolean flg = true;
		while (flg) {

			System.out.println("Введите число:>");
			Scanner reader = new Scanner(System.in);
			if (reader.hasNext("-?\\d*")) {
				flg = false;
				int n = reader.nextInt();
				if (n % 2 == 0) {
					System.out.println(n + " - Четное число");
				} else {
					System.out.println(n + " - Нечетное число");
				}

			} else {
				System.out
						.println("Некорректный ввод! Переменная должна быть числом!!");
			}
		}
	}

	public static void task6() {
		// 6. вводится латинская буква - гласная она или согласная
		boolean flg = true;
		while (flg) {

			System.out.println("Введите латинскую букву:>");
			Scanner reader = new Scanner(System.in);

			if (reader.hasNext("[a-z]")) {
				flg = false;
				String pattern = "/[aeiou]/i ";
				String n = reader.next();
				reader.close();
				if (n.matches(pattern)) {
					System.out.println(n + " - Гласная буква");
				} else {
					System.out.println(n + " - Согласная буква");
				}

			} else {
				System.out
						.println("Некорректный ввод! Переменная должна быть единственной латинской буквой!!");

			}

		}
	}

	public static void polindrom(String line) {

		System.out.println(line);
		char c[] = line.toCharArray();

		Boolean flg = true;
		for (int i = 0; i < c.length / 2; i++)

			if (Character.toUpperCase(c[i]) != Character.toUpperCase(c[c.length
					- 1 - i])) {

				flg = false;
				System.out.println(i + "-й и " + (c.length - i)
						+ "-й символы не совпадают!!!\"" + c[i] + "\"!=\""
						+ c[c.length - 1 - i] + "\"");
				break;
			}
		;

		System.out.println(flg);

	}

	public static void main(String[] args) {
		System.out
				.println("__________________________ЗАДАНИЕ 1 (ВАРИАНТ 1)_________________________"
						+ "\n");
		task1_1();
		System.out
				.println("__________________________ЗАДАНИЕ 1 (ВАРИАНТ 2)_________________________"
						+ "\n");
		task1_2();
		System.out
				.println("__________________________ЗАДАНИЕ 2_____________________________"
						+ "\n");
		task2(2014);
		System.out
				.println("__________________________ЗАДАНИЕ 3_____________________________"
						+ "\n");
		task3_1(21);
		System.out
				.println("__________________________ЗАДАНИЕ 4_____________________________"
						+ "\n");
		task4();
		System.out
				.println("__________________________ЗАДАНИЕ 5_____________________________"
						+ "\n");
		task5();
		System.out
				.println("__________________________ЗАДАНИЕ 6_____________________________"
						+ "\n");
		task6();
		polindrom("PoTOP");
	}
}
