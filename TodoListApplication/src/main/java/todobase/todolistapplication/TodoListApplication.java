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
    //method to load an arraylist from a text file
    public void listFromFile(File listFile) throws IOException {
        //create a fileReader to read through the values in the selected file, in a try statement
        try(BufferedReader reader = new BufferedReader(new FileReader(listFile))) {
            //clear the current list
            ItemList.clearList();

            //for loop to write the new list per item, max of exactly 100 items
            for(int i=0; i<100; i++) {
                //create a new Item
                Item addItem = new Item();

                //create a return mark for the reader
                reader.mark(10);

                //break the loop if the reader encounters whitespace on the next line
                String spaceTest = reader.readLine();
                if(spaceTest == null){break;}

                //reset the reader to the mark set earlier
                reader.reset();

                //write the three item parameters from the file to strings (desc, due, complete)
                String desc = reader.readLine();
                String due = reader.readLine();
                String completeString = reader.readLine();

                //initialize a boolean that is true if the complete string equals "complete"
                boolean completeBool = completeString.equals("complete");

                //add the parameters to the new Item
                addItem.setItem(desc, due, completeBool);

                //add the new Item to the current list
                ItemList.addItem(addItem);

                //readline to skip a line, as there is one blank line between items in a file
                //sonarlint doesn't like this, but I just need to skip the blank line between items in the file
                //I do this because I want the text file to also be easily readable by the user outside the app
                reader.readLine();
            }
        }
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