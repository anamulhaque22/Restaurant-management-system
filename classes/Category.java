package classes;
import interfaces.*;
public class Category implements ICategory {
    private String categoryName;
    private ItemInCategory[] itemInCategories;
    public void itemNumInCat(int x) {
        this.itemInCategories = new ItemInCategory[x];
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ItemInCategory getItemInCategory(String name){
        ItemInCategory item = null;
        for (int i = 0; i<itemInCategories.length; i++){
            if(itemInCategories[i] != null){
                if (itemInCategories[i].getName().equalsIgnoreCase(name)){
                    item = itemInCategories[i];
                    return item;
                }
            }
        }
        return item;
    }
    public void addItem(ItemInCategory f){
        for(int i = 0; i< itemInCategories.length; i++){
            if(itemInCategories[i]==null){
                itemInCategories[i] = f;
                break;
            }
        }
    }

    public void removeItem(String name){
        boolean flag = false;
        for(int i = 0; i< itemInCategories.length; i++){
            if(itemInCategories[i] != null){
                if(itemInCategories[i].getName().equals(name)){
                    itemInCategories[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Item is removed from "+getCategoryName());
        }else {
            System.out.println("Item is no found in "+ getCategoryName());
        }
    }

    //updatePrice() is used to update item price
    public void updatePrice(String itemName, float itemPrice){
        boolean flag = false;
        for(int i = 0; i<itemInCategories.length; i++){
            if(itemInCategories[i] != null){
                if(itemInCategories[i].getName().equals(itemName)){
                    itemInCategories[i].setPrice(itemPrice);
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Item price is updated");
        }else {
            System.out.println("Item is not found");
        }
    }

    public ItemInCategory getAllItem(String name){
        ItemInCategory itemR = null;
        for(int i = 0; i<itemInCategories.length; i++){
            if(itemInCategories[i] != null){
                if(itemInCategories[i].getName().equalsIgnoreCase(name)){
                    itemR = itemInCategories[i];
                    break;
                }
            }
        }
        return itemR;
    }


    // return true value if there is any item or false to check item is available for order
    public boolean haveItem(){
        boolean flag = false;
        for(int i = 0; i<itemInCategories.length; i++){
            if(itemInCategories[i] != null){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void showAllDetails(){
        System.out.println("\t\t\t"+getCategoryName());
        for(int i = 0; i<itemInCategories.length; i++){
            if(itemInCategories[i] != null){
                itemInCategories[i].showDetail();
            }
        }
    }

}
