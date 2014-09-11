package ua.viasat.www;

import java.util.Arrays;
import java.util.Scanner;

public class Homework2 {

	public static void task1_1() { // 1.отсортировать массив пузырьковым методом
		// вариант1
		int temp;
		int a[] = { 9, 5, 7, 6, 0, 3, 1, 2, 4, 8 };
		for (int k = 0; k < a.length - 1; k++) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i + 1] < a[i]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

	public static void task1_2() { // 1.отсортировать массив пузырьковым методом
		// вариант2
		int temp;
		int a[] = { 9, 5, 7, 6, 0, 3, 1, 2, 4, 8 };
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void task2(int year) {
		/*
		 * Создать массив из 12 элементов, каждый элемент является колличеством
		 * дней месяца. Заполнить масив в цикле минимальным количеством строк.
		 */

		int a[] = new int[12];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = 31 - k;
			k = i < 6 ? (i % 2 != 0 ? 0 : 1) : (i % 2 == 0 ? 0 : 1);
			a[1] = year % 4 == 0 ? 29 : 28;
		}

		System.out.println(Arrays.toString(a));
	}

	public static void task3_1(int n) {
		/*
		 * 3.В цикле вывести 21 число фибоначи
		 */
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
		for (int i = 0; i < a.length / 2; i++) {
			a = swapper(a, i, a.length - 1 - i);

		}
		System.out.println(Arrays.toString(a));
	}
	
	
	public static void task5() {
		// 5. с клавиатуры вводится число, вывести - четное оно или не четное
		boolean flg = true;
		while (flg) {
			
			System.out.println("Введите число:>");
			Scanner reader = new Scanner(System.in);
			if (reader.hasNext("\\d")) {
				flg = false;
				int n = reader.nextInt();
				if(n%2==0){
					System.out.println(n+" - Четное число");
				} else {
					System.out.println(n+" - Нечетное число");
				}
						reader.close();
			} else {
				System.out.println("Некорректный ввод! Переменная должна быть числом!!");
			}
		}
	}

	public static void task6() {
		// 6. вводится латинская буква - гласная она или согласная
		boolean flg = true;
		while (flg) {
			
			System.out.println("Введите латинскую букву:>");
			Scanner reader = new Scanner(System.in);
			if (reader.hasNext("\\D")) {
				flg = false;
				String pattern = "/[aeiou]/i ";
				String n = reader.next();
				if(n.matches(pattern)){
					System.out.println(n+" - Гласная буква");
				} else {
					System.out.println(n+" - Согласная буква");
				}
						reader.close();
			} else {
				System.out.println("Некорректный ввод! Переменная должна быть латинской буквой!!");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("__________________________ЗАДАНИЕ 1 (ВАРИАНТ 1)_________________________");
		task1_1();
		System.out.println("__________________________ЗАДАНИЕ 1 (ВАРИАНТ 2)__________________________");
		task1_2();
		System.out.println("__________________________ЗАДАНИЕ 2_____________________________");
		task2(2014);
		System.out.println("__________________________ЗАДАНИЕ 3_____________________________");
		task3_1(21);
		System.out.println("__________________________ЗАДАНИЕ 4_____________________________");
		task4();
		System.out.println("__________________________ЗАДАНИЕ 5_____________________________");
		task5();
		System.out.println("__________________________ЗАДАНИЕ 6_____________________________");
		task6();
	}

}
