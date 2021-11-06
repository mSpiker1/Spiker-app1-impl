/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

//This should test every method I have that doesn't directly involve javafx gui functions or the application launch
class TodoListApplicationTest {
    //test for listFromFile
    @Test
    void fromFileTest() throws IOException {
        //create ListManager object
        ListManager lm = new ListManager();

        //create a File object "dir" that leads to /test and a File object "txt" for a text file /test/testFile.txt
        File dir = new File("test");
        File txt = new File("test/testFile.txt");

        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //create the test directory
        dir.mkdir();

        //call listToFile with txt as a parameter
        ListManager.listToFile(txt);

        //clear the main list
        ItemList.clearList();

        //call listFromFile with txt as a parameter, which should recreate the list
        lm.listFromFile(txt);

        //create three strings containing "item 0", "item 1", and "item 3"
        String i1 = "item 1";
        String i2 = "item 2";
        String i3 = "item 3";

        //test if the first three items in the list's descriptions match the three strings, respectively
        assertEquals(ItemList.getItemNum(1).getDesc(), i1);
        assertEquals(ItemList.getItemNum(2).getDesc(), i2);
        assertEquals(ItemList.getItemNum(3).getDesc(), i3);

        //delete the txt file and then the test directory
        txt.delete();
        dir.delete();
    }

    //test for listToFile
    @Test
    public void toFileTest(){
        //create a ListManager object

        //create a File object "dir" that leads to /test and a File object "txt" for a text file /test/testFile.txt

        //create the test directory

        //for loop to loop three times

        //create a new Item

        //set the item parameters:
        //desc = "item " + i
        //due = "No due date"
        //complete = true

        //add the item to the main item list

        //call listToFile with txt as the parameter

        //create a fileReader for txt

        //test if the first line of the file says "item 1", the 5th line says "item 2", and the 9th line says "item 3"

        //delete the text file, then the test directory

        //close the fileReader and the File objects
    }

    //test for ItemList.getList
    @Test
    public void getListTest(){
        //for loop to loop three times

        //create a new Item

        //set the item parameters:
        //desc = "item " + i
        //due = "No due date"
        //complete = true

        //add the item to the main item list

        //create a new Item ArrayList equal to ItemList.getList()

        //test that the size of the list is equal to 3

        //test that the descriptions of the three items in the list are "item 0", "item 1", and "item 2"
    }

    //test for ItemList.addItem
    @Test
    public void addTest(){
        //create a new Item "newItem" with parameters "item", "due", true"

        //test if the current size of the main list is 0

        //call ItemList.addItem to add newItem to the list

        //test if the current size of the main list is 1
    }

    //test for ItemList.removeItem
    @Test
    public void removeTest(){
        //for loop to loop three times

        //create a new Item

        //set the item parameters:
        //desc = "item " + i
        //due = "No due date"
        //complete = true

        //add the item to the main item list

        //test that the current size of the main list is 3

        //call ItemList.removeList to remove item 1

        //test that the current size of the main list is 2
    }

    //test for ItemList.editItem
    @Test
    public void editTest(){
        //for loop to loop three times

        //create a new Item

        //set the item parameters:
        //desc = "item " + i
        //due = "No due date"
        //complete = true

        //add the item to the main item list

        //create a new Item "editItem" with parameters "edited item 1", "No due date", true

        //test that ItemList.getItem(1).getDesc() is equal to "item 1"

        //call ItemList.editItem to replace item 1 with editItem

        //test that ItemList.getItem(1).getDesc() is equal to "edited item 1"
    }

    //test for ItemList.clearList
    @Test
    public void clearTest(){
        //for loop to loop three times

        //create a new Item

        //set the item parameters:
        //desc = "item " + i
        //due = "No due date"
        //complete = true

        //add the item to the main item list

        //test that the size of the main list is currently 3

        //call ItemList.clearList() to clear the list of all items

        //test that the size of the main list is currently 0
    }

    //test for ItemList.changeComplete
    @Test
    public void changeCompleteTest(){
        //create a new Item "newItem" with parameters "item", "due", true

        //add newItem to the main list with ItemList.addItem

        //test that ItemList.getItem(1).getComplete() is true

        //call ItemList.changeComplete to change the completion value of Item 1

        //test that ItemList.getItem(1).getComplete() is false
    }

    //test for ItemList.getItemNum
    @Test
    public void getItemTest(){
        //create a new Item "newItem" with parameters "item", "due", true

        //add newItem to the main list with ItemList.addItem

        //create another new Item "testItem" equal to ItemList.getItemNum(1)

        //test if testItem equals ItemList.getItemNum(1)
    }

    //test for ItemList.sortList
    @Test
    public void sortTest(){
        //create a new Item "newItem1" with parameters "item 3", "2021-10-27", true

        //create a new Item "newItem2" with parameters "item 1", "2021-06-01", true

        //create a new Item "newItem3" with parameters "item 2", "2021-12-13", true

        //add each item in the order newItem1, newItem2, newItem3 to the list with three instances of ItemList.addItem()

        //test that ItemList.getItemNum(1).getDesc() equals "item 3"
        //test that ItemList.getItemNum(2).getDesc() equals "item 1"
        //test that ItemList.getItemNum(3).getDesc() equals "item 2"

        //call ItemList.sortList()

        //test that ItemList.getItemNum(1).getDesc() equals "item 1"
        //test that ItemList.getItemNum(2).getDesc() equals "item 2"
        //test that ItemList.getItemNum(3).getDesc() equals "item 3"
    }

    //test for ItemList.backup and ItemList.restore
    //these two methods go together despite being separate, and it's difficult to test them without using both of them
    @Test
    public void backupRestoreTest(){
        //for loop to loop three times

        //create a new Item

        //set the item parameters:
        //desc = "item " + i
        //due = "No due date"
        //complete = true

        //add the item to the main item list

        //test that size of the main list is 3

        //call ItemList.backupList()

        //call ItemList.clearList()

        //test that size of the main list is 0

        //call ItemList.restoreList()

        //test that size of the main list is 3 again
    }

    //test for ItemList.removeBool
    @Test
    public void removeBoolTest(){
        //create a new Item "newItem1" with parameters "item 1", "null", true

        //create a new Item "newItem2" with parameters "item 2", "null", true

        //create a new Item "newItem3" with parameters "item 3", "null", false

        //add all three items to the list with three instances of ItemList.addItem()

        //test that size of the main list is 3

        //call ItemList.removeBool(false)

        //test that size of the main list is 2

        //call ItemList.removeBool(true)

        //test that size of the main list is 0
    }

    //test for ItemManager.getItemNumber and ItemManager.setItemNumber
    @Test
    public void getAndSetItemNumTest(){
        //the default item number should be 0

        //test that ItemManager.getItemNumber() equals 0

        //call ItemManager.setItemNumber(5) to set the item number to 5

        //test that ItemManager.getItemNumber() equals 5
    }

    //test for all the functions in the Item class because they all just manage one item
    @Test
    public void itemTest(){
        //create a new Item called "newItem"

        //call newItem.setItem("item", "due", true) to set the item's parameters

        //test if newItem.getDesc() equals "item"
        //test if newItem.getDue() equals "due"
        //test if newItem.getComplete() is true
    }
}