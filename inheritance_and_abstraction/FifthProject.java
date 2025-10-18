package inheritance_and_abstraction;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Product { //Self-explanatory what type of class this is
	
	// Fields
	protected String productId;
	protected String name;
	protected double price;
	protected int quantity;
	
	public Product(String productId, String name, double price, int quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	abstract void getProductInfo();
	
	// Getter
    public String getProductId() {
        return productId;
    }
    
    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            System.out.println("Price cannot be negative!");
    }
    
    // Getter
    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
        else
            System.out.println("Quantity cannot be negative!");
    }
    
    // Getter
    public int getQuantity() {
        return quantity;
    }
    
    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Restocked " + amount + ". Total quantity: " + quantity);
        } else {
            System.out.println("Restock amount must be positive.");
        	}
    }
}

class PerishableProduct extends Product {
	
	protected String expiryDate;
	
    public PerishableProduct(String productId, String name, double price, int quantity, String expiryDate) {
        super(productId, name, price, quantity);
        this.expiryDate = expiryDate;
    }
    
    @Override
    void getProductInfo() {
        System.out.println("Perishable Product - [ID: " + productId
        		+ ", Name: " + name
        		+ ", Price: " + price
        		+ ", Quantity: " + quantity
        		+ ", Expiry Date: " + expiryDate
        		+ "]");
    }
}

class NonPerishableProduct extends Product {
	
	protected String warrantyPeriod;
	
    public NonPerishableProduct(String productId, String name, double price, int quantity, String warrantyPeriod) {
        super(productId, name, price, quantity);
        this.warrantyPeriod = warrantyPeriod;
    }
    
    @Override
    void getProductInfo() {
        System.out.println("Non-Perishable Product - [ID: " + productId
        		+ ", Name: " + name
        		+ ", Price: " + price
        		+ ", Quantity: " + quantity
        		+ ", Warranty Period: " + warrantyPeriod
        		+ "]");
    }
}

//These are the Method overloading... methods.

public class FifthProject {

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		
		Product[] inventory = new Product[50];
		int productCount = 0;
		
		while (true) {
			System.out.println("(|Supermarket Inventory System|)");
			System.out.println("1. Add Perishable Product");
			System.out.println("2. Add Non-Perishable Product");
			System.out.println("3. Display Product Info");
			System.out.println("4. Restock Product");
			System.out.println("5. Exit");
			System.out.print("CHOOSE AN OPTION FROM 1 TO 5:");
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
            		System.out.print("Enter Product ID: ");
            		String productId = obj.nextLine();
            		
            		System.out.print("Enter Product Name: ");
            		String name = obj.nextLine();
            		
            		double price = 0;
            		System.out.print("Enter Product Price: ");
                    price = obj.nextDouble();
                    obj.nextLine();
                    
                    int quantity = 0;
            		System.out.print("Enter Product Quantity: ");
                    quantity = obj.nextInt();
                    obj.nextLine();
                    
                    System.out.print("Enter Product Expiry Date: ");
                    String expiryDate = obj.nextLine();
                    
                    inventory[productCount] = new PerishableProduct(productId, name, price, quantity, expiryDate);
                    productCount++;
            		
            		break;
            	case 2:
            		System.out.print("Enter Product ID: ");
            		String productId2 = obj.nextLine();
            		
            		System.out.print("Enter Product Name: ");
            		String name2 = obj.nextLine();
            		
            		double price2 = 0;
            		System.out.print("Enter Product Price: ");
                    price2 = obj.nextDouble();
                    obj.nextLine();
                    
                    int quantity2 = 0;
            		System.out.print("Enter Product Quantity: ");
                    quantity = obj.nextInt();
                    obj.nextLine();
                    
                    System.out.print("Enter Product Warranty Period: ");
                    String warrantyPeriod = obj.nextLine();
                    
                    inventory[productCount] = new NonPerishableProduct(productId2, name2, price2, quantity2, warrantyPeriod);
                    productCount++;
            		
            		break;
            	case 3:
                    if (productCount == 0) {
                        System.out.println("There is nothing in your inventory!");
                    } else {
                        System.out.println("Inventory:");
                        for (int i = 0; i < productCount; i++) {
                            Product a = inventory[i];
                            a.getProductInfo();
                        }
                        System.out.println("\nPress the Enter key to continue.");
                        obj.nextLine();
                    }

                    break;
            	case 4:
            		
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
