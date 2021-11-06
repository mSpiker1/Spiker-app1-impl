/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

        //create three strings containing "item 0", "item 1", and "item 2"
        String i1 = "item 0";
        String i2 = "item 1";
        String i3 = "item 2";

        //test if the first three items in the list's descriptions match the three strings, respectively
        assertEquals(ItemList.getItemNum(1).getDesc(), i1);
        assertEquals(ItemList.getItemNum(2).getDesc(), i2);
        assertEquals(ItemList.getItemNum(3).getDesc(), i3);

        //delete the txt file and then the test directory, clear the ItemList
        txt.delete();
        dir.delete();
        ItemList.clearList();
    }

    //test for listToFile
    @Test
    void toFileTest() throws IOException {
        //create a File object "dir" that leads to /test and a File object "txt" for a text file /test/testFile.txt
        File dir = new File("test");
        File txt = new File("test/testFile.txt");

        //create the test directory
        dir.mkdir();

        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //call listToFile with txt as the parameter
        ListManager.listToFile(txt);

        //set three strings equal to line 1, 5, and 9 of txt
        String line1 = Files.readAllLines(Paths.get("test/testFile.txt")).get(0);
        String line5 = Files.readAllLines(Paths.get("test/testFile.txt")).get(4);
        String line9 = Files.readAllLines(Paths.get("test/testFile.txt")).get(8);

        //test if the first line of the file says "item 0", the 5th line says "item 1", and the 9th line says "item 2"
        assertEquals("item 0", line1);
        assertEquals("item 1", line5);
        assertEquals("item 2", line9);


        //delete the text file, then the test directory, clear the ItemList
        txt.delete();
        dir.delete();
        ItemList.clearList();
    }

    //test for ItemList.getList
    @Test
    void getListTest(){
        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //create a new Item ArrayList equal to ItemList.getList()
        List<Item> testList = ItemList.getList();

        //test that the size of the list is equal to 3
        assertEquals(3, testList.size());

        //test that the descriptions of the three items in the list are "item 0", "item 1", and "item 2"
        assertEquals("item 0", testList.get(0).getDesc());
        assertEquals("item 1", testList.get(1).getDesc());
        assertEquals("item 2", testList.get(2).getDesc());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.addItem
    @Test
    void addTest(){
        //create a new Item "newItem" with parameters "item", "due", true"
        Item newItem = new Item();
        newItem.setItem("item", "due", true);

        //test if the current size of the main list is 0
        assertEquals(0, ItemList.getList().size());

        //call ItemList.addItem to add newItem to the list
        ItemList.addItem(newItem);

        //test if the current size of the main list is 1
        assertEquals(1, ItemList.getList().size());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.removeItem
    @Test
    void removeTest(){
        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //test that the current size of the main list is 3
        assertEquals(3, ItemList.getList().size());

        //call ItemList.removeItem to remove item 1
        ItemList.removeItem(1);

        //test that the current size of the main list is 2
        assertEquals(2, ItemList.getList().size());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.editItem
    @Test
    void editTest(){
        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //create a new Item "editItem" with parameters "edited item 0", "No due date", true
        Item editItem = new Item();
        editItem.setItem("edited item 0", "No due date", true);

        //test that ItemList.getItemNum(1).getDesc() is equal to "item 0"
        assertEquals("item 0", ItemList.getItemNum(1).getDesc());

        //call ItemList.editItem to replace item 0 with editItem
        ItemList.editItem(0, editItem);

        //test that ItemList.getItem(1).getDesc() is equal to "edited item 0"
        assertEquals("edited item 0", ItemList.getItemNum(1).getDesc());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.clearList
    @Test
    void clearTest(){
        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //test that the size of the main list is currently 3
        assertEquals(3, ItemList.getList().size());

        //call ItemList.clearList() to clear the list of all items
        ItemList.clearList();

        //test that the size of the main list is currently 0
        assertEquals(0, ItemList.getList().size());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.changeComplete
    @Test
    void changeCompleteTest(){
        //create a new Item "newItem" with parameters "item", "due", true
        Item newItem = new Item();
        newItem.setItem("item", "due", true);

        //add newItem to the main list with ItemList.addItem
        ItemList.addItem(newItem);

        //test that ItemList.getItem(1).getComplete() is true
        assertTrue(ItemList.getItemNum(1).getComplete());

        //call ItemList.changeComplete to change the completion value of Item 1
        ItemList.changeComplete(0);

        //test that ItemList.getItem(1).getComplete() is false
        assertFalse(ItemList.getItemNum(1).getComplete());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.getItemNum
    @Test
    void getItemTest(){
        //create a new Item "newItem" with parameters "item", "due", true
        Item newItem = new Item();
        newItem.setItem("item", "due", true);

        //add newItem to the main list with ItemList.addItem
        ItemList.addItem(newItem);

        //create another new Item "testItem" equal to ItemList.getItemNum(1)
        Item testItem = ItemList.getItemNum(1);

        //test if testItem equals ItemList.getItemNum(1)
        assertEquals(testItem, ItemList.getItemNum(1));

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.sortList
    @Test
    void sortTest(){
        //create a new Item "newItem1" with parameters "item 3", "2021-12-27", true (latest due date)
        Item newItem1 = new Item();
        newItem1.setItem("item 3", "2021-12-27", true);

        //create a new Item "newItem2" with parameters "item 1", "2021-06-01", true (earliest due date)
        Item newItem2 = new Item();
        newItem2.setItem("item 1", "2021-06-01", true);

        //create a new Item "newItem3" with parameters "item 2", "2021-10-13", true (middlemost due date)
        Item newItem3 = new Item();
        newItem3.setItem("item 2", "2021-10-13", true);

        //add each item in the order newItem1, newItem2, newItem3 to the list with three instances of ItemList.addItem()
        ItemList.addItem(newItem1);
        ItemList.addItem(newItem2);
        ItemList.addItem(newItem3);

        //test that the items in the main list have the correct description order, "item 3", "item 1", and then "item 2"
        assertEquals("item 3", ItemList.getItemNum(1).getDesc());
        assertEquals("item 1", ItemList.getItemNum(2).getDesc());
        assertEquals("item 2", ItemList.getItemNum(3).getDesc());

        //call ItemList.sortList() to sort the list of items by date
        ItemList.sortList();

        //test that the items in the main list are now sorted in the correct order, "item 1", "item 2", then "item 3"
        assertEquals("item 1", ItemList.getItemNum(1).getDesc());
        assertEquals("item 2", ItemList.getItemNum(2).getDesc());
        assertEquals("item 3", ItemList.getItemNum(3).getDesc());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.backup and ItemList.restore
    //these two methods go together despite being separate, and it's difficult to test them without using both of them
    @Test
    void backupRestoreTest(){
        //for loop to loop three times
        for(int i=0; i<3; i++) {
            //create a new Item
            Item item = new Item();

            //set the item parameters
            item.setItem("item " + i, "No due date", true);

            //add the item to the main item list
            ItemList.addItem(item);
        }

        //test that size of the main list is 3
        assertEquals(3, ItemList.getList().size());

        //call ItemList.backupList()
        ItemList.backupList();

        //call ItemList.clearList()
        ItemList.clearList();

        //test that size of the main list is 0
        assertEquals(0, ItemList.getList().size());

        //call ItemList.restoreList()
        ItemList.restoreList();

        //test that size of the main list is 3 again
        assertEquals(3, ItemList.getList().size());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemList.removeBool
    @Test
    void removeBoolTest(){
        //create a new Item "newItem1" with parameters "item 1", "null", true
        Item newItem1 = new Item();
        newItem1.setItem("item 1", "null", true);

        //create a new Item "newItem2" with parameters "item 2", "null", true
        Item newItem2 = new Item();
        newItem2.setItem("item 2", "null", true);

        //create a new Item "newItem3" with parameters "item 3", "null", false
        Item newItem3 = new Item();
        newItem3.setItem("item 3", "null", false);

        //add all three items to the list with three instances of ItemList.addItem()
        ItemList.addItem(newItem1);
        ItemList.addItem(newItem2);
        ItemList.addItem(newItem3);

        //test that size of the main list is 3
        assertEquals(3, ItemList.getList().size());

        //call ItemList.removeBool(false)
        ItemList.removeBool(false);

        //test that size of the main list is 2
        assertEquals(2, ItemList.getList().size());

        //call ItemList.removeBool(true)
        ItemList.removeBool(true);

        //test that size of the main list is 0
        assertEquals(0, ItemList.getList().size());

        //clear the ItemList
        ItemList.clearList();
    }

    //test for ItemManager.getItemNumber and ItemManager.setItemNumber
    @Test
    void getAndSetItemNumTest(){
        //the default item number should be 0

        //test that ItemManager.getItemNumber() equals 0
        assertEquals(0, ItemManager.getItemNumber());

        //call ItemManager.setItemNumber(5) to set the item number to 5
        ItemManager.setItemNumber(5);

        //test that ItemManager.getItemNumber() equals 5
        assertEquals(5, ItemManager.getItemNumber());

        //reset ItemManager's ItemNumber to 0
        ItemManager.setItemNumber(0);
    }

    //test for all the functions in the Item class because they all just manage one item
    @Test
    void itemTest(){
        //create a new Item called "newItem"
        Item newItem = new Item();

        //call newItem.setItem("item", "due", true) to set the item's parameters
        newItem.setItem("item", "due", true);

        //test if newItem.getDesc() equals "item"
        assertEquals("item", newItem.getDesc());

        //test if newItem.getDue() equals "due"
        assertEquals("due", newItem.getDue());

        //test if newItem.getComplete() is true
        assertTrue(newItem.getComplete());
    }
}