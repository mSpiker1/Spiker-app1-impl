/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;

public class TodoListApplication extends Application {
    //method to start the application window
    @Override
    public void start(Stage primaryStage) throws IOException {
        //class reference to class StageManager
        StageManager sm = new StageManager();

        //load the collection of scene files to the StageManager class with StageManager.setSceneList
        sm.setSceneList();

        //set the main stage in StageManager to the primary stage for the application
        StageManager.setStage(primaryStage);

        //set the stage to the launch scene with the title "To Do List Application"
        sm.changeScene(0, "To Do List Application");
    }
    //main method to launch the application
    public static void main(String[] args) {
        launch();
    }
}

//class to manage files
class ListManager{
    //method to load an arraylist from a text file, returns an int other than 0 to represent an error
    //error list:
    //1 - invalid list is not readable(general)
    //2 - invalid item in list
    //3 - an item or item parameter is missing from the list
    public int listFromFile(File listFile) throws IOException {
        //create a fileReader to read through the values in the selected file, in a try statement
        try(BufferedReader reader = new BufferedReader(new FileReader(listFile))) {
            //clear the current list
            ItemList.clearList();

            //for loop to write the new list per item, max of exactly 100 items
            for(int i=0; i<100; i++) {
                //create a new Item
                Item addItem = new Item();

                //if else to ensure a proper description is read, if item is invalid, return error # and close method
                String desc = reader.readLine();
                if(desc == null || desc.isEmpty()){ //if the item description is null
                    //if on the first for loop
                    if(i == 0){
                        //return 1, the list is not valid if item 1 has a blank description
                        return 1;
                    } else{
                        //if the next line has text, return missing value error
                        //note that I am not using a mark for this as I know the method is ending anyways
                        String temp = reader.readLine();
                        if(temp != null){
                            return 3;
                        } else{
                            //otherwise, break the for loop as the list has ended
                            break;
                        }
                    }
                } else if(desc.length() > 256){ //if the length of an item is greater than 256 characters
                    //return 2, the list has an invalid item and cannot be opened
                    return 2;
                }

                //if else to ensure a proper date is read, if item is invalid, return error # and close method
                String due = reader.readLine();
                //if due does not match yyyy-mm-dd, yyyy-m-dd, yyyy-mm-d, or yyyy-m-d format
                if(due == null){
                    //return 3, the due date for the item is missing
                    return 3;
                //if due does not match yyyy-mm-dd, yyyy-m-dd, yyyy-mm-d, or yyyy-m-d format, or is not "No due date"
                } else if (!due.matches("\\d{4}-\\d{2}-\\d{2}") && !due.equalsIgnoreCase("No due date")) {
                    //return 2, the list has an invalid date in an item and cannot be opened
                    return 2;
                } else if(due.equalsIgnoreCase("no due date")){
                    //if the due string is "no due date", set it to "No due date" for consistent casing across items
                    due = "No due date";
                }

                //if else to ensure a proper completion value is read
                String completeString = reader.readLine();
                //if completeString is null
                if(completeString == null){
                    //return 3, the complete value for the item is missing
                    return 3;
                } else if(!completeString.equalsIgnoreCase("complete") &&
                        !completeString.equalsIgnoreCase("incomplete")){
                    //if completeString is not "complete" or "incomplete", return 2 as the value is invalid
                    return 2;
                }

                //initialize a boolean that is true if the complete string equals "complete"
                boolean completeBool = completeString.equals("complete");

                //add the parameters to the new Item
                addItem.setItem(desc, due, completeBool);

                //add the new Item to the current list
                ItemList.addItem(addItem);

                //make sure there is a blank line between items to match the correct list format
                String blank = reader.readLine();

                //if blank is not a blank string on i > 0
                if(i > 0 && blank != null && !blank.isEmpty()) {
                    return 1;
                }
            }
        }
        //return 0 if no errors were encountered and the method runs as intended
        return 0;
    }

    //method to write an existing list to a text file
    public static void listToFile(File file) throws IOException {
        //create a fileWriter in a try statement
        try (FileWriter writer = new FileWriter(file)) {
            //for loop to do through every item in the current arraylist
            for(int i=1; i<=ItemList.getList().size(); i++) {
                //create a new Item equal to the ith Item from the current ItemList
                Item item = ItemList.getItemNum(i);

                //write the desc and due parameters to the text file
                writer.write(item.getDesc() + "\n");
                writer.write(item.getDue() + "\n");

                //if statement to write "complete" or "incomplete" based on the bool for the items completion
                if (item.getComplete()) {
                    writer.write("complete\n\n");
                } else writer.write("incomplete\n\n");

                //flush the writer at the end of each loop
                writer.flush();
            }
        }
    }
}

/*
example of text file structure:
item1 description
item1 duedate
complete

item2 description
item2 duedate
incomplete

item3 description
No due date
complete

etc.
 */