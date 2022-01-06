package interfaces;
import classes.*;
public interface IMenuCard {
    void addCategory(Category c);
    void removeCategory(String cName);
    void removeItemFromCategory(String cName,String iName);
    void showMenuCard();
}
