package interfaces;
import classes.*;

public interface IOrderingSystem {
    void order(ItemInCategory item, int quNum);
    float calculateTotal();
    void showOrderDetails();
}
