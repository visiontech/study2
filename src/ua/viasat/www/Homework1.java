package ua.viasat.www;

public class Homework1 {
 public static	double sum = 100;
 public static	double discount = 0;
 

	private static void getSum(Double sum) {
		 
	String id = String.valueOf(sum/100).substring(0,1);
	
	switch(id){
	case "0": discount=0;
	break;
	case "1": discount=0;
	break;
	case "2": discount=0;
	break;
	case "3": discount=3;
	break;
	case "4": discount=3;
	break;
	case "5": discount=5;
	break;
	case "6": discount=5;
	break;
	case "7": discount=5;
	break;
	case "-": discount=0; 
	sum=0.00; 
	System.out.println("������!!! ����� ������ ������ ����");
	break;
	default:discount=10;
	break;
	}
	
		System.out.println("����� � ������: "+sum*(1-discount/100)+" ���� ������: "+discount+"%");
}	
		
	private static void getSumIf(Double sum) {
				
		if(sum<300) {		
			discount = 0;
		}else if(sum<500){
			discount = 3;
		}else if(sum<800) {
			discount=5;
		}else discount = 10;
		double result = sum * (1-discount/100);
		System.out.println("����� � ������: "+ result + " ���� ������: " +discount+"%");
	}	
	
	public static void main(String[] args) {
	
		//getSumIf(799.00);
		getSum(-800.00);
	}	
	
}


