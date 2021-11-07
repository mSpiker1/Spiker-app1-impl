/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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

    //initialize string constants for itemCount and errors because sonarlint wants me to
    private static final String ITEMSTRING = "Total items: ";
    private static final String NOLIST = "Error: no list currently loaded";
    private static final String NOCOMPLETE = "Error: no complete items to display";
    private static final String NOINCOMPLETE = "Error: no incomplete items to display";
    private static final String INVALIDLIST = "Error: list is invalid, cannot load";
    private static final String INVALIDITEM = "Error: an item in that list is invalid, cannot load";
    private static final String MISSINGPARAM = "Error: an item in that list is missing values, cannot load";

    //initialize method to run when scene is loaded
    public void initialize(URL location, ResourceBundle resources){
        //if statement to check if the list has items
        if(!ItemList.getList().isEmpty()){
            //set item number to 1 if item number is not already set
            if(ItemManager.getItemNumber() <= 0){
                ItemManager.setItemNumber(1);
            }

            //change the currently displayed item to the current item number
            changeCurrentItem(ItemManager.getItemNumber());
        }

        //update the item count
        itemCount.setText(ITEMSTRING + ItemList.getList().size());
    }

    //instructions for incomplete checkbox
    @FXML
    protected void incompleteCheck(){
        //check if the box is being checked or unchecked
        if(incCheck.isSelected()){
            //determine if the complete checkbox is already selected or not
            if(compCheck.isSelected()){ //if both are checked
                //restore the main list and set the item number to 1
                ItemList.restoreList();
                changeCurrentItem(1);
                itemCount.setText(ITEMSTRING + ItemList.getList().size());

                //enable list editing buttons
                disableButtons(false);
            } else{ //if inc is being checked and comp is not
                //restore the main list, then remove all completed items
                ItemList.restoreList();
                ItemList.removeBool(true);

                //update item count and change current item to 1
                itemCount.setText(ITEMSTRING + ItemList.getList().size());
                changeCurrentItem(1);
            }
        } else{
            if(compCheck.isSelected()){ //if inc is deselected and comp is selected already
                //back up the main list
                ItemList.backupList();

                //remove all incomplete items from the list
                int verify = ItemList.removeBool(false);

                //ends method with error if list is empty, or list is only of one complete type
                if(verify == 1){
                    //set error label
                    errorLabel.setText(NOLIST);

                    //reset incomplete to checked
                    incCheck.setSelected(true);

                    //end method
                    return;
                } else if(verify == 2){
                    //set error label
                    errorLabel.setText(NOCOMPLETE);

                    //reset incomplete to checked
                    incCheck.setSelected(true);

                    //end method
                    return;
                }

                //disable all list editing buttons
                disableButtons(true);

                //update item count and change to item 1
                itemCount.setText(ITEMSTRING + ItemList.getList().size());
                changeCurrentItem(1);
            } else{ //if neither are checked when inc is deselected
                //clear the entire list
                ItemList.clearList();
                onClearClick();
            }
        }
    }

    //instructions for complete checkbox
    @FXML
    protected void completeCheck(){
        //check if the box is being checked or unchecked
        if(compCheck.isSelected()){
            if(incCheck.isSelected()){ //if both are checked when comp is being checked
                //restore the main list
                ItemList.restoreList();

                //enable list editing buttons
                disableButtons(false);

                //update item count and change current item to 1
                itemCount.setText(ITEMSTRING + ItemList.getList().size());
                changeCurrentItem(1);
            }else{ //if inc is unchecked when comp is being checked
                //restore the main list, then remove all incomplete items
                ItemList.restoreList();
                ItemList.removeBool(false);

                //update item count and change current item to 1
                itemCount.setText(ITEMSTRING + ItemList.getList().size());
            }
        } else{
            if(incCheck.isSelected()){ //if inc is checked when comp is being unchecked
                //backup the main list
                ItemList.backupList();

                //remove all completed items from the list
                int verify = ItemList.removeBool(true);

                //ends method with error if list is empty, or list is only of one complete type
                if(verify == 1){
                    //set error label
                    errorLabel.setText(NOLIST);

                    //reset incomplete to checked
                    compCheck.setSelected(true);

                    //end method
                    return;
                } else if(verify == 2){
                    //set error label
                    errorLabel.setText(NOINCOMPLETE);

                    //reset incomplete to checked
                    incCheck.setSelected(true);

                    //end method
                    return;
                }

                //disable list editing buttons
                disableButtons(true);

                //update item count and change current item to 1
                itemCount.setText(ITEMSTRING + ItemList.getList().size());
                changeCurrentItem(1);
            } else{ //if both are unchecked when comp is being unchecked
                //clear the entire list
                ItemList.clearList();
                onClearClick();
            }
        }
    }

    //method to disable or enable list editing buttons based on boolean parameter
    public void disableButtons(boolean onOff){
        completion.setDisable(onOff);
        listSelect.setDisable(onOff);
        addNew.setDisable(onOff);
        editItem.setDisable(onOff);
        saveList.setDisable(onOff);
    }

    //instructions for when "previous" button is clicked
    @FXML
    protected void onPrevClick(){
        //test to see if the current item number is the beginning of the list, or if the list is empty
        if(ItemManager.getItemNumber() == 1){
            //change item to final item if at the beginning of the list
            changeCurrentItem(ItemList.getList().size());
        } else if(ItemList.getList().isEmpty()){
            //display error message if the list is empty
            errorLabel.setText(NOLIST);
        } else {
            //change the current item to the one below it in the list
            changeCurrentItem(ItemManager.getItemNumber() - 1);
        }
    }

    //instructions for when "next" button is clicked
    @FXML
    protected void onNextClick(){
        //test to see if the current item number is the end of the list, or if the list is empty
        if(ItemList.getList().isEmpty()) {
            //display error message if the list is empty
            errorLabel.setText(NOLIST);
        } else if(ItemList.getList().size() == ItemManager.getItemNumber()){
            //move back to item 1
            changeCurrentItem(1);
        } else {
            //change the current item to the one above it in the list
            changeCurrentItem(ItemManager.getItemNumber() + 1);
        }
    }

    //instructions for when "Clear all items" button is pressed
    @FXML
    protected void onClearClick(){
        //clear objects from the list
        ItemList.clearList();

        //update current item
        descLabel.setText("No description available");
        extraDesc1.setText("");
        extraDesc2.setText("");
        dueLabel.setText("No due date");
        completion.setSelected(false);
        errorLabel.setText("");
        itemNumLabel.setText("Item #0");
        ItemManager.setItemNumber(0);
        itemCount.setText("Total items: 0");
    }

    //instructions for when "Select a new list" is clicked
    @FXML
    protected void onListSelectClick() throws IOException {
        //create a new stage
        Stage files = new Stage();

        //create an object to reference ListManager class
        ListManager lm = new ListManager();

        //create a fileChooser object and a File object to store the chosen file
        FileChooser selectList = new FileChooser();

        //set starting directory
        File startDir = new File("data");
        selectList.setInitialDirectory(startDir);

        //launch filechooser
        selectList.setTitle("Choose a list from your files");
        File newList = selectList.showOpenDialog(files);

        //call the listFromFile method from ListManager to replace the existing list with the new one from the file
        //set int errorNum to the methods return value to check for errors when loading the list
        int errorNum = lm.listFromFile(newList);

        //if any error is returned, follow this if statement
        if(errorNum != 0){
            //clear the item list
            ItemList.clearList();

            //display errors according to the return value and then end the method
            if(errorNum == 1){
                errorLabel.setText(INVALIDLIST);
                return;
            } else if(errorNum == 2){
                errorLabel.setText(INVALIDITEM);
                return;
            } else if(errorNum == 3){
                errorLabel.setText(MISSINGPARAM);
                return;
            }
        }

        //reset the currently displayed item to the first in the list to update the list as it is loaded
        changeCurrentItem(1);

        //update the item count
        itemCount.setText(ITEMSTRING + ItemList.getList().size());
    }

    //instructions for when the "Save" button is clicked
    @FXML
    protected void onSaveClick() {
        //if statement to test if the arraylist is not empty
        if(!ItemList.getList().isEmpty()) {
            //create a new stage
            Stage files = new Stage();

            //create a filechooser object
            FileChooser saveFile = new FileChooser();
            saveFile.setTitle("Save your list to a file");

            //set the filechooser to default to a text file
            saveFile.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Documents", "*.txt"));

            //set default filechooser starting directory
            File startDir = new File("data");
            saveFile.setInitialDirectory(startDir);

            //open the stage and create a file object where the user wants
            File file = saveFile.showSaveDialog(files);

            //call the listToFile method using the previously created file object
            try {
                ListManager.listToFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else errorLabel.setText(NOLIST); //displays error if list is empty, nothing to save
    }

    //instructions for when the "remove" button is clicked
    @FXML
    protected void onRemoveClick(){
        //this huge if else tree is to ensure no errors are met when removing an item
        if(ItemList.getList().isEmpty()){
            //display an error if there is no list currently loaded
            errorLabel.setText(NOLIST);
        } else if(ItemList.getList().size() == 2){
            //if the size of the list is 2, make sure the item number gets reset back to 1
            if(ItemManager.getItemNumber() == 2){
                //remove the previous item in the list (the one that remove was originally clicked on)
                //note this uses 1 instead of 2 because it's dealing directly with the arraylist, which starts at 0
                ItemList.removeItem(1);
            } else{
                //move to the second item in the list if on item #1
                changeCurrentItem(2);

                //remove the first item in the list, then update the remaining item to be item #1
                //note this uses 0 instead of 1 because it's dealing directly with the arraylist, which starts at 0
                ItemList.removeItem(0);
            }
            changeCurrentItem(1);
        } else if(ItemList.getList().size() == 1){
            //if the size of the list is 1, just call the clearList method
            onClearClick();
        } else if(ItemList.getList().size() == ItemManager.getItemNumber()){
            //move to the previous item in the list IF at the end of the list
            changeCurrentItem(ItemManager.getItemNumber() - 1);

            //remove the previous item in the list (the one that remove was originally clicked on)
            ItemList.removeItem(ItemManager.getItemNumber());
        } else{
            //remove the previous item in the list (the one that remove was originally clicked on)
            ItemList.removeItem(ItemManager.getItemNumber() - 1);

            //move to next item on the list
            changeCurrentItem(ItemManager.getItemNumber());
        }

        //update item count label
        itemCount.setText(ITEMSTRING + ItemList.getList().size());
    }

    //instructions for the search bar
    @FXML
    protected void onSearchPress(){
        //grab the input from the search bar as a string, create a boolean variable to use later and listSize int
        String search = searchBar.getText();
        boolean isNum;
        int listSize = ItemList.getList().size();

        //try to parse the string to a number
        try{
            //parse search string to an integer
            int stringNum = Integer.parseInt(search);

            //if statement to determine if it is a number 1-listSize
            isNum = stringNum <= listSize && stringNum >= 1;
        } catch(NumberFormatException e){
            isNum = false;
        }

        //algorithm to find the best match for an item, or just pull up an item number if isNum is true
        if(!isNum){
            //for loop to go through every item until a hit is found or the end of the list is reached
            for(int i=1; i <= listSize; i++){
                //test if item i's description contains the search string
                if(ItemList.getItemNum(i).getDesc().contains(search)){
                    //if the string is an exact match, set displayed item to item i and exit method
                    if(ItemList.getItemNum(i).getDesc().equals(search)){
                        changeCurrentItem(i);
                        return;
                    }

                    //change the current item to item i, then end the method
                    changeCurrentItem(i);
                }
            }
        } else{
            //change the current item to the search integer, then end the method
            changeCurrentItem(Integer.parseInt(search));
        }
    }

    //instructions for when the sort button is clicked
    @FXML
    protected void onSortClick(){
        //verify that the list is not empty, end method if it is
        if(ItemList.getList().isEmpty()){
            //set error label
            errorLabel.setText(NOLIST);

            //end method
            return;
        }

        //call the sort list function in ItemList
        ItemList.sortList();

        //update the current item
        changeCurrentItem(ItemManager.getItemNumber());
    }

    //instructions for when the add button is clicked
    @FXML
    protected void onAddClick(){
        //set the scene of the current stage to itemEditor with the title "Add a new Item"
        StageManager sm = new StageManager();
        sm.changeScene(1, "Add a New Item");
    }

    //instructions for when the edit button is clicked
    @FXML
    protected void onEditClick(){
        //if statement to ensure an item is selected first, otherwise displays an error message
        if(!ItemList.getList().isEmpty()) {
            //set the scene of the current stage to itemEditor with the title "Edit an Item"
            StageManager sm = new StageManager();
            sm.changeScene(2, "Edit an Item");
        } else errorLabel.setText(NOLIST);
    }

    //instructions for when the checkbox is interacted with
    @FXML
    protected void onCompAction(){
        if(ItemList.getList().isEmpty()){
            //display error message that no item is currently loaded
            errorLabel.setText(NOLIST);
            //sets the box to be unchecked
            completion.setSelected(false);
        }else {
            //calls the changeComplete method in ItemList class to swap the value of the current item's completion
            ItemList.changeComplete(ItemManager.getItemNumber() - 1);
        }
    }

    //method to change the currently displayed item
    public void changeCurrentItem(int newItemNum){
        //change the current item number
        ItemManager.setItemNumber(newItemNum);

        //get the item
        Item item = ItemList.getItemNum(ItemManager.getItemNumber());

        //update the shown item
        updateItem(item, ItemManager.getItemNumber());
    }

    //method to update the currently displayed item parameters
    public void updateItem(Item item, int itemNum){
        //if the itemDesc is 85 or more characters, split it up into two or three lines
        if(item.getDesc().length() > 85){
            //first remove any newline characters
            String desc = item.getDesc();
            desc = desc.replace("\n", " ");

            //split into either two or three lines
            if(item.getDesc().length() > 172){
                //split the string into three lines of max 86 characters
                String d1 = desc.substring(0, 86);
                String d2 = desc.substring(86, 172);
                String d3 = desc.substring(172);

                //set the description labels to the strings
                descLabel.setText(d1);
                extraDesc1.setText(d2);
                extraDesc2.setText(d3);
            }else{
                //split the string into two strings of max 86 characters
                String d1 = desc.substring(0, 86);
                String d2 = desc.substring(86);

                //set the description labels to the strings
                descLabel.setText(d1);
                extraDesc1.setText(d2);
                extraDesc2.setText("");
            }
        } else {
            descLabel.setText(item.getDesc());
            extraDesc1.setText("");
            extraDesc2.setText("");
        }

        //change all other parameters and reset the error label
        dueLabel.setText("Due: " + item.getDue());
        completion.setSelected(item.getComplete());
        itemNumLabel.setText("Item #" + itemNum);
        ItemManager.setItemNumber(itemNum);
        errorLabel.setText(" ");
    }
}