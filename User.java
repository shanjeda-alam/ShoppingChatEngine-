/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;

/**
 *
 * @author zoom
 */
public abstract class User {
        protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract String getWelcomeMessage();
}


