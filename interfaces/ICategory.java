package interfaces;
import classes.*;
public interface ICategory {
    void addItem(ItemInCategory f);
    void removeItem(String name);
    void updatePrice(String itemName, float itemPrice);
}
