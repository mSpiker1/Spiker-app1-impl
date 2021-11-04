package todobase.todolistapplication;

import java.util.List;

//class to define an arraylist or Items without having to create a temporary file to save the data to
public class ItemList {
    //util class
    private ItemList(){
        throw new IllegalStateException("Utility class");
    }

    //initialize the ArrayList of Items "itemsList"

    //initialize a temporary ArrayList "tempList" to be used to back up the main list when needed

    //getter method for the Item list
    public static List<Item> getList(){return null;}

    //method to add an item to the list
    public static void addItem(Item addItem){
        //add addItem to the list
    }

    //method to remove an item
    public static void removeItem(int itemNum){
        //remove Item itemNum from the list
    }

    //method to replace an item in the list with a new one
    public static void editItem(int itemNum, Item newItem){
        //replace Item itemNum in the list with newItem
    }

    //method to clear the list
    public static void clearList(){
        //clear the main list
    }

    //method to change the boolean complete value of an Item
    public static void changeComplete(int itemNum){
        //write a function to replace the current item with a copy of itself, but with the complete value swapped
    }

    //getter, but only for a specific item from the list
    public static Item getItemNum(int itemNum){
        //return Item itemNum from the list
        return null;
    }

    //method to sort the list when called
    public static void sortList(){
        //write a sort function to sort the array by the date string
    }

    //method to back up the main list to the temp list
    public static void backupList(){
        //clear the temp list

        //copy the main list to the temp list
    }

    //method to restore the main list from the temp list
    public static void restoreList(){
        //clear the main list

        //copy the temp list to the main list
    }

    //method to remove all items with a specific complete bool value from the list, returns bool to use as a test in code
    public static boolean removeBool(boolean remove){
        //if the main list is empty

            //return false

        //else

            //for loop to go through each item in the main list

                //if Item i's complete value equals remove

                    //remove Item i from the list

            //return true
        return false;
    }
}
