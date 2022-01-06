import classes.Category;
import classes.ItemInCategory;
import classes.MenuCard;
import classes.Restaurant;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.out.println("Restaurant Management System");
        Restaurant restaurant = new Restaurant();
        Scanner sc = new Scanner(System.in);
        boolean chose = true;
        while (chose) {
            System.out.println("Here 3 option for You: \n");
            System.out.println("\t1. Admin");
            System.out.println("\t2. Customer");
            System.out.println("\t3. Exit the Application\n");
            System.out.print("What do you want to do? : ");
            int f = sc.nextInt();
            switch (f) {
                    System.out.print("\n\tEnter Admin username: ");
                    String adminUserName = sc.next();
                    System.out.print("\tEnter Admin password: ");
                    String adminPassword = sc.next();
                    if (restaurant.getAdmin().getAdminName().equals(adminUserName) && restaurant.getAdmin().getPassword().equals(adminPassword)) {
                        boolean choseAdmin = true;
                        while (choseAdmin) {
                            System.out.println("Here are Some Options for You: \n");
                            System.out.println("	1. Manage menu item");
                            System.out.println("	2. Go Back\n");
                            System.out.print("What do you want to do? : ");
                            int s = sc.nextInt();
                            switch (s) {
                                case 1:
                                    boolean adminCase1 = true;
                                    while (adminCase1) {
                                        System.out.println("Here are Some Options for You: \n");
                                        System.out.println("	1. Add Category and add item in Category");
                                        System.out.println("	2. Remove menu item");
                                        System.out.println("	3. Show menu card");
                                        System.out.println("	4. Update item price");
                                        System.out.println("	5. Go Back\n");
                                        System.out.print("What do you want to do? : ");
                                        int t = sc.nextInt();
                                        switch (t) {
                                            case 1:
                                                System.out.print("\n\tEnter Number of Category ");
                                                int cNum = sc.nextInt();
                                                //MenuCard menuCard = new MenuCard();
                                                for (int i = 1; i <= cNum; i++) {
                                                    Category category = new Category();
                                                    System.out.print("\tEnter Category name " + i + ": ");
                                                    sc.nextLine();
                                                    String cName = "";
                                                    cName = sc.nextLine();
                                                    System.out.print("\tEnter number of items that you want to add " + cName + " category: ");
                                                    int fItem = sc.nextInt();
                                                    category.setCategoryName(cName);
                                                    category.itemNumInCat(fItem);
                                                    for (int j = 1; j <= fItem; j++) {
                                                        System.out.print("\tEnter item name " + j + ": ");
                                                        sc.nextLine();
                                                        String fName = sc.nextLine();
                                                        System.out.print("\tEnter item price " + j + ": ");
                                                        float fPrice = sc.nextFloat();
                                                        ItemInCategory itemInCategory = new ItemInCategory();
                                                        itemInCategory.setName(fName);
                                                        itemInCategory.setPrice(fPrice);
                                                        category.addItem(itemInCategory);
                                                    }
                                                    restaurant.getMenuCard().addCategory(category);
                                                }
                                                break;

                                            case 2:
                                                System.out.println("You have Selected to remove an existing Category and Item in category");
                                                System.out.println("Press 1 to remove category and 2 for remove item from category: ");
                                                int check = sc.nextInt();
                                                if (check == 1) {
                                                    System.out.print("Enter Category name: ");
                                                    sc.nextLine();
                                                    restaurant.getMenuCard().removeCategory(sc.nextLine());
                                                } else if (check == 2) {
                                                    System.out.println("You have Selected to remove item from category");
                                                    System.out.print("Enter a categories name. Which category items do you want to remove: ");
                                                    String catName;
                                                    catName = sc.next();
                                                    Category cRef = restaurant.getMenuCard().getCatReference(catName);
                                                    if (cRef != null) {
                                                        cRef.showAllDetails();
                                                        String itemName;
                                                        System.out.println("Enter item name: ");
                                                        itemName = sc.next();
                                                        cRef.removeItem(itemName);
                                                    }
                                                }
                                                break;

                                            case 3:
                                                restaurant.getMenuCard().showMenuCard();
                                                break;

                                            case 4:
                                                System.out.println("You have Selected to update item price");
                                                System.out.print("Enter a categories name. Which category items price do you want to update: ");
                                                String catName;
                                                catName = sc.next();
                                                Category cRef = restaurant.getMenuCard().getCatReference(catName);
                                                if (cRef != null) {
                                                    cRef.showAllDetails();
                                                    String itemName;
                                                    float itemPrice;
                                                    System.out.println("Enter item name: ");
                                                    itemName = sc.next();
                                                    System.out.println("Enter item price: ");
                                                    itemPrice = sc.nextFloat();
                                                    cRef.updatePrice(itemName, itemPrice);
                                                }
                                                break;

                                            case 5:
                                                adminCase1 = false;
                                                break;
                                            default:
                                                System.out.println("Invalid Input");
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    choseAdmin = false;
                                    break;
                                default:
                                    System.out.println("Invalid Input");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Invalid Username or Password");
                    }

                    break;
                //end admin area

                case 2:
                    System.out.println("You have selected the user area");
                    boolean customer = true;
                    while (customer) {
                        System.out.println("Here some option for you");
                        System.out.println("\t1. Order");
                        System.out.println("\t2. Go back");
                        System.out.print("What do you want to do? : ");
                        int u = sc.nextInt();
                        switch (u) {
                            case 1:
                                System.out.println("You have selected to order");
                                restaurant.getMenuCard().showMenuCard();
                                if (restaurant.getMenuCard().haveCategory()) {
                                    System.out.println("Enter your name: ");
                                    sc.nextLine();
                                    restaurant.getUser().setUserName(sc.nextLine());
                                    for (int i = 0; i < restaurant.getMenuCard().getNumOfCate(); i++) {
                                        System.out.println("Do you want to order in " + restaurant.getMenuCard().getCategoryName(i) + "?");
                                        System.out.println("[Y]Yes [N]No [E]Exit");
                                        char checkU = sc.next().charAt(0);
                                        if (checkU == 'Y' || checkU == 'y') {
                                            boolean orderAgain = true;
                                            while (orderAgain) {
                                                System.out.println("===========================================================");
                                                restaurant.getMenuCard().showCategoryItem(i);
                                                System.out.println("===========================================================");
                                                System.out.print("Enter item name: ");
                                                sc.nextLine();
                                                String itemNameOrder = sc.nextLine();
                                                System.out.print("How many? ");
                                                int quantity = sc.nextInt();
                                                restaurant.getUser().getOrderingSystem().order(restaurant.getMenuCard().getCategory(i).getItemInCategory(itemNameOrder), quantity);
                                                System.out.println("Do you want to order in " + restaurant.getMenuCard().getCategoryName(i) + "?");
                                                System.out.println("[Y]Yes [N]No [E]Exit");
                                                char again = sc.next().charAt(0);
                                                if (again == 'Y' || again == 'y') {
                                                    orderAgain = true;
                                                } else if (again == 'N' || again == 'n') {
                                                    orderAgain = false;
                                                }
                                            }
                                        } else if ((checkU == 'N' || checkU == 'n') && i == i) {
                                            continue;
                                        }
                                    }
                                    restaurant.getUser().userDetails();
                                } else {
                                    System.out.println("There isn't any item for an order.");
                                }
                                break;
                            case 2:
                                customer = false;
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + u);
                        }
                    }
                    break;
                case 3:

                    System.out.println("You have selected to exit the application");
                    System.out.println("Thank you for using Sample Bank");
                    chose = false;
                    break;
                case 4:
                    System.out.println("Your username or password incorrect");
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }//while
    }//main
}
