package main;

import java.util.ArrayList;

import models.CartItem;
import models.Customer;
import models.Product;
import services.Cart;
import services.CheckOut;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product>products = new ArrayList<Product>();

      Product p1 = new Product("Milk", 25.0, 50, true, true, 1.0, "01-01-2099");         // Shippable, Expirable, Not Expired
      Product p3 = new Product("Laptop", 1500.0, 10, true, false, 2.5, "");              // Shippable, Not Expirable
      Product p4 = new Product("Cheese Guide", 10.0, 100, false, true, 0.0, "01-01-2099"); // Not Shippable, Expirable, Not Expired
      Product p6 = new Product("E-Book", 50.0, 1000, false, false, 0.0, "");             // Not Shippable, Not Expirable
      Product p7 = new Product("Fresh Bread", 10.0, 20, true, true, 0.4, "15-07-2025");   // Shippable, Expirable, Not Expired
      Product p8 = new Product("Old Bread", 2.0, 100, false, false, 0.0, "");         // Not Shippable, Not Expirable
      Product p2 = new Product("Old Milk", 25.0, 50, true, true, 1.0, "01-01-2020");      // Shippable, Expirable, Expired
      Product p5 = new Product("Expired License", 5.0, 100, false, true, 0.0, "01-01-2020"); // Not Shippable, Expirable, Expired



  Customer Ahmed = new Customer(
                "Ahmed Mohab",
                "Ahmed@example.com",
                "01012345678",
                "Egypt",
                "Cairo",
                "Giza Governorate",
                "11511",
                "123 Haram Street",
                100000.00);


        Customer Momen = new Customer(
                "Momen Ehab",
                "momen@example.com",
                "01012345678",
                "Egypt",
                "Cairo",
                "Cairo Governorate",
                "11511",
                "123 Nile Street",
                1000.00);
        populateCart(Ahmed.getCart(), p1,p2,p3,p4,p5,p6,p7,p8);
        populateCart(Momen.getCart(), p1,p2,p3,p4,p5,p6,p7,p8);

        new CheckOut(Ahmed.getCart(), Ahmed);
         new CheckOut(Ahmed.getCart(), Momen);
  
    }   
 private static void populateCart(Cart cart, Product p1, Product p2, Product p3, Product p4, Product p5, Product p6, Product p7, Product p8) {
        cart.addProduct(new CartItem(p1, 4));
        cart.addProduct(new CartItem(p2, 2));
        cart.addProduct(new CartItem(p3, 1));
        cart.addProduct(new CartItem(p4, 10));
        cart.addProduct(new CartItem(p5, 3));
        cart.addProduct(new CartItem(p6, 3));
        cart.addProduct(new CartItem(p7, 3));
        cart.addProduct(new CartItem(p8, 0));
    }
}