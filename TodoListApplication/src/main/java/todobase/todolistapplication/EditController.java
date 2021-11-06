/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements Initializable{
    //initialize textArea, date picker, checkbox, labels
    @FXML
    private TextArea descText;
    @FXML
    private DatePicker dueDate;
    @FXML
    private CheckBox completion;
    @FXML
    private Label errorLabel;
    @FXML
    private Label countLabel;
    @FXML
    private Button saveButton;

    //class to set parameters on launch
    public void initialize(URL location, ResourceBundle resources){
        //set the default text in the description to the current item's description so the user can edit it
        if(ItemManager.getItemNumber() > 0) {
            //set the description text area
            descText.setText(ItemList.getItemNum(ItemManager.getItemNumber()).getDesc());

            //set the due date text
            dueDate.getEditor().setText(ItemList.getItemNum(ItemManager.getItemNumber()).getDue());

            //set the complete checkbox value
            completion.setSelected(ItemList.getItemNum(ItemManager.getItemNumber()).getComplete());

            //set the character count
            countLabel.setText("Character count: " + descText.getText().length() + "/256");
        }
    }

    //instructions to update character count on keypress
    @FXML
    protected void onDescType(){
        //store the length of the description text in an int variable
        int length = descText.getText().length();

        //if length is greater than 256, display error and disable save button
        if (length > 256) {
            errorLabel.setText("Error: description must be between 1 and 256 characters");
            saveButton.setDisable(true);
        } else { //else reset error label and make sure save button is enabled
            errorLabel.setText("");
            saveButton.setDisable(false);
        }

        //update the character count label with the new number of characters
        countLabel.setText("Character count: " + length + "/256");
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

    @FXML
    protected void onSaveClick(){
        //create a new item
        Item newItem = new Item();

        //get description from user input, only if the input is between 1 and 256 chars
        String desc;
        if(1 <= descText.getText().length() && descText.getText().length() <= 256){
            desc = descText.getText();
        } else{
            //if the if statement fails, give an error and exit the method
            errorLabel.setText("Error: description must be between 1 and 256 characters");
            return;
        }

        //get due date from user input, only if there is a dueDate value
        String due;
        if(dueDate.getValue() != null) {
            due = dueDate.getValue().toString();
        } else due = "No due date";

        //assign item parameters based on user input from gui
        newItem.setItem(desc, due, completion.isSelected());

        //replace the old item with the new one
        ItemList.editItem(ItemManager.getItemNumber()-1, newItem);
    }
}
