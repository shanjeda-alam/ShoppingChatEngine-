/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;

/**
 *
 * @author zoom
 */
class Dress extends Product{
 
    
    public Dress(String name, double price) {
        super(name, price);
    }

    @Override
    public String getProductDetails() {
        return "Dress: " + name + " – $" + price;
    }
    
}
