package interfaces;
import services.Cart;


public interface ICustomer {
    
    String getName();
    String getEmail();
    String getPhoneNumber();
    double getBalance();
    String getAddress();

    Cart getCart();
    void setBalance(double balance);
 
}
