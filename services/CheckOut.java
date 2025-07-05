package services;

import java.util.ArrayList;
import exceptions.CheckOutException;
import interfaces.IShippable;
import models.CartItem;
import models.Customer;
import models.Product;

public class CheckOut {

    private Cart cart;
    private Customer customer;

    public CheckOut(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;

        invoice();
    }

    public void invoice() {

        validateCart();
        validateStockAndExpiry();
        double weight = this.cart.getTotalWeight();
        double subTotal = this.cart.getTotalPrice();
        double shippingCost = calculateShippingCost(weight);
        double totalAmount = subTotal + shippingCost;
        validateBalance(totalAmount);
        updateBalance(totalAmount);
        PrintInvoice(subTotal, shippingCost, totalAmount);
        updateInventory();
        PrintShimpentNotice();
        ShippingService.send(collectShippableItems());
        printCheckoutReciept();

    }

    private void validateCart() {
        if (cart.getProducts().isEmpty()) {
            throw new CheckOutException("Cart is empty");
        }
    }

    private void validateBalance(double totalAmount) {
        if (customer.getBalance() < totalAmount) {
            throw new CheckOutException("Not Enough Balance");
        }
    }

    private void updateBalance(double totalAmount) {
        customer.setBalance(customer.getBalance() - totalAmount);
    }

    private void validateStockAndExpiry() {
        for (CartItem item : cart.getProducts()) {
            Product p = item.getProduct();
            if (item.getQuantity() > p.getStockQuantity()) {
                throw new CheckOutException("Not enough stock for: " + p.getName());
            }
            if (p.isExpirable() && p.isExpired()) {
                throw new CheckOutException("Product expired: " + p.getName());
            }
        }
    }

    void updateInventory() {
        for (CartItem item : cart.getProducts()) {
            Product p = item.getProduct();
            p.setStockQuantity(p.getStockQuantity() - item.getQuantity());
        }
    }

    private double calculateShippingCost(double weight) {
        return weight * 0.75;
    }

    private void PrintInvoice(double subTotal, double shippingCost, double totalAmount) {
        System.out.println("------------------");
        System.out.println("Subtotal " + subTotal);
        System.out.println("shippingCost " + shippingCost);
        System.out.println("Total " + totalAmount);
        System.out.println("Balance " + customer.getBalance());
        System.out.println("------------------");
    }

    private ArrayList<IShippable> collectShippableItems() {
        ArrayList<IShippable> items = new ArrayList<>();
        for (CartItem c : cart.getShippableItems()) {
            for (int i = 0; i < c.getQuantity(); i++) {
                items.add(c.getProduct());
            }
        }
        return items;
    }

    public double PrintShimpentNotice() {
        System.out.println("** Shipment notice **");
        double weight = 0.0;

        ArrayList<IShippable> shippableItems = new ArrayList<>();

        for (CartItem c : this.cart.getShippableItems()) {
            Product product = c.getProduct();
            double itemWeight = product.getWeight();
            if (c.getProduct().getStockQuantity() < c.getQuantity()) {
                throw new CheckOutException("Not Enough Stock for" + c.getProduct().getName());
            }
            int quantity = c.getQuantity();
            weight += itemWeight * quantity;
            System.out.println(quantity + " X " + product.getName() + " " + itemWeight);
            for (int i = 0; i < quantity; i++) {
                shippableItems.add(product);
            }
        }
        System.out.println("total package weight " + weight + "KG");
        ShippingService.send(shippableItems);

        return weight;
    }

    public void printCheckoutReciept() {
        System.out.println("** Checkout reciept **");
        for (CartItem c : this.cart.getNotShippableItems()) {
            System.out.println(c.getQuantity() + " X " + c.getProduct().getName());
        }
    }

}
