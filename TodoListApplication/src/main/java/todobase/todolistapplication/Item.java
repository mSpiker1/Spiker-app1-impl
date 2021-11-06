/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

//constructor class to define an Item
public class Item {
    //initialize Item components: description, dueDate, and completion value
    private String desc;
    private String due;
    private boolean complete;

    //Item value setter method
    public void setItem(String desc, String due, boolean complete){
        //set this.desc to desc, this.due to due, this.complete to complete
        this.desc = desc;
        this.due = due;
        this.complete = complete;
    }

    //Item value getter methods separated per parameter
    public String getDesc(){return desc;}

    public String getDue(){return due;}

    public boolean getComplete(){return complete;}
}
