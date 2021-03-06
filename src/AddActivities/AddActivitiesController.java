/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddActivities;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class AddActivitiesController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TableView<Logic.TableList> activityTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //bind table height
        activityTable.prefHeightProperty().bind(scrollPane.heightProperty());
    }

}
