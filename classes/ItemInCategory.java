package classes;
public class ItemInCategory {
    private String name;
    private float price;

    //setName() set item name
    public void setName(String name){
        this.name = name;
    }

    // getName() return the item name
    public String getName(){
        return name;
    }

    // setPrice() set the price of item
    public void setPrice(float price){
        this.price = price;
    }

    //getPrice() return the item price;
    public float getPrice(){
        return price;
    }

    //showDetails() print details of the item
    public void showDetail(){
        System.out.println("\t\t"+getName()+" \t "+getPrice());
    }
}