/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;

/**
 *
 * @author zoom
 */
public class Order {
     private String customerName;
    private String productDetails;

    public Order(String customerName, String productDetails) {
        this.customerName = customerName;
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Order by " + customerName + ": " + productDetails;
    }
}
