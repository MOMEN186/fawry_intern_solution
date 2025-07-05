package interfaces;
import models.Product;

public interface ICartItem {
   

    double getTotal();
    void setQuantity(int quantity);
    Product getProduct();

    int getQuantity();

  
}
