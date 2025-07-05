package models;
import interfaces.ICustomer;
import services.Cart;

public class Customer implements ICustomer {
     private String name = "";
     private String email = "";
     private String phoneNumber = "";
     private String Country = "";
     private String City = "";
     private String State = "";
     private String ZipCode = "";
     private String Address = "";
     private double balance = 0.0;
     private Cart cart;

     public Customer(String name, String email, String phoneNumber, String Country, String City, String State, String ZipCode, String Address, double balance) {
        this.ZipCode = ZipCode;
        this.City = City;
        this.Country = Country;
        this.State = State;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.cart = new Cart();
    }

    @Override
    public String getName() {
        return this.name;
    }
   @Override
   public String getPhoneNumber() {
       return this.phoneNumber;
   }
    @Override
    public double getBalance() {
        return this.balance;
    }
   @Override
   public String getEmail() {
       return this.email;
   }
   
   @Override
   public String getAddress() {
       String address = "Country: " + this.Country + "\n" + "City: " + this.City
               + "\n" + "State: " + this.State + "\n" + "Address: " + this.Address+"\n"+"ZipCode: "+this.ZipCode ;

       return address;
   }
   
   @Override
   public Cart getCart() {
       return this.cart;
   }
 
   @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
