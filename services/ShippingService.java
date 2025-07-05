package services;
import java.util.ArrayList;
import interfaces.IShippable;
public class ShippingService {
    public static void send(ArrayList<IShippable> items) {
        System.out.println("Sending the following items via ShippingService:");
        for (IShippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
        }
    }
}