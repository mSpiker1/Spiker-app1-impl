/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Matthew Spiker
 */

package todobase.todolistapplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

//class to manage the main stage and its scenes
public class StageManager {
    //create the static stage object private to the class
    private static Stage mainStage = new Stage();

    //create an arraylist to hold the scenes from the fxml loaders
    private static final ArrayList<Scene> scenes = new ArrayList<>();

    //method to load all scenes to the arraylist
    public void setSceneList() throws IOException {
        //load fxml files
        FXMLLoader mainMenuFxml = new FXMLLoader(TodoListApplication.class.getResource("launchScreen.fxml"));
        FXMLLoader addFxml = new FXMLLoader(TodoListApplication.class.getResource("itemAdd.fxml"));
        FXMLLoader editFxml = new FXMLLoader(TodoListApplication.class.getResource("itemEditor.fxml"));

        //load scenes from fxml files
        scenes.add(new Scene(mainMenuFxml.load(), 600, 400));
        scenes.add(new Scene(addFxml.load(), 600, 400));
        scenes.add(new Scene(editFxml.load(), 600, 400));
    }

    //stage setter method
    public static void setStage(Stage stage){
        //load the main stage
        mainStage = stage;

        //set it to not be maximizable
        mainStage.setResizable(false);
    }

    //method to change the scene of the main stage
    public void changeScene(int sceneNum, String title){
        //clear the scene array
        scenes.clear();

        //reload the scene array (this is to ensure initialize methods in controllers are run every time) with try/catch
        try{setSceneList();}
        catch(IOException e) {e.printStackTrace();}

        //set the stage's scene to sceneNum, the title to title, and then show the stage
        mainStage.setScene(scenes.get(sceneNum));
        mainStage.setTitle(title);
        mainStage.show();
    }
}
