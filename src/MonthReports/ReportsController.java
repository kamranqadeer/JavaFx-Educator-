/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonthReports;

import Logic.Data;
import Logic.Dialogs;
import Logic.Validation;
import Logic.combox;
import Logic.kk_Logic;
import Logic.picture;
import com.jfoenix.controls.JFXTextField;
import educator.sqlConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class ReportsController implements Initializable {

    Data data_value = new Data();
    picture picture = new picture();
    Connection con = null;
    Dialogs dialog = new Dialogs();
    Validation validation = new Validation();
    ResultSet rs = null, rs2 = null;
    PreparedStatement pst = null;
    BoxBlur blur = new BoxBlur(3, 3, 3);
    DecimalFormat numberFormat = new DecimalFormat("#.0");
    kk_Logic logic = new kk_Logic();
    String day = "", month = "", year = "", time = "", StudentId = "", activity = "Quiz", subject = "Math";
    private ObservableList<Logic.TableList> data, data2, data3;
    @FXML
    private TableView<Logic.TableList> Table_1;
    @FXML
    private TableColumn<Logic.TableList, String> C1_1;
    @FXML
    private TableColumn<Logic.TableList, String> C1_2;
    @FXML
    private TableColumn<Logic.TableList, String> C1_3;
    @FXML
    private TableColumn<Logic.TableList, String> C1_4;
    @FXML
    private TableView<Logic.TableList> Table_2;
    @FXML
    private TableColumn<Logic.TableList, String> C2_1;
    @FXML
    private TableColumn<Logic.TableList, String> C2_2;
    @FXML
    private TableColumn<Logic.TableList, String> C2_3;
    @FXML
    private TableColumn<Logic.TableList, String> C2_4;
    @FXML
    private TableColumn<Logic.TableList, String> C2_5;
    @FXML
    private TableView<Logic.TableList> Table_3;
    @FXML
    private TableColumn<Logic.TableList, String> C3_1;
    @FXML
    private TableColumn<Logic.TableList, String> C3_2;
    @FXML
    private TableColumn<Logic.TableList, String> C3_3;
    @FXML
    private TableColumn<Logic.TableList, String> C3_4;
    @FXML
    private TableColumn<Logic.TableList, String> C3_5;
    @FXML
    private Text yearText;
    @FXML
    private Circle picCircle;
    @FXML
    private ComboBox changeClass;
    @FXML
    private ComboBox changeStudent;
    @FXML
    private Text pText;
    @FXML
    private Text aText;
    @FXML
    private Text lText;
    @FXML
    private Text attendancePercent;
    @FXML
    private JFXTextField attendanceDis;
    @FXML
    private JFXTextField leftFee;
    @FXML
    private ComboBox changeSubject;
    @FXML
    private ComboBox changeActivity;
    @FXML
    private JFXTextField activityDiscription;
    @FXML
    private Text passText;
    @FXML
    private Text failText;
    @FXML
    private Text subjectPercent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data3 = FXCollections.observableArrayList();
        day = logic.getDay();
        month = logic.getMonth();
        year = logic.getYear();
        yearText.setText(year);
        data_value.SetComBox(changeClass, "getClasses");
        data_value.SetComBox(changeActivity, "getActivities");
        changeClass.setValue("Select");
        changeStudent.setValue("Select");
        this.ChangeClass();
        this.ChangeStudent();
        this.ChangeActivity();
        this.ChangeSubjects();
        //setting table 1
        this.setTabe_1();
        //setting table 2
        this.setTabe_2();
        //setting table 3
        this.setTabe_3();

    }

    public void setTabe_1() {
        C1_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C1_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C1_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C1_4.setCellValueFactory(new PropertyValueFactory<>("circle"));

    }

    public void setTabe_2() {
        C2_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C2_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C2_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C2_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C2_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
    }

    public void setTabe_3() {
        C3_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C3_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C3_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C3_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C3_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
    }

    @FXML
    private void left_Year_On_Clicked(MouseEvent event) {
        int v = Integer.valueOf(yearText.getText());
        yearText.setText(String.valueOf(--v));
        year = yearText.getText();
        this.CallMonth(this.month);

    }

    @FXML
    private void right_Year_On_Clicked(MouseEvent event) {
        int v = Integer.valueOf(yearText.getText());
        yearText.setText(String.valueOf(++v));
        year = yearText.getText();
        this.CallMonth(this.month);

    }

    public void ChangeClass() {
        changeClass.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<String> studentList = FXCollections.observableArrayList();
                if (newValue != null) {
                    studentList.clear();
                    changeStudent.getItems().clear();
                    try {
                        rs = logic.getTable_Data("student", newValue, "C10", "C1");
                        while (rs.next()) {
                            studentList.add(rs.getString("C3") + "   Id: " + rs.getString("C1"));
                        }
                        changeStudent.setTooltip(new Tooltip());
                        changeStudent.getItems().addAll(studentList);
                        new combox<String>(changeStudent);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        ReportsController.this.CloseConnection();
                    }
                    changeSubject.setItems(data_value.getSubjects(newValue));
                    changeSubject.setValue("Math");
                }
            }
        }
        );

    }

    public void ChangeStudent() {
        changeStudent.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    String temp[] = newValue.split("   Id: ");
                    StudentId = temp[1];
                    picture.uploadImage("Student" + StudentId, picCircle);
                    ReportsController.this.LoadAttendance();
                    ReportsController.this.loadFee();
                    ReportsController.this.loadActivity();
                }
            }
        }
        );

    }

    public void ChangeSubjects() {
        changeSubject.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    subject = newValue;
                    ReportsController.this.loadActivity();

                }
            }
        }
        );

    }

    public void ChangeActivity() {
        changeActivity.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    activity = newValue;
                    ReportsController.this.loadActivity();
                }
            }
        }
        );

    }

    public void LoadAttendance() {
        int A = 0,
                P = 0,
                L = 0;
        try {
            Table_1.getItems().clear();
            data.clear();
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select * from attendance where C3='" + month + "' And C4='" + year + "' And C5='" + StudentId + "' And C9='Student'";
            rs2 = stmt.executeQuery(sql1);
            int i = 0;
            while (rs2.next()) {
                //adding button
                //Drawing a Circle
                Circle status = new Circle();
                //Setting the properties of the circle
                status.setCenterX(300.0f);
                status.setCenterY(135.0f);
                status.setRadius(10.0f);
                //Setting other properties
                status.setFill(Color.LIGHTGRAY);
                String C0 = String.valueOf(++i);
                String C1 = rs2.getString("C2") + month;
                String C2 = rs2.getString("C8");
                if (C2.equals("P")) {
                    picture.uploadImage("okay", status);
                    ++P;
                } else if (C2.equals("L")) {
                    picture.uploadImage("leave", status);
                    ++L;
                } else {
                    picture.uploadImage("absence", status);
                    ++A;
                }
                data.addAll(new Logic.TableList(C0, C1, C2, status));

            }
            pText.setText(String.valueOf(P) + " Day's");
            aText.setText(String.valueOf(A) + " Day's");
            lText.setText(String.valueOf(L) + " Day's");
            double per = 0.0;
            if (P != 0) {
                per = P * 100 / i;
            }
            attendancePercent.setText(numberFormat.format(per) + " %");
            if (!data.isEmpty()) {
                attendanceDis.setText(logic.getDiscription(attendancePercent.getText()));
            }
            Table_1.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }

    }

    public void loadFee() {
        double v = 0.0;
        try {
            Table_2.getItems().clear();
            data2.clear();
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select * from feestructure where C4='" + StudentId + "' And C13!='Don'";
            rs2 = stmt.executeQuery(sql1);
            while (rs2.next()) {

                String C0 = rs2.getString("C1") + rs2.getString("C2") + rs2.getString("C3");
                String C1 = rs2.getString("C5");
                String C2 = rs2.getString("C10");
                String C3 = rs2.getString("C11");
                String C4 = rs2.getString("C12");
                v += Double.valueOf(C4);
                data2.addAll(new Logic.TableList(C0, C1, C2, C3, C4));

            }
            Table_2.setItems(data2);
            if (v != 0) {
                leftFee.setText(numberFormat.format(v) + " Rs");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }

    }

    public void loadActivity() {
        int pass = 0,
                fail = 0,
                i = 0;
        double per = 0.0,
                total = 0.0,
                obtain = 0.0;
        try {
            Table_3.getItems().clear();
            data3.clear();
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select studyplan.C2 as day,"
                    + "studyplan.C3 as month,"
                    + "studyplan.C9 as activityName,"
                    + "studydetails.C4 as total,"
                    + "studydetails.C6 as obtain,"
                    + "studydetails.C7 as per,"
                    + "studydetails.C8 as grade,"
                    + "studydetails.C9 as result,"
                    + "studydetails.C10 as discri from studydetails "
                    + "CROSS JOIN studyplan where studyplan.C0=studydetails.C1 AND studydetails.C2='" + StudentId + "' AND studyplan.C7='" + subject + "' AND studyplan.C8='" + activity + "' AND studyplan.C3='" + month + "' AND studyplan.C4='" + year + "'";
            rs2 = stmt.executeQuery(sql1);
            while (rs2.next()) {
                String C0 = rs2.getString("day") + rs2.getString("month");
                String C1 = rs2.getString("activityName");
                String C2 = "total    =" + rs2.getString("total") + "\n" + "Obtain =" + rs2.getString("obtain");
                String C3 = rs2.getString("per") + "\n" + rs2.getString("grade") + "\n" + rs2.getString("result");
                String C4 = rs2.getString("discri");
                if (rs2.getString("result").equals("Pass")) {
                    ++pass;
                    obtain += Double.valueOf(rs2.getString("obtain"));
                } else {
                    ++fail;
                }
                total += Double.valueOf(rs2.getString("total"));
                ++i;
                data3.addAll(new Logic.TableList(C0, C1, C2, C3, C4));
            }
            Table_3.setItems(data3);
            passText.setText(String.valueOf(pass));
            failText.setText(String.valueOf(fail));

            if (obtain != 0) {
                per = obtain * 100 / total;
            }
            subjectPercent.setText(numberFormat.format(per) + " %");
            if (!data3.isEmpty()) {
                activityDiscription.setText(logic.getDiscription(subjectPercent.getText()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }

    }

    public void CloseConnection() {
        try {
            rs.close();
        } catch (Exception e) {
            /* ignored */ }
        try {
            pst.close();
        } catch (Exception e) {
            /* ignored */ }
        try {
            con.close();
        } catch (Exception e) {
            /* ignored */ }
    }

    @FXML
    private void janAction(ActionEvent event) {
        this.CallMonth("January");
    }

    @FXML
    private void FebAction(ActionEvent event) {
        this.CallMonth("February");
    }

    @FXML
    private void marAction(ActionEvent event) {
        this.CallMonth("March");
    }

    @FXML
    private void apAction(ActionEvent event) {
        this.CallMonth("April");
    }

    @FXML
    private void mayAction(ActionEvent event) {
        this.CallMonth("May");
    }

    @FXML
    private void junAction(ActionEvent event) {
        this.CallMonth("June");
    }

    @FXML
    private void julyAction(ActionEvent event) {
        this.CallMonth("July");
    }

    @FXML
    private void auguAction(ActionEvent event) {
        this.CallMonth("August");
    }

    @FXML
    private void sepAction(ActionEvent event) {
        this.CallMonth("September");
    }

    @FXML
    private void octAction(ActionEvent event) {
        this.CallMonth("October");
    }

    @FXML
    private void novAction(ActionEvent event) {
        this.CallMonth("November");
    }

    @FXML
    private void DecAction(ActionEvent event) {
        this.CallMonth("December");
    }

    public void CallMonth(String month) {
        this.month = month;
        ReportsController.this.LoadAttendance();
        ReportsController.this.loadFee();
        ReportsController.this.loadActivity();
    }
}
