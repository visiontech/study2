package ua.viasat.www;

public class Homework1 {

	/**
	 * @param args
	 */
	
	//Text by me. Hey hey hey!
	public static void main(String[] args) {

		double sum = 100;
		int discount = 0;
	if(sum<300) {		
		discount = 0;
	}else if(sum<500){
		discount = 3;
	}else if(sum<800) {
		discount=5;
	}else discount = 10;
	
	double result = sum * (1-discount/100);
	
	System.out.println("Всего к оплате: "+ result + " Ваша скидка:" +discount+"%" );
	
	}	
	
}


