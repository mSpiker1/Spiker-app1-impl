/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//class to define an arraylist or Items without having to create a temporary file to save the data to
public class ItemList {
    //util class
    private ItemList() {
        throw new IllegalStateException("Utility class");
    }

    //initialize the ArrayList of Items "itemsList"
    private static final ArrayList<Item> itemsList = new ArrayList<>();

    //initialize a temporary ArrayList "tempList" to be used to back up the main list when needed
    private static final ArrayList<Item> tempList = new ArrayList<>();

    //getter method for the Item list
    public static List<Item> getList() {
        return itemsList;
    }

    //method to add an item to the list
    public static void addItem(Item addItem) {
        //add addItem to the list
        itemsList.add(addItem);
    }

    //method to remove an item
    public static void removeItem(int itemNum) {
        //remove Item itemNum from the list
        itemsList.remove(itemNum);
    }

    //method to replace an item in the list with a new one
    public static void editItem(int itemNum, Item newItem) {
        //replace Item itemNum in the list with newItem
        itemsList.set(itemNum, newItem);
    }

    //method to clear the list
    public static void clearList() {
        //clear the main list
        itemsList.clear();
    }

    //method to change the boolean complete value of an Item
    public static void changeComplete(int itemNum) {
        //function to replace the current item with a copy of itself, but with the complete value swapped
        itemsList.get(itemNum).setItem(
                itemsList.get(itemNum).getDesc(), itemsList.get(itemNum).getDue(),
                !itemsList.get(itemNum).getComplete());
    }

    //getter, but only for a specific item from the list
    public static Item getItemNum(int itemNum) {
        //return Item itemNum - 1 (because we're dealing directly with the array that starts at 0) from the list
        //it's simpler to deal with in the controller classes between this and the displayed number in the gui
        return itemsList.get(itemNum - 1);
    }

    //method to sort the list when called
    public static void sortList() {
        //write a sort function to sort the array by the date string
        itemsList.sort(Comparator.comparing(Item::getDue));
    }

    //method to back up the main list to the temp list
    public static void backupList() {
        //clear the temp list
        tempList.clear();

        //copy the main list to the temp list
        tempList.addAll(itemsList);
    }

    //method to restore the main list from the temp list
    public static void restoreList() {
        //clear the main list
        itemsList.clear();

        //copy the temp list to the main list
        itemsList.addAll(tempList);
    }

    //method to remove all items with a specific complete bool value from the list, returns int to report errors
    public static int removeBool(boolean remove) {
        //if the main list is empty
        if (itemsList.isEmpty()) {
            //return error #1
            return 1;
        } else {
            //for loop to go through each item in the main list
            for (int i = itemsList.size() - 1; i >= 0; i--) {
                //if Item i's complete value equals remove
                if (itemsList.get(i).getComplete() == remove) {
                    //remove Item i from the list
                    itemsList.remove(i);
                }
            }

            //if the item list is now empty, return false
            if(itemsList.isEmpty()){
                //restore the main list
                restoreList();

                //return error #2
                return 2;
            } else{
                //otherwise, return 0
                return 0;
            }
        }
    }
}
