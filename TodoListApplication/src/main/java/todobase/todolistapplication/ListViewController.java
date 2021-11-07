package todobase.todolistapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    @FXML
    private TableColumn<Item, String> descCol;
    @FXML
    private TableColumn<Item, String> dateCol;
    @FXML
    private TableColumn<Item, Boolean> comCol;
    @FXML
    private TableView<Item> listTable;

    //initialize method to run when scene is loaded
    @Override
    public void initialize(URL location, ResourceBundle resources){
        //create an observable list from the current item list
        ObservableList<Item> obsItemList = FXCollections.observableArrayList();

        for(int i=1; i<=ItemList.getList().size(); i++) {
            obsItemList.add(ItemList.getItemNum(i));
        }

        //define the two String columns
        descCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("due"));

        //boolean is a bit more tricky, first grab the boolean value
        comCol.setCellValueFactory(new PropertyValueFactory<>("complete"));

        //found this bad boy on stackoverflow
        //I'm not 100% on how it works in all honesty, but I DO know that the sonarlint error is junk because TableCell
        //just has that many parents no matter how I code my program. That's just how the javafx hierarchy has it, not
        //me, so it can be safely ignored.
        comCol.setCellFactory(col -> new TableCell<>(){
            @Override
            protected void updateItem(Boolean item, boolean empty){
                super.updateItem(item, empty);
                if (empty) setText(null);
                else setText(Boolean.TRUE.equals(item) ? "Completed" : "Incomplete");
            }
        });


        //set the items from the list to be displayed on the tableview
        listTable.setItems(obsItemList);
    }
}