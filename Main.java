/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;

import java.util.Scanner;

/**
 *
 * @author zoom
 */
public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileLogger<String> chatLogger = new FileLogger<>();
        FileLogger<Order> orderLogger = new FileLogger<>();

        // Initialize the ShopBot and Customer interaction
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        ShopBot bot = new ShopBot();

        System.out.println("\nWelcome " + name + "! I'm ShopBot, here to assist you with your shopping.");
        System.out.println("You can ask about Sarees, Dresses, or Jewelry.\n(Type 'exit' to leave)\n");

        while (true) {
            System.out.print(name + ": ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("ShopBot: Thank you for visiting! Come again.");
                chatLogger.logToFile("orders.txt", "Chat ended by: " + name);
                break;
            }

            // Get the bot's response and print it
            String response = bot.respondTo(input);
            System.out.println("ShopBot: " + response);

            // Log the conversation to the file
            chatLogger.logToFile("orders.txt", name + ": " + input);
            chatLogger.logToFile("orders.txt", "ShopBot: " + response);
        }

        sc.close();
    }
}
