package classes;
import interfaces.*;
public class MenuCard implements IMenuCard {
    private Category[] categories;
    private int numOfCate;
    public MenuCard(){
        categories = new Category[10];
    }
    public void addCategory(Category c){
        boolean flag = false;
        for(int i = 0; i<categories.length; i++){
            if(categories[i] == null){
                categories[i] = c;
                numOfCate++;
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("New Category is added");
        }
    }

    //getCategoryName return category name from menu card categories index wise
    public String getCategoryName(int cateIndex){
        return categories[cateIndex].getCategoryName();
    }

    public Category getCategory(int cateIndex){
        boolean flag = false;
        return categories[cateIndex];
    }
    public void showCategoryItem(int cateIndex){
        categories[cateIndex].showAllDetails();
    }

    // return true value if there is any Category or false to check category is available for order
    public boolean haveCategory(){
        boolean flag = false;
        for(int i = 0; i<categories.length; i++){
            if(categories[i] != null){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public int getNumOfCate(){
        return this.numOfCate;
    }
    public void removeCategory(String cName){
        boolean flag = false;
        for(int i=0; i<categories.length; i++){
            if(categories[i]!=null){
                if(categories[i].getCategoryName().equals(cName)){
                    categories[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Category is removed also item is removed from this category");
        }else {
            System.out.println("Category in not removed");
        }
    }

    public void removeItemFromCategory(String cName,String iName){
        for(int i = 0; i<categories.length; i++){
            if(categories[i] != null){
                if(categories[i].getCategoryName().equals(cName)){
                    categories[i].removeItem(iName);
                    break;
                }
            }
        }
    }

    public Category getCatReference(String catName){
        boolean flag = false;
        Category cat=null;
        for(int i = 0; i<categories.length; i++){
            if(categories[i] != null){
                if(categories[i].getCategoryName().equals(catName)){
                    cat = categories[i];
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Category is found");
        }else {
            System.out.println("Category is not found");
        }
        return cat;
    }
    public void showMenuCard(){
        for(int i = 0; i<categories.length; i++){
            if(categories[i] != null){
                categories[i].showAllDetails();
            }
        }
    }
}
