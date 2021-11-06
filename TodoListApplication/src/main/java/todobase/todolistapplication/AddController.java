/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class AddController {
    //initialize text area, date picker, completion checkbox, labels
    @FXML
    private Label countLabel;
    @FXML
    private TextArea descText;
    @FXML
    private DatePicker dueDate;
    @FXML
    private CheckBox completion;
    @FXML
    private Label errorLabel;

    //create a boolean "dateTrack to use to keep track of user interaction with the datepicker, set the false by default
    boolean dateTrack = false;

    @FXML
    protected void onDateClick(){
        dateTrack = true;
    }

    //instructions for when "back to main menu" button is clicked
    @FXML
    protected void onBackClick(){
        //set the scene of the current stage to launchScreen with the title "To Do List Manager"
        StageManager sm = new StageManager();
        sm.changeScene(0, "To Do List Manager");
    }

    //instructions for clear button
    @FXML
    protected void onClearClick(){
        //clear text in due date field and set date value to null
        dueDate.getEditor().setText("");
        dueDate.setValue(null);
    }

    //instructions for updating character count
    @FXML
    protected void onDescType(){
        //store the length of the description text in an int variable
        int length = descText.getText().length();

        //if length is greater than 256, display error
        if (length > 256) {
            errorLabel.setText("Error: description must be between 1 and 256 characters");
        } else errorLabel.setText("");

        //update the character count label with the new number of characters
        countLabel.setText("Character count: " + length + "/256");
    }

    @FXML
    protected void onSaveClick(){
        if(ItemList.getList().size() != 100) {
            //create a new item
            Item newItem = new Item();

            //get description from user input, only if the input is between 1 and 256 chars
            String desc;
            if (1 <= descText.getText().length() && descText.getText().length() <= 256) {
                desc = descText.getText();
            } else {
                //if the if statement fails, give an error and exit the method
                errorLabel.setText("Error: description must be between 1 and 256 characters");
                return;
            }

            //get due date from user input, only if there is a value
            String due;
            if (dueDate.getValue() != null) {
                due = dueDate.getValue().toString();
            } else due = "No due date";

            //assign item parameters based on user input from gui
            newItem.setItem(desc, due, completion.isSelected());

            //clear user input from gui fields
            descText.clear();
            dueDate.getEditor().clear();
            completion.setSelected(false);
            countLabel.setText("Character count: 0/256");

            //add the new item to the item arraylist, then reset dateTrack to false
            ItemList.addItem(newItem);
            dateTrack = false;
        } else errorLabel.setText("Error: List can only hold a maximum of 100 unique items");
    }
}
