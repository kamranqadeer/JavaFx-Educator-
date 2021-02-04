/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activity;

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
public class ActivityController implements Initializable {

    @FXML
    private TableView<?> Activity_Table;
    @FXML
    private ScrollPane scrol_Pane;
    @FXML
    private TableView<Logic.TableList> Detail_Table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //bind table height
        Detail_Table.prefHeightProperty().bind(scrol_Pane.heightProperty());
        // TODO
    }

}
