package todobase.todolistapplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TodoController implements Initializable{
    //initialize labels, buttons, textFields, and checkboxes
    @FXML
    private Label descLabel;
    @FXML
    private Label dueLabel;
    @FXML
    private Label itemNumLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private Label extraDesc1;
    @FXML
    private Label extraDesc2;
    @FXML
    private Label itemCount;
    @FXML
    private TextField searchBar;
    @FXML
    private CheckBox incCheck;
    @FXML
    private CheckBox compCheck;
    @FXML
    private CheckBox completion;
    @FXML
    private Button listSelect;
    @FXML
    private Button addNew;
    @FXML
    private Button editItem;
    @FXML
    private Button saveList;

    //string constants for itemCount and error messages, so I don't have to retype them a bunch

    //initialize method; runs whenever the scene is loaded
    public void initialize(URL location, ResourceBundle resources){
        //if statement to check if the list is empty

            //if the list is not empty, check if the current Item number is 0

                //if the current Item is 0, set it to 1

            //change the currently displayed Item to the current Item Number from ItemManager

        //update the total item count
    }

    //instructions for incomplete checkbox
    @FXML
    protected void incompleteCheck(){
        //check if the box is being checked or unchecked

            //determine if the complete checkbox is already checked or not

                //if both are checked, restore the main list and set the item number to 1

                //enable the list editing buttons

            //else if complete is not checked while incomplete is being checked

                //restore the main list, then remove all complete items

                //update the item count and change the current Item to 1

        //else if incomplete is being unchecked

            //determine if the complete checkbox is already checked or not

                //if complete is already checked, back up the main list

                //try to remove all incomplete items from the list

                //display an error if the list is empty and end the method

                //otherwise, disable all list editing buttons

                //update item count and change current Item to 1

            //else if complete is not checked and incomplete is being unchecked

                //clear the entire list
    }

    //instructions for complete checkbox
    @FXML
    protected void completeCheck(){
        //check if the box is being checked or unchecked

            //check if incomplete is checked or unchecked

                //if both are checked, restore the main list

                //enable list editing buttons

                //update item count and change current Item to 1

            //else if incomplete is unchecked while complete is being checked

                //restore the main list, then remove all incomplete items

                //update the item count and change current Item to 1

        //else if the box is being unchecked

            //check if incomplete is checked or unchecked

                //if incomplete is checked when comp is being unchecked, backup the main list

                //try to remove all complete items from the list

                //check if the item list is empty, end method with error if it is empty

                //disable list editing buttons

                //update item count and change current Item to 1

            //else if incomplete is unchecked while complete is being unchecked

                //clear the entire list
    }

    //instructions for when "previous" is clicked
    @FXML
    protected void onPrevClick(){
        //check if the current item number is the beginning of the list

            //change the current item to the last item if at the beginning of the list

        //else if the list is empty

            //display NOLIST error message if the list is empty

        //else

            //change the current item to the one below it in the Item list
    }

    //instructions for when "next" is clicked
    @FXML
    protected void onNextClick(){
        //check if the list is empty

            //display error message if the list is empty

        //else if the current item is at the end of the list

            //change the current Item to 1

        //else

            //change the current Item to the one above it in the Item list
    }

    //instructions for when "clear all" is clicked
    @FXML
    protected void onClearClick(){
        //clear all Items from the list

        //update current item to -no Item to display- values and set total Items to 0
    }

    //instructions for when "select a new list" is clicked
    @FXML
    protected void onListSelectClick(){
        //create a new stage for a fileChooser

        //create an object to reference ListManager class

        //create a fileChooser and a File object to store the location of the chosen file

        //set starting directory of the fileChooser

        //launch the fileChooser in a new window

        //call the listFromFile method from ListManager to replace the current list with the new one from the file

        //reset the currently displayed Item to 1 and update the total item count
    }

    //instructions for when "save" is clicked
    @FXML
    protected void onSaveClick(){
        //check if the Item list is empty

            //if the list is empty, display the NOLIST error

        //else if the list is not empty

            //create a new stage

            //create a fileChooser object

            //set the fileChooser to default to a text file

            //set the starting directory of the fileChooser

            //open the stage and create a file object where the user wants

            //call the listToFile method with the previously created file object as the parameter in a try statement
    }

    //instructions for when "remove" is clicked
    @FXML
    protected void onRemoveClick(){
        //big if else tree to catch any errors when removing an item ahead, this is just a comment and does not signify a line

        //if the current item list is empty

            //display the NOLIST error

        //else if the size of the list is 2

            //if current Item Number is 2

                //remove the Item 2 from the list

            //else if current Item Number is 1

                //remove Item 1 from the list

            //change current Item to 1

        //else if the size of the list is 1

            //clear the list

        //else if current Item is at the end of the list

            //change the current Item to one below

            //remove the item at the end of the list

        //else

            //remove the current Item from the list

            //change the current Item to the current Item Number

        //update the total Item count
    }

    //instructions for the search bar text field
    @FXML
    protected void onSearchPress(){
        //grab the input from the search bar as a string

        //create a boolean variable isNum and an int listSize that equals the size of the current list

        //open try statement

            //parse search string to an integer

            //if statement to determine if it is a number 1 - listSize

                //if it is a number 1 - listSize, set isNum to true

        //catch statement for NumberFormatException

            //set isNum to false

        //if isNum is false

            //for loop to go through every item until a hit is found or the end of the list is reached

                //if the current item contains the search string in its description

                    //if the string is an exact match

                        //change current Item to i and end the method

                    //change current Item to i

        //else if isNum is true

            //change the current Item to the search string as a parsed integer
    }

    //instructions for when "sort" is clicked
    @FXML
    protected void onSortClick(){
        //if the list is empty

            //display error NOLIST and end the method

        //call the sort list function in ItemList

        //update the current item to Item Number
    }

    //instructions for when "add" is clicked
    @FXML
    protected void onAddClick(){
        //set the scene to itemAdd with title "Add a new Item"
    }

    //instructions for when "edit" is clicked
    @FXML
    protected void onEditClick(){
        //if the list is empty

            //display NOLIST error

        //else

            //set the scene to itemEdit with the title "Edit an Item"
    }

    //instructions for when the "completed" checkbox is interacted with
    @FXML
    protected void onCompAction(){
        //if list is empty

            //display NOLIST error and set the checkbox to unchecked

        //else

            //change the boolean value of complete on the current Item by calling ItemList's changeComplete method
    }

    //method to change the currently displayed Item
    public void changeCurrentItem(int newItemNum){
        //change current ItemNumber to newItemNum

        //get the item from the item list

        //update the shown item using updateItem
    }

    //method to update the currently displayed Item's parameters
    public void updateItem(Item item, int itemNum){
        //if item description's length > 85 characters

            //set the item's description to a string "itemDesc" and replace newline characters with a space

            //if itemDesc.length > 172

                //split itemDesc into three strings d1, d2, and d3, of max 86 characters

                //set descLabel, extraDesc1, and extraDesc2 to d1, d2, and d3, respectively

            //else

                //split itemDesc into two strings d1 and d2, of max 86 characters

                //set descLabel and extraDesc1 to d1 and d2, respectively; set extraDesc2 to ""

        //else

            //set descLabel to the current item's description

            //set both extraDesc1 and extraDesc2 to ""

        //change all other relevant parameters (duedate, completion checkbox, item number, etc)
    }
}