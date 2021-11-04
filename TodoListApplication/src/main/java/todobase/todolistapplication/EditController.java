package todobase.todolistapplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    //instructions to set gui parameters on scene load
    public void initialize(URL location, ResourceBundle resources){
        //if the current Item Number is greater than 0

            //set the description textArea to display the current Item's description

            //set the due date to display the current Item's due date

            //set the complete checkbox to be checked or unchecked based on the current Item's status

            //update the character count to match the new description text's length
    }

    //instructions for when date picker is interacted with
    @FXML
    protected void onDateClick(){
        //set dateTrack to true
    }

    //instructions for when "back" button is clicked
    @FXML
    protected void onBackClick(){
        //set the scene of the current stage the launchScreen with the title "To Do List Manager"
    }

    //instructions for "clear date" button
    @FXML
    protected void onClearClick(){
        //clear the text in due date field and set the date value to null
    }

    //instructions for updating the character count on keypress
    @FXML
    protected void onDescType(){
        //write the length of the string from the textArea to an int length

        //if length > 256

            //display TOOMANYCHAR error

        //else set errorLabel to ""

        //update the character count label to "Character count: " + length + "/256"
    }

    //instructions for "save" button
    @FXML
    protected void onSaveClick(){
        //if list size != 100

            //create a new Item "newItem"

            //create a new string "desc"

            //if the text length from the textArea <= 256

                //set desc to the textArea text

            //else

                //display TOOMANYCHARS error and end the method

            //create a string "due"

            //if the value in the date picker is not null

                //set due to the value in the date picker as a string

            //else

                //set due to "No due date"

            //assign newItem parameters from the obtained user input

            //clear user input from gui fields and reset character count to 0

            //replace current Item in the list with newItem

        //else

            //set errorLabel to TOOMANYITEMS
    }
}
