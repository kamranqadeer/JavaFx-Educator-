/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class StudentController implements Initializable {

    @FXML
    private JFXTextField result_Field;
    @FXML
    private JFXButton okay;
    @FXML
    private Circle Circle_User;
    @FXML
    private Circle circle_Came;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView edit;
    @FXML
    private AnchorPane study_Pane;
    @FXML
    private AnchorPane activity_Pane;
    @FXML
    private AnchorPane Fee_Pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void oky_OnClicked(ActionEvent event) {
    }

    @FXML
    private void Change_Image(MouseEvent event) {
    }

    @FXML
    private void delete_Action(MouseEvent event) {
    }

    @FXML
    private void edit_Details(MouseEvent event) {
    }

    @FXML
    private void study_OnChange(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/StudentDetails/studentDetails.fxml"));
            study_Pane.getChildren().add(root);

        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void activity_Change(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Activity/activity.fxml"));
            activity_Pane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Fee_OnChange(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FeeStructure/feeStructure.fxml"));
            Fee_Pane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
