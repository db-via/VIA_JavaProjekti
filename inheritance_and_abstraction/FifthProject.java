package inheritance_and_abstraction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FifthProject {

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		
		while (true) {
			System.out.println("(|Supermarket Inventory System|)");
			System.out.println("1. Add Perishable Product");
			System.out.println("2. Add Non-Perishable Product");
			System.out.println("3. Display Product Info");
			System.out.println("4. Restock Product");
			System.out.println("5. Exit");
			int menu_choice = 0;
			
            try {
                menu_choice = obj.nextInt();
                obj.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("HALT! Please enter a NUMBER.");
                obj.next(); // Discards invalid input
                continue; // Goes back to main menu
            }
            
            switch (menu_choice) {
            	case 1:
            		System.out.println();
            		break;
            	case 5:
            		System.out.println("Bye!");
            		return;
            	default:
            		System.out.println("YOU STUPID!");
            		break;
            }
			
		}
	}
}
