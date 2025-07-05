package interfaces;

import java.util.ArrayList;

import models.CartItem;

public interface ICart {
    

    void addProduct(CartItem Product);

    void removeProduct(CartItem Product);

    double getTotalPrice();

    ArrayList<CartItem> getProducts();

    void clearCart();

    ArrayList<CartItem> getShippableItems();

    ArrayList<CartItem> getNotShippableItems();
        double getTotalWeight();

}
