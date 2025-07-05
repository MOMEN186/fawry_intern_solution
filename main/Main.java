package main;

import models.CartItem;
import models.Customer;
import models.Product;
import services.Cart;
import services.CheckOut;

public class Main {

    public static void main(String[] args) {
        // Shippable, not expirable
        Product laptop = new Product("Laptop", 1500.00, 10, true, false, 2.5,"01-01-2099");
        // Shippable, not expirable — heavier and higher shipping cost
        Product milk = new Product("Milk - 1L", 25.00, 100, true, true, 1.0,"01-08-2025");
        // Shippable and expirable — perishable item
        Product ebook = new Product("E-Book: Java Basics", 50.00, 1000, false, false, 0.0,"01-01-2099");
        // Not shippable, not expirable — digital product
        Product freshBread = new Product("Fresh Bread", 10.00, 50, true, true, 0.4,"15-07-2025");
        // Shippable and expirable — light and cheap to ship

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
        populateCart(Ahmed.getCart(), milk, laptop, ebook, freshBread);
        populateCart(Momen.getCart(), milk, laptop, ebook, freshBread);

        new CheckOut(Ahmed.getCart(), Ahmed);
         new CheckOut(Ahmed.getCart(), Momen);
  
    }   
 private static void populateCart(Cart cart, Product milk, Product laptop, Product ebook, Product freshBread) {
        cart.addProduct(new CartItem(milk, 4));
        cart.addProduct(new CartItem(laptop, 2));
        cart.addProduct(new CartItem(ebook, 1));
        cart.addProduct(new CartItem(freshBread, 10));
    }
}