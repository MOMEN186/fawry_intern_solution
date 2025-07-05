package models;
import interfaces.ICartItem;

public class CartItem implements ICartItem {
    
    private int qunatity;
    private double total;
    private Product product;
    
    
    public CartItem(Product product, int qunatity) {
        this.product = product;
        this.qunatity = qunatity;
        this.total = qunatity * product.getPrice();
    }
    
    @Override
    public Product getProduct() {
        return this.product;
    }
    
    @Override
    public void setQuantity(int qunatity) {
        this.qunatity = qunatity;
        this.total = qunatity * this.product.getPrice();
        
    }
    
    @Override
    public int getQuantity() {
        return this.qunatity;
    }
       
    @Override
    public double getTotal() {
        return this.total;
    }

    

}
