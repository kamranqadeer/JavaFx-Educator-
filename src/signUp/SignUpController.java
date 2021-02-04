/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signUp;

import educator.Educator;
import Logic.Data;
import Logic.Validation;
import Logic.kk_Logic;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import educator.sqlConnection;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class SignUpController implements Initializable {

    Validation validation = new Validation();
    Stage mainStage = new Stage();
    kk_Logic logic = new kk_Logic();
    Data data = new Data();
    Connection con = null;
    ResultSet rs = null;
    boolean check = false,
            admin = false;
    PreparedStatement pst = null;
    @FXML
    private JFXButton back;
    @FXML
    private Text com_Text;
    @FXML
    private ImageView keyIcon;
    @FXML
    private JFXPasswordField main_Password;
    @FXML
    private Text pin_Text;
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
    private ImageView close;
    @FXML
    private Text text1;
    @FXML
    private Text text3;
    @FXML
    private JFXButton sign_Up;
    @FXML
    private Text text2;
    @FXML
    private Text text5;
    @FXML
    private Text text4;
    @FXML
    private CheckBox admin_Check;
    @FXML
    private Text error_Text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        com_Text.setText(data.software_Develope);
        this.check_Account();
        this.Validation();

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

    public void check_Account() {
        String admin = logic.Check_Id("account", "C3", "Admin"),
                installer = logic.Check_Id("account", "C3", "installer");

        if (installer.isEmpty()) {
            admin_Check.setText("Installer");
            this.admin = true;
            main_Password.setVisible(false);
            keyIcon.setVisible(false);
        } else if (admin.isEmpty() && !installer.isEmpty()) {
            admin_Check.setText("Admin");
            this.admin = true;
            main_Password.setVisible(false);
            keyIcon.setVisible(false);
        } else {
            admin_Check.setText("User");
            this.admin = false;
        }

    }

    public boolean validation_Call() {
        if (!admin_Check.isSelected() && admin_Check.getText().equals("User")) {
            text1.setText("Pleas check as user !");
            return false;
        } else if (user_Name.getText().isEmpty()) {
            text1.setText("Required field !");
            return false;
        } else if (email.getText().isEmpty()) {
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

    public void CreatAndLogin() {
        String id = logic.Check_Id("account", "C2", user_Name.getText().toUpperCase());
        if (!id.isEmpty()) {
            error_Text.setText("Sorry this user name is Alraedy exist !");
        } else {
            if (this.validation_Call() && this.Validation()) {
                try {
                    con = sqlConnection.ConnectDB();
                    String sq = "insert into account(C2,C3,C4,C5,C6,C7,C8)values('"
                            + user_Name.getText().toUpperCase()
                            + "','" + admin_Check.getText()
                            + "','" + email.getText()
                            + "','" + code.getText() + "-" + contact.getText()
                            + "','" + password.getText()
                            + "','" + "Active"
                            + "','" + "Active" + "')";
                    pst = con.prepareStatement(sq);
                    pst.execute();
                    pst.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Stage mainStage = new Stage();
                Parent root;
                try {

                    root = FXMLLoader.load(getClass().getResource("/Home/Home.fxml"));
                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                    // get a handle to the stage
                    Stage stage = (Stage) sign_Up.getScene().getWindow();
                    // do what you have to do
                    stage.close();

                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    @FXML
    private void password_On_Acction(ActionEvent event
    ) {

        this.CreatAndLogin();
        // get a handle to the stage
        Stage stage = (Stage) password.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void see_On_Out(MouseEvent event
    ) {
        text5.setText("");
    }

    @FXML
    private void see_On_In(MouseEvent event
    ) {
        text5.setText(password.getText());
    }

    @FXML
    private void signUp_On_Clicked(ActionEvent event
    ) {
        if (this.admin) {
            this.CreatAndLogin();

        } else {
            if (main_Password.getText().isEmpty()) {
                System.out.println(this.admin);
                pin_Text.setText("Code is required !");
            } else if (!this.check_Code()) {
                pin_Text.setText("Wrong code !");
            } else {
                this.CreatAndLogin();
            }
        }
    }

    @FXML
    private void signUp_On_Enter(KeyEvent event
    ) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.admin) {
                this.CreatAndLogin();
            } else {
                if (main_Password.getText().isEmpty()) {
                    pin_Text.setText("Code is required !");
                } else if (!this.check_Code()) {
                    pin_Text.setText("Wrong code !");
                } else {
                    this.CreatAndLogin();
                }
            }
        }

    }

    @FXML
    private void back_On_Clicked(ActionEvent event
    ) {
        try {
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Login/Log.fxml"));
            Scene scene = new Scene(root);
            mainStage.initStyle(StageStyle.TRANSPARENT);
            mainStage.setScene(scene);
            Educator.loginStage.close();
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void close_On_Acc(MouseEvent event
    ) {
        System.exit(0);
    }

    public boolean check_Code() {
        boolean check = false;
        try {
            String sql1 = "Select C2 from account where C6 ='" + main_Password.getText() + "' And C3='" + "Admin" + "'";
            con = sqlConnection.ConnectDB();
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (!rs.getString("C2").isEmpty()) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @FXML
    private void main_On_Change(KeyEvent event) {
        pin_Text.setText("");
    }

}
