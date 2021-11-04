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

    //create a boolean "dateTrack" to use to keep track of user interaction with the datepicker, set to false

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

            //add newItem to the list

            //set dateTrack to false

        //else

            //set errorLabel to TOOMANYITEMS
    }
}
