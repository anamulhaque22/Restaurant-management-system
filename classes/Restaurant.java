package classes;

public class Restaurant {
    private Admin admin = new Admin();
    private MenuCard menuCard = new MenuCard();
    private User user = new User();


    public Admin getAdmin() {
        return admin;
    }

    public MenuCard getMenuCard(){
        return menuCard;
    }

    public User getUser(){
        return user;
    }
}
