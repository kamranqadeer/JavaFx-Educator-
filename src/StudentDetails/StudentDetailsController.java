/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentDetails;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class StudentDetailsController implements Initializable {

    @FXML
    private JFXTextField teacher_Name;
    @FXML
    private ComboBox<?> select_Activity;
    @FXML
    private TableView<?> Subject_Table;
    @FXML
    private ScrollPane scrol_Pane;
    @FXML
    private TableView<Logic.TableList> Detail_Table;
    @FXML
    private JFXButton delete_All;
    @FXML
    private JFXButton print_All;

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
