package services;

import java.util.ArrayList;
import interfaces.ICart;
import models.CartItem;

public class Cart implements ICart {
    private ArrayList<CartItem> products;
    private double totalPrice;
    private double totalWeight = 0.0;
    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    @Override
    public void addProduct(CartItem product) {
        if (product.getProduct().getStockQuantity() == 0)
            return;
        this.products.add(product);
        this.totalPrice += product.getTotal();
        if((product.getProduct().isShippable()))this.totalWeight += product.getProduct().getWeight()*product.getQuantity();
    }

    @Override
    public void removeProduct(CartItem product) {
        if (products.remove(product)) {
            this.totalPrice -= product.getTotal();
        }
    }

    @Override
    public double getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public ArrayList<CartItem> getProducts() {
        return this.products;
    }

    @Override
    public void clearCart() {
        this.products.clear();
        this.totalPrice = 0.0;
        this.totalWeight = 0.0;
    }

    @Override
    public ArrayList<CartItem> getShippableItems() {
        ArrayList<CartItem> shippableItems = new ArrayList<>();

        for (CartItem item : products) {
            if (item.getProduct().isShippable()) {
                shippableItems.add(item);
            }
        }
        return shippableItems;
    }

    @Override
    public ArrayList<CartItem> getNotShippableItems() {
        ArrayList<CartItem> notShippableItems = new ArrayList<>();

        for (CartItem item : products) {
            if (!item.getProduct().isShippable()) {
                notShippableItems.add(item);
            }
        }

        return notShippableItems;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

}
