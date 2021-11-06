package todobase.todolistapplication;

public class ItemManager {
    //utility class method
    private ItemManager(){
        throw new IllegalStateException("Utility class");
    }

    //initialize the private item number variable
    private static int itemNumber = 0;

    //get method
    public static int getItemNumber(){
        return itemNumber;
    }

    //set method
    public static void setItemNumber(int newNum){
        //set the current item number to the new number
        itemNumber = newNum;
    }
}
