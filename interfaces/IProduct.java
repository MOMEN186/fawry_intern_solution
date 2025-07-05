package interfaces;

public interface IProduct {   
     String getName();
     int getStockQuantity();
     double getPrice();
     boolean isShippable();
     String getDateOfExpiry();
     boolean isExpirable();
     String getID();

     boolean isExpired();
     void setStockQuantity(int quantity);
     double getWeight();
}
