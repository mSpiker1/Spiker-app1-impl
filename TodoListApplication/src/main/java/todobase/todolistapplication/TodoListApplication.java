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
    public void listFromFile(File listFile){
        //create a fileReader to read through the values in the selected file, in a try statement

            //clear the current list

            //for loop to write the new list per item, max of exactly 100 items

                //create a new Item

                //create a return mark for the reader

                //break the loop if the reader encounters whitespace on the next line

                //reset the reader to the mark set earlier

                //write the three item parameters from the file to strings (desc, due, complete)

                //initialize a boolean that is true if the complete string equals "complete"

                //add the parameters to the new Item

                //add the new Item to the current list

                //readline to skip a line, as there is one blank line between items in a file
    }

    //method to write an existing list to a text file
    public static void listToFile(File file){
        //create a fileWriter in a try statement

            //for loop to do through every item in the current arraylist

                //create a new Item equal to the ith Item from the current ItemList

                //write the desc and due parameters to the text file

                //if statement to write "complete" or "incomplete" based on the bool for the items completion

                //flush the writer at the end of each loop
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