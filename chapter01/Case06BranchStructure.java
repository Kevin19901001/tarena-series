package chapter01;

public class Case06BranchStructure {

	public static void main(String[] args) {
		// branch structure:
		// if:
		int condition1 = 5;
		if (condition1 < 2) {
			System.out.println(condition1);
			System.out.print("less than 2.");
		}
		
		// if ... else ...
		double totalPrice = 55.85;
		double money = 60.00;
		if (money >= totalPrice) {
			double change = money - totalPrice;
			System.out.println("Total: " + totalPrice + ", and Change: " + change);
		} else {
			System.out.println("The money is not enough!");
		}
		
		// else if:
		int score = 85;
		if (score < 60) {
			System.out.println("not qualified!");
		} else if (score >= 60 && score <90) {
			System.out.println("qualified");
		} else {
			System.out.println("very good");
		}
		
		// switch case:
		int number = 1;
		switch (number) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		default:
			System.out.println("sero");
		}
	}

}
