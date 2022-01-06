package classes;

public class User {
    private String userName;
    private OrderingSystem orderingSystem = new OrderingSystem();

    //setUserName() set the name of user
    public void setUserName(String userName){
        this.userName = userName;
    }

    //getUserName() return the of user
    public String getUserName(){
        return this.userName;
    }

    //getOrderingSystem() return the reference of orderingSystem. some
    public OrderingSystem getOrderingSystem(){
        return orderingSystem;
    }
    public void userDetails(){
        System.out.println("Order Number: #"+orderingSystem.getOrderNo());
        System.out.println("Name:         "+getUserName());
        orderingSystem.showOrderDetails();
    }
}
