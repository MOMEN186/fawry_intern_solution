package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import interfaces.IProduct;
import interfaces.IShippable;

public class Product implements IProduct, IShippable {
    private String ID = "";
    private String name = "";
    private double price = 0.0;
    private int stockQuantity = 0;
    private boolean shippable;
    private boolean expirable;
    private double weight;
    private LocalDate expiryDate;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Product(String name, double price, int stockQuantity, boolean shippable, boolean expirable, double weight,
            String expiryDate) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.shippable = shippable;
        this.expirable = expirable;
        this.weight = weight;

        if (expirable) {
            try {
                this.expiryDate = LocalDate.parse(expiryDate, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid expiry date format for product ");
            }
        }
    }

    @Override
    public boolean isShippable() {
        return this.shippable;
    }

    @Override
    public boolean isExpirable() {
        return this.expirable;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStockQuantity() {
        return this.stockQuantity;
    }

    @Override
    public String getDateOfExpiry() {
        return "";
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean isExpired() {
        if (!expirable || expiryDate == null) {
            return false;
        }
        return LocalDate.now().isAfter(expiryDate);
    }
}
