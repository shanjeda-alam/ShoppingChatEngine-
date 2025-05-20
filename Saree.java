/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;

/**
 *
 * @author zoom
 */
public class Saree extends Product {
    public Saree(String name, double price) {
        super(name, price);
    }

    @Override
    public String getProductDetails() {
        return "Saree: " + name + " – $" + price;
    }
}
