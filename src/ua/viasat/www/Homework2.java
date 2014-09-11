package ua.viasat.www;

import java.util.Arrays;

public class Homework2 {

	public static void task1() { // 1.отсортировать массив пузырьковым методом
		// вариант
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

	public static void task2(int year) {
		/*
		 * 2. Создать массив из 12 элементов, каждый элемент является
		 * колличеством дней месяца. Заполнить масив в цикле минимальным
		 * количеством строк.
		 */

		int a[] = new int[12]; 	int k = 0; 	
		for (int i = 0; i < a.length; i++) {
			a[i] = 31 - k; 	k = i < 6 ? (i % 2 != 0 ? 0 : 1) : (i % 2 == 0 ? 0 : 1); a[1] = year % 4 == 0 ? 29 : 28;
		}

		System.out.println(Arrays.toString(a));
	}

	public static void task3_1(int n) {
		/*
		 * 2. В цикле вывести 21 число фибоначчи вариант1
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

	public static void task4() {
		//4. Сделать реверс масива 
		
		
	}

	public static void main(String[] args) {
		System.out.println("__________________________ЗАДАНИЕ 1_____________________________");
		task1();
		System.out.println("__________________________ЗАДАНИЕ 2_____________________________");
		task2(2014);
		System.out.println("__________________________ЗАДАНИЕ 3_____________________________");
		task3_1(21);
	}

}
