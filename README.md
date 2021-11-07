# Spiker-app1-impl

## Application usage

The ToDoListApplication I created is meant to create new or edit existing to do lists of 100 or less items,
with each item containing three parameters: an item description, and item due date, and a completion value
of either true or false (showed as "complete" or "incomplete" in the app). The application also features
a few extra bits of functionality to make editing and managing the to do list a smoother experience.

## Application functionality Guide

Format for this guide: 

################## MenuName #######################

# FunctionName - 
FunctionDescription

##################### Main Menu, "To Do List Manager" ###############################

# Select a new list (Button) -
Opens a file select window that allows you to select an existing list to load into the application.

# Add a new item (Button) -
Opens the Add New Item Menu (see Add a New Item).

# View full list (Button) -
opens a new window that displays the current full list of items, displaying their descriptions, dates, and
completion values all together.

# Show Complete Items (CheckBox) -
Checked by default. Unchecking this will prevent all completed items in the list from being displayed until the
box is checked again. This affects the list view window.

# Show Incomplete Items (CheckBox) -
Checked by default. Unchecking this will prevent all incomplete items in the list from being displayed until the
box is checked again. This affects the list view window.

# Search for an Item or # (TextField) - 
Allows you to type an item number to go directly to that item, or alternatively to search for an item by description.

# Item Number Label (Label) -
Displays the number of the currently displayed item.

# Item Description Label (Label) -
Displays the current item's descriptions (up to three lines, or 256 characters, of text).

# Item Due Date Label (Label) - 
Displays the current item's due date.

# Previous (Button) -
Click this button to go to the item before the item that is currently displayed (e.g. 10 -> 9) OR if you are at
the end of the current list, it will loop you around to the last item of the list.

# Next (Button) -
Click this button to go to the item after the item that is currently displayed (e.g. 10 -> 11) OR if you are at
the beginning of the current list, it will loop you around to the first item of the list.

# Remove Item (Button) -
Click this button to remove the currently displayed item from the list

# Edit Item (Button) -
This button will open the item edit menu with the currently displayed item's values loaded in for you to change
if you wish to do so (see Edit an Item).

# Total Items Label (Label) - 
Displays the total amount of items currently in the list

# Completed (CheckBox) -
This box is checked if the item is completed, and is unchecked if the item is incomplete. The box can be checked
or unchecked at any time if you wish to mark the current item as completed/incomplete.

# Clear all items from the list (Button) -
Clicking this will remove every item from the currently loaded list.

# Sort by date (Button) -
Clicking this will sort all the items in the current list by date in ascending order, with the items marked with
no due dates being sorted to the end of the list.

# Save (Button) - 
Clicking this will bring up a file select window where you can either overwrite an existing list, or save your
current list as a new one in the directory of your choosing.

################## Add a new Item ########################

# < Back to Main Menu (Button) -
Returns you to the main menu screen.

# Enter item description (TextField) - 
Enter text here to be the new item's description.

# Character count label (Label) -
Displays how many characters you have typed (note that item descriptions can only be a maximum of 256 characters).

# Enter item due date (optional) (DatePicker) -
Allows you to select a calendar date to save as the due date of the new item.

# Clear due date (Button) -
Clears the selected due date for the new item (if there is one).

# Item is complete (CheckBox) -
Allows you to set if the new item is complete (checked) or incomplete (unchecked)

# Save item (Button) -
Clicking this will add the item description TextField, item due date DatePicker, and Item is complete CheckBox values
to a new item at the end of the current list. It will also clear these fields so that you may create another new item
if you want to do so before returning to the main menu.

############################# Edit Item ###############################

# < Back to Main Menu (Button) -
Returns you to the main menu screen.

# Enter item description (TextField) - 
This will already have the item you chose to edit's description loaded. Edit or enter new text here to be the new item's 
description.

# Character count label (Label) -
Displays how many characters you have typed (note that item descriptions can only be a maximum of 256 characters).

# Enter item due date (optional) (DatePicker) -
This will already have the item you chose to edit's date set to it. You can change the due date or the item or clear it
and leave it blank using the Clear due date button.

# Clear due date (Button) -
Clears the selected due date for the new item (if there is one).

# Item is complete (CheckBox) -
This will already be checked or unchecked based on the complete/incomplete value of the item you chose to edit. You can also
check or uncheck it to change that value.

# Save item (button) -
Clicking this will replace the item you chose to edit's parameters (description, due date, complete/incomplete value) with
the parameters in the corresponding fields in the edit menu that you gave.