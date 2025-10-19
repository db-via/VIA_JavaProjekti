package inheritance_and_abstraction;

// Imports for the Scanner and Input checking
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Product {
	// Abstract base class representing the general Product.
	// tl;dr this is the blueprint for Products.
	
	// Fields shared by both Product types
	protected String productId;
	protected String name;
	protected double price;
	protected int quantity;
	
	// Constructor to initialize Product data
	public Product(String productId, String name, double price, int quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Abstract method that will get implemented by a subclass.
	// For displaying Product info.
	abstract void getProductInfo();
	
	// Getter for the Product ID.
    public String getProductId() {
        return productId;
    }
    
    // Setter for Price with a check.
    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            System.out.println("Price cannot be negative!");
    }
    
    // Getter for the Price.
    public double getPrice() {
        return price;
    }
    
    // Setter for Quantity with a check.
    public void setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
        else
            System.out.println("Quantity cannot be negative!");
    }
    
    // Getter for the Quantity.
    public int getQuantity() {
        return quantity;
    }
    
    // Method for restocking Products.
    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Restocked " + amount + ". Total quantity of this product: " + quantity);
        } else {
            System.out.println("Restock amount must be positive.");
        	}
    }
}

// Subclass that represents Perishable Products.
class PerishableProduct extends Product {
	
	protected String expiryDate;
	
    public PerishableProduct(String productId, String name, double price, int quantity, String expiryDate) {
        super(productId, name, price, quantity); // Calls the Parent constructor.
        this.expiryDate = expiryDate;
    }
    
    // Overrides the abstract method from Product.
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

// Subclass that represents Non-Perishable Products.
class NonPerishableProduct extends Product {
	
	protected String warrantyPeriod;
	
    public NonPerishableProduct(String productId, String name, double price, int quantity, String warrantyPeriod) {
        super(productId, name, price, quantity); // Calls the Parent constructor.
        this.warrantyPeriod = warrantyPeriod;
    }
    
 // Overrides the abstract method from Product.
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

// This is the Main class that contains the Menu-driven supermarket inventory system.
// Switch cases, while loops, the usual.
public class FifthProject {

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		
		// Empty array that can store up to 50 Products.
		Product[] inventory = new Product[50];
		int productCount = 0; // Tracks the number of Products in stock.
		
		while (true) {
			System.out.println("(|Supermarket Inventory System|)");
			System.out.println("1. Add Perishable Product");
			System.out.println("2. Add Non-Perishable Product");
			System.out.println("3. Display Product Info");
			System.out.println("4. Restock Product");
			System.out.println("5. Exit");
			System.out.print("CHOOSE AN OPTION FROM 1 TO 5: ");
			int menu_choice = 0;
			
			// Validates user input as it must be a number.
            try {
                menu_choice = obj.nextInt();
                obj.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("HALT! Please enter a NUMBER.");
                obj.next(); // Discards invalid input
                continue; // Goes back to main menu
            }
            
            switch (menu_choice) {
            	case 1: // Case 1 adds a Perishable Product to the Inventory.
            	    if (productCount >= inventory.length) {
            	        System.out.println("Inventory is full!");
            	        break;
            	    }

        	    	System.out.print("Enter Product ID: ");
                	String productId = obj.nextLine();
                	
                	System.out.print("Enter Product Name: ");
                	String name = obj.nextLine();
            		
            		double price;
                	
                	// Loop to validate the Price.
            		while (true) {
            			try {
                        	System.out.print("Enter Product Price: ");
                            price = obj.nextDouble();
                            obj.nextLine();
                            break;
						} catch (InputMismatchException e) {
                            System.out.println("Invalid price! Please enter a valid number.");
                            obj.next(); // clear buffer
						}
            		}
                	
            		int quantity;
                	
            		// Loop to validate the Quantity.
                	while (true) {
            			try {
                            System.out.print("Enter Product Quantity: ");
                            quantity = obj.nextInt();
                            obj.nextLine();
                            break;
						} catch (InputMismatchException e) {
                            System.out.println("Invalid quantity! Please enter a valid number.");
                            obj.next(); // clear buffer
						}
            		}
                    
                    System.out.print("Enter Product Expiry Date: ");
                    String expiryDate = obj.nextLine();
                    
                    // This creates a new Perishable Product and stores it in the Inventory array.
                    inventory[productCount] = new PerishableProduct(productId, name, price, quantity, expiryDate);
                    productCount++;
            		
            		break;
            	case 2: // Almost the same as Case 1.
            		// However different versions of the variables so that there are not duplicate variable errors.
            		// Because both cases are in the same method.
            		System.out.print("Enter Product ID: ");
            		String productId2 = obj.nextLine();
            		
            		System.out.print("Enter Product Name: ");
            		String name2 = obj.nextLine();
            		
            		double price2 = 0;
            		
                	while (true) {
            			try {
                        	System.out.print("Enter Product Price: ");
                            price2 = obj.nextDouble();
                            obj.nextLine();
                            break;
						} catch (InputMismatchException e) {
                            System.out.println("Invalid price! Please enter a valid number.");
                            obj.next(); // clear buffer
						}
            		}
                    
                    int quantity2 = 0;
                    
                	while (true) {
            			try {
                            System.out.print("Enter Product Quantity: ");
                            quantity2 = obj.nextInt();
                            obj.nextLine();
                            break;
						} catch (InputMismatchException e) {
                            System.out.println("Invalid quantity! Please enter a valid number.");
                            obj.next(); // clear buffer
						}
            		}
                    
                    System.out.print("Enter Product Warranty Period: ");
                    String warrantyPeriod = obj.nextLine();
                    
                    inventory[productCount] = new NonPerishableProduct(productId2, name2, price2, quantity2, warrantyPeriod);
                    productCount++;
            		
            		break;
            	case 3: // Displays all of the Products that are in the Inventory.
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
            	case 4: // Restocks a specific Product in the Inventory.
            		if (productCount == 0) {
            			System.out.println("There is nothing in your inventory to restock!");
            			break;
            		}
            		System.out.print("Enter Product ID to restock: ");
            		String idToRestock = obj.nextLine();
            		int foundIndex = -1;
            		// Searches for the Product by ID.
            		for (int i = 0; i < productCount; i++) {
            			if (inventory[i].getProductId() == (idToRestock)) {
            				foundIndex = i;
            				break;
            			}
            		}
            		if (foundIndex == -1) {
            			System.out.println("Product with ID '" + idToRestock + "' not found.");
            		} else {
            			System.out.println("Found product:");
            			inventory[foundIndex].getProductInfo();
            			
            			// Validates the amount to restock.
            			while (true) {
            				try {
                    			System.out.println("Please input how much you want to restock:");
                    			int amount = obj.nextInt();
                    			inventory[foundIndex].restock(amount);
                    			break;
							} catch (InputMismatchException e) {
								System.out.println("Invalid quantity! Please enter a valid number.");
	                            obj.next(); // clear buffer
							}
            			}
            		}
            		break;
            	case 5:
            		// It's time to end it!
            		System.out.println("Bye!");
            		return;
            	default:
            		// What's 9 + 10?
            		System.out.println("Please input a valid option!");
            		break;
            }
		}
	}
}
