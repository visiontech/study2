package ua.viasat.www;

public class Homework1 {
	public static double sum = 100;
	public static double discount = 0;

	private static void getSum(Double sum) {

		String id = String.valueOf((int) (sum / 100));

		int mod = (int) (Math.abs((sum / 100)) / (sum / 100)); // sign calculation
		

		switch (mod) {
		case -1:
			discount = 0;
			sum = 0.00;
			System.out.println("ERROR!!! The sum must be  >=0");
		break;
		default:
			switch (id) {
			case "0":
				discount = 0;
				break;
			case "1":
				discount = 0;
				break;
			case "2":
				discount = 0;
				break;
			case "3":
				discount = 3;
				break;
			case "4":
				discount = 3;
				break;
			case "5":
				discount = 5;
				break;
			case "6":
				discount = 5;
				break;
			case "7":
				discount = 5;
				break;
			default:
				discount = 10;
				break;
			}
		}
		System.out.println("Итого к оплате: " + sum * (1 - discount / 100)
				+ " Ваша скидка: " + discount + "%");
	}

	private static void getSumIf(Double sum) {

		if (sum < 300) {
			discount = 0;
		} else if (sum < 500) {
			discount = 3;
		} else if (sum < 800) {
			discount = 5;
		} else
			discount = 10;
		double result = sum * (1 - discount / 100);
		System.out.println("Итого к оплате: " + result + " Ваша скидка: "
				+ discount + "%");
	}

	public static void main(String[] args) {

		//getSumIf(799.00);
		getSum(-4000.00);
	}

}
