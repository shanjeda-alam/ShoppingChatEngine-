/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingchatbox1;
import java.io.*;
public class FileLogger<T> {
     public void logToFile(String fileName, T entry) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(entry.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
