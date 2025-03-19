// question 1 : Product price management

class Product
{
   void main()
   {

        int a = ProductId;
        String b = ProductName ;
        Double c = Price;

    }

}

// question 2: Create a java program that reads array size and elements from the user  , then attempts to
//             access an element based on specified index . Handel exception like ArrayIndexOutOfBound
//             if index is out of range and input mismatch exception if invalid input is provided. ensure a finnaly block
//             display Array access completed

class InsufficientFundsException extends Exception{
    InsufficientFundsException(String Message){
        super(Message);

    }
}
class BankAccount{
    int accountNumber;
    double balance;
    public BankAccount(int accountNumber, double balance) {
        super();
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance) {
            throw new InsufficientFundsException("InsufficientFundsException"+ balance);
        }
        else {
            balance-=amount;
            System.out.println("Withdraw Sucsessfull");
        }

    }
    public void deposit(double amount) {
        balance+=amount;
        System.out.println("deposit sucsessfull");

    }
    public double getBalance() {
        return balance;
    }
}
public class Main1{
    public static void main(String args[]) {
        BankAccount b =new BankAccount(123456789,8000.50);
        try {
            b.withdraw(1000000);

        }
        catch(InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
        b.deposit(30000);
        try {
            b.withdraw(2000);

        }

        catch(InsufficientFundsException e){
            System.out.println(e.getMessage());

        }
    }

}

















// Question 3 : Inventory Management for retail store
//            * Add new item to the inventory
//            * Remove an item from inventory
//            * Find all items under specific category
//            * Find all items with a quantity below a given threshold





import java.util.ArrayList;
import java.util.Scanner;

// Product class to store item details
class Product {
    int id;
    String name;
    int quantity;
    double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Quantity: " + quantity + " | Price: $" + price;
    }
}

// Inventory class to manage products
class Inventory {
    private ArrayList<Product> products = new ArrayList<>();
    private int nextId = 1;

    // Add new product
    public void addProduct(String name, int quantity, double price) {
        products.add(new Product(nextId++, name, quantity, price));
        System.out.println("✅ Product added successfully!");
    }

    // Display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("⚠️ No products in inventory.");
            return;
        }
        System.out.println("\n📦 Inventory List:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Update product quantity
    public void updateStock(int id, int newQuantity) {
        for (Product p : products) {
            if (p.id == id) {
                p.quantity = newQuantity;
                System.out.println("✅ Stock updated successfully!");
                return;
            }
        }
        System.out.println("❌ Product not found!");
    }

    // Remove a product
    public void removeProduct(int id) {
        products.removeIf(p -> p.id == id);
        System.out.println("✅ Product removed successfully!");
    }
}

// Main class
public class RetailInventory {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n🔹 Retail Store Inventory 🔹");
            System.out.println(" Add Product");
            System.out.println(" View Products");
            System.out.println(" update Stock");
            System.out.println(" Remove Product");
            System.out.println(" Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    inventory.addProduct(name, quantity, price);
                    break;

                case 2:
                    inventory.displayProducts();
                    break;

                case 3:
                    System.out.print("Enter product ID to update stock: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    inventory.updateStock(id, newQty);
                    break;

                case 4:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeProduct(removeId);
                    break;

                case 5:
                    System.out.println(" Exiting... Have a great day!");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        }
    }
}


