/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;

import java.util.*;

public class ShopBot extends Responder {
    private List<Saree> sarees;
    private List<Dress> dresses;
    private List<Jewelry> jewelryItems;
    private Scanner scanner;

    public ShopBot() {
        sarees = new ArrayList<>();
        dresses = new ArrayList<>();
        jewelryItems = new ArrayList<>();
        loadCatalog();
        scanner = new Scanner(System.in);
    }

    private void loadCatalog() {
        sarees.add(new Saree("Banarasi Silk Saree", 120.0));
        sarees.add(new Saree("Kanchipuram Designer Saree", 150.0));

        dresses.add(new Dress("Floral Gown", 89.99));
        dresses.add(new Dress("Anarkali Suit", 75.5));

        jewelryItems.add(new Jewelry("Gold Plated Necklace", 50.0));
        jewelryItems.add(new Jewelry("Kundan Earrings", 25.0));
    }

    @Override
    public String respondTo(String input) {
        String text = input.toLowerCase().trim();

        // Check for product category or specific product request
        if (text.contains("saree")) {
            return listProducts(sarees);
        } else if (text.contains("dress")) {
            return listProducts(dresses);
        } else if (text.contains("jewelry")) {
            return listProducts(jewelryItems);
        } else if (text.contains("i want saree") || text.contains("banarasi") || text.contains("kanchipuram")) {
            return askForDetails("Saree");
        } else if (text.contains("i want dress") || text.contains("floral gown") || text.contains("anarkali suit")) {
            return askForDetails("Dress");
        } else if (text.contains("i want jewelry") || text.contains("necklace") || text.contains("earrings")) {
            return askForDetails("Jewelry");
        } else if (text.contains("order")) {
            return "Please specify the product name to confirm your order.";
        } else if (text.contains("hello") || text.contains("hi")) {
            return "Hello! Ask about sarees, dresses, or jewelry!";
        } else {
            return "Sorry, I didn't understand that. Please ask about products or place an order.";
        }
    }

    // List all available products for a given category
    private String listProducts(List<? extends Product> productsList) {
        StringBuilder sb = new StringBuilder();
        for (Product product : productsList) {
            sb.append(product.getProductDetails()).append("\n");
        }
        return sb.length() > 0 ? sb.toString() : "No products available right now.";
    }

    // Asking for the user's details after an order
    public String askForDetails(String productType) {
        System.out.println("You have chosen: " + productType);
        System.out.print("Please provide your address: ");
        String address = scanner.nextLine();
        System.out.print("Please provide your contact number: ");
        String contactNumber = scanner.nextLine();

        // Ask for confirmation
        System.out.println("Please confirm your order: ");
        System.out.println("Product: " + productType);
        System.out.println("Address: " + address);
        System.out.println("Contact: " + contactNumber);
        System.out.print("Type 'confirm' to place the order or 'cancel' to make changes: ");
        
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("confirm")) {
            // Log the order to a file
            FileLogger<Order> orderLogger = new FileLogger<>();
            Order order = new Order("Customer", productType + " Address: " + address + " Contact: " + contactNumber);
            orderLogger.logToFile("orders.txt", order);

            return "Thank you! Your order has been confirmed. You will be contacted soon by the owner.";
        } else {
            return "Order not confirmed. Feel free to make changes and try again.";
        }
    }
}
