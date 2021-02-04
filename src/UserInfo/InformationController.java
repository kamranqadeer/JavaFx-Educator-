/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInfo;

import Logic.Dialogs;
import Logic.Validation;
import Logic.kk_Logic;
import Logic.picture;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import educator.sqlConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class InformationController implements Initializable {

    Validation validation = new Validation();
    picture picture = new picture();
    Dialogs dialogs = new Dialogs();
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String location = null,
            fileName;
    kk_Logic logic = new kk_Logic();
    String C2 = "",
            C3 = "",
            C4 = "",
            C5 = "",
            C6 = "";
    @FXML
    private ImageView close;
    @FXML
    private JFXTextField user_Name;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField code;
    @FXML
    private JFXTextField contact;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton button;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text5;
    @FXML
    private Text text4;
    @FXML
    private Text error_Text;
    @FXML
    private ImageView see;
    @FXML
    private Text user_Status;
    @FXML
    private Circle circle;
    @FXML
    private Circle icon_Circle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.check_Active();
        // TODO
        this.Validation();
        picture.uploadImage("Camera", icon_Circle);
    }

    @FXML
    private void close_On_Acc(MouseEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public boolean Validation() {
        boolean check = false;
        check = validation.UserName(user_Name, text1);
        check = validation.email(email, text2);
        check = validation.Contact_Code(code, text3);
        check = validation.Contact(contact, text4);
        check = validation.password(password, text5);
        return check;
    }

    public boolean validation_Call() {
        if (email.getText().isEmpty()) {
            text2.setText("Required field !");
            return false;
        } else if (code.getText().isEmpty()) {
            text3.setText("Required field !");
            return false;
        } else if (contact.getText().isEmpty()) {
            text4.setText("Required field !");
            return false;
        } else if (password.getText().isEmpty()) {
            text5.setText("Required field !");
            return false;
        } else {
            return true;
        }
    }

    public void check_Active() {
        try {
            rs = logic.getTable_Data("account", "Active", "C7", "C1");
            while (rs.next()) {
                C2 = rs.getString("C2");
                C3 = rs.getString("C3");
                C4 = rs.getString("C4");
                C5 = rs.getString("C5");
                C6 = rs.getString("C6");
                user_Name.setText(C2);
                user_Status.setText(C3);
                email.setText(C4);
                String temp[] = C5.split("-");
                code.setText(temp[0]);
                contact.setText(temp[1]);
                password.setText(C6);
                picture.uploadImage(C3 + "_" + C2, circle);

            }
        } catch (SQLException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void button_On_Clicked(ActionEvent event) {
        if (email.getText().equals(C4)
                && C5.equals(code.getText() + "-" + contact.getText())
                && password.getText().equals(C6)) {

            // get a handle to the stage
            Stage stage = (Stage) button.getScene().getWindow();
            // do what you have to do
            stage.close();
        } else {

            if (this.Validation() && this.validation_Call()) {
                try {
                    con = sqlConnection.ConnectDB();
                    String sql = "update account set C4='" + email.getText()
                            + "',C5='" + code.getText() + "-" + contact.getText()
                            + "',C6='" + password.getText()
                            + "' where C3='" + C3 + "'";
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    pst.execute();
                    pst.close();
                    con.close();

                    // get a handle to the stage
                    Stage stage = (Stage) button.getScene().getWindow();
                    // do what you have to do
                    stage.close();
                    dialogs.Notofication("Update", "Information is updated", "okay");
                } catch (SQLException ex) {
                    Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    @FXML
    private void see_On_Out(MouseEvent event) {
        text5.setText("");
    }

    @FXML
    private void see_On_In(MouseEvent event) {
        text5.setText(password.getText());
    }
    @FXML
    private void Change_Picture(MouseEvent event) {
        if (picture.UploadPicture(C3 + "_" + C2, circle)) {
            dialogs.Notofication("Save", "picture is updated", "okay");
        } else {
            dialogs.Notofication("Error", "Location is not selected", "Wrong");
        }
    }

}
