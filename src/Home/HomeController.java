/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import educator.Educator;
import Logic.Data;
import Logic.Dialogs;
import Logic.kk_Logic;
import Logic.picture;
import com.jfoenix.controls.JFXButton;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class HomeController implements Initializable {

    Connection con = null;
    ResultSet rs = null;
    BoxBlur blur = new BoxBlur(3, 3, 3);
    PreparedStatement pst = null;
    kk_Logic logic = new kk_Logic();
    Dialogs dialogs = new Dialogs();
    Data data = new Data();
    boolean check = false;
    picture picture = new picture();

    @FXML
    private JFXButton menu;
    @FXML
    private Text SystemText;
    @FXML
    private Text CompanyText;
    @FXML
    private VBox menu_Pane;
    @FXML
    private Text status_Text;
    @FXML
    private Text name_Text;
    @FXML
    private JFXButton help_Button;
    @FXML
    private JFXButton info_Button;
    @FXML
    private JFXButton back_Up;
    @FXML
    private JFXButton log_Out1;
    @FXML
    private ImageView switch_Button;
    @FXML
    private JFXButton log_Out;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private StackPane mainPane;
    @FXML
    private Circle circle;
    @FXML
    private ComboBox menu_Combobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menu_Combobox.setItems(data.getPortal());
        try {
            // TODO
            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/Registration/registration.fxml")));

        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
        CompanyText.setText(data.software_Develope);
        this.CheckActive();
        this.change_Menu();
    }

    @FXML
    private void menu_On_Clicked(ActionEvent event) {
        this.In();
    }

    public void In() {
        if (check == false) {
            check = true;
            //    holderPane.setEffect(blur);
        } else {
            check = false;
            //  holderPane.setEffect(null);
        }
        menu_Pane.setVisible(check);
    }

    @FXML
    private void help_On_Clicked(ActionEvent event) {
        try {
            menu_Pane.setVisible(false);
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Help/help.fxml"));
            Scene scene = new Scene(root);
            mainStage.initStyle(StageStyle.TRANSPARENT);
            mainStage.setScene(scene);
            mainStage.show();
            mainPane.setEffect(null);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void get_Info(ActionEvent event) {
        try {
            menu_Pane.setVisible(false);
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/UserInfo/Information.fxml"));
            Scene scene = new Scene(root);
            mainStage.initStyle(StageStyle.TRANSPARENT);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void back_Up_Acc(ActionEvent event) {
        try {
            menu_Pane.setVisible(false);
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Backup/backup.fxml"));
            Scene scene = new Scene(root);
            mainStage.initStyle(StageStyle.TRANSPARENT);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switch_On_Clicked(ActionEvent event) {
        try {
            rs = logic.getTable_Data("account", "Active", "C7", "C1");
            while (rs.next()) {
                con = sqlConnection.ConnectDB();
                String sql = "update account set C7='" + "Deactive"
                        + "' where C1='" + rs.getString("C1") + "'";
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                pst.execute();
                con.close();
                try {
                    // get a handle to the stage
                    Stage stage = (Stage) switch_Button.getScene().getWindow();
                    // do what you have to do
                    stage.close();
                    Stage mainStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/LogIn/logIn.fxml"));
                    Scene scene = new Scene(root);
                    mainStage.initStyle(StageStyle.TRANSPARENT);
                    mainStage.setScene(scene);
                    Educator.loginStage.close();
                    mainStage.show();

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logout_On_Click(ActionEvent event) {
        try {
            rs = logic.getTable_Data("account", "Active", "C7", "C1");
            while (rs.next()) {
                if (dialogs.confirm_Dialog(mainPane, "You want to LogOut " + rs.getString("C2") + ".")) {
                    con = sqlConnection.ConnectDB();
                    String sql = "update account set C7='" + "Deactive"
                            + "' where C1='" + rs.getString("C1") + "'";
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    pst.execute();
                    con.close();
                    System.exit(0);
                } else {
                    break;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CheckActive() {
        try {
            rs = logic.getTable_Data("account", "Active", "C7", "C1");
            while (rs.next()) {
                name_Text.setText(rs.getString("C2"));
                status_Text.setText(rs.getString("C3"));
                picture.uploadImage(rs.getString("C3") + "_" + rs.getString("C2"), circle);
                if (rs.getString("C3").equals("User")) {

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void change_Menu() {
        menu_Combobox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {

                    if (newValue.equals("All Reports")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/MonthReports/reports.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (newValue.equals("Study Structure")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/AddStudyDetails/studyDetails.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Home")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/TimeTable/timeTable.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Activities")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/AddActivities/addActivities.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Fee Structure")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/StudenFee/studentFee.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Salary Structure")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/EmployPaySalary/employPaySalary.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Attendance")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/AddAttendance/addAttendance.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Add Subjects")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/AddSubjects/subjects.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Add Classes")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/AddClasses/class.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("All Employees")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/AddEmploy/addEmploy.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (newValue.equals("Registration")) {
                        try {
                            holderPane.getChildren().clear();
                            holderPane.getChildren().add(FXMLLoader.load(getClass().getResource("/Registration/registration.fxml")));
                        } catch (IOException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }

            }
        });

    }

}
