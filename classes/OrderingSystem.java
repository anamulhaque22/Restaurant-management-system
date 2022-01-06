package classes;
import interfaces.*;

public class OrderingSystem implements IOrderingSystem {
    private static int orderNo = 0;
    private ItemInCategory orderItem[];
    private int quantity[];
    private int total;

    // constructor for  instantiation orderItem and quantity
    public OrderingSystem(){
        orderItem = new ItemInCategory[30];
        quantity = new int[30];
        orderNo++;
    }

    //getOrderNo() return the order number
    public int getOrderNo(){
        return this.orderNo;
    }

    //order() take order by using (ItemInCategory type), (int type) and insert order item and price in (orderItem[]) array and (quantity[]) array
    public void order(ItemInCategory item, int quNum){
        for(int i = 0; i<30; i++){
            if(orderItem[i] == item){
                quantity[i] += quNum;
                break;

            }else if(orderItem[i] == null && quantity[i] == 0){
                orderItem[i] = item;
                quantity[i] = quNum;
                break;
            }
        }
    }


    public void removeOrderdItem(String itemName){

    }

    //calculateTotal() calculate the total price of order item and return the total price
    public float calculateTotal(){
        for(int i = 0; i<30; i++){
            if(orderItem[i] != null && quantity[i] != 0){
                this.total+=orderItem[i].getPrice()*quantity[i];
            }
        }
        return total;
    }

    //showOrderDetails() print the details of order item
    public void showOrderDetails(){
        boolean flag = false;
        for(int i = 0; i<30; i++){
            if(orderItem[i] != null && quantity[i] != 0){
                System.out.println(orderItem[i].getName()+"\t\t\t"+orderItem[i].getPrice()+"X"+quantity[i]);
                flag = true;
            }
        }
        if(flag){
            System.out.println("---------------------------------------------------------------");
            System.out.println("Total                                             "+calculateTotal());
        }else {
            System.out.println("You didn't order anything. Please Order");
        }
    }
}
