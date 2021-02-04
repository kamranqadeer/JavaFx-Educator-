/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddStudyDetails;

import AddAttendance.AddAttendanceController;
import Logic.Data;
import Logic.Dialogs;
import Logic.Validation;
import Logic.kk_Logic;
import Logic.picture;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
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
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class StudyDetailsController implements Initializable {
    
    TranslateTransition openNav, closeNav;
    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> select_List = FXCollections.observableArrayList();
    ObservableList<String> all_Data = FXCollections.observableArrayList();
    ObservableList<String> temp = FXCollections.observableArrayList();
    
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
    String classCheck = "Play Group", day = "", month = "", year = "", time = "", checkPane = "Student", checkActivity = "Quiz", checkSubject = "";
    boolean selection_Check = false;
    private ObservableList<Logic.TableList> data;
    private ObservableList<Logic.TableList> data2;
    @FXML
    private ComboBox changeClass;
    @FXML
    private DatePicker changeDate;
    @FXML
    private Text dateText;
    @FXML
    private Text timeText;
    @FXML
    private JFXTimePicker time_Picker;
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
    private TableColumn<Logic.TableList, String> C1_5;
    @FXML
    private TableColumn<Logic.TableList, String> C1_6;
    @FXML
    private TableColumn<Logic.TableList, String> C1_7;
    @FXML
    private TableColumn<Logic.TableList, String> C1_8;
    @FXML
    private ComboBox selectTeacher;
    @FXML
    private ComboBox selectSubjects;
    @FXML
    private JFXTextField totalMarks;
    @FXML
    private JFXTextField PassingMarks;
    @FXML
    private ComboBox change_Activity;
    @FXML
    private TableView<Logic.TableList> Table_2;
    @FXML
    private TableColumn<Logic.TableList, String> C2_0;
    @FXML
    private TableColumn<Logic.TableList, String> C2_1;
    @FXML
    private TableColumn<Logic.TableList, String> C2_2;
    @FXML
    private TableColumn<Logic.TableList, String> C2_3;
    @FXML
    private TableColumn<Logic.TableList, String> C2_4;
    @FXML
    private JFXTextField activityName;
    @FXML
    private AnchorPane menuPane;
    @FXML
    private GridPane mainGride;
    @FXML
    private StackPane mainPane;
    @FXML
    private Text total_Text;
    @FXML
    private Text percentage_Text;
    @FXML
    private Text passText;
    @FXML
    private Text failText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Slide Nave
        openNav = new TranslateTransition(new Duration(350), menuPane);
        openNav.setToX(0);
        closeNav = new TranslateTransition(new Duration(350), menuPane);
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        day = logic.getDay();
        month = logic.getMonth();
        year = logic.getYear();
        time = logic.getTime();
        dateText.setText(day + " " + month + " " + year);
        timeText.setText(time);

        //setting Table
        this.setTabe_1();
        this.SelectCell();
        //setting table 2
        this.setTabe_2();
        validation.Number(totalMarks);
        validation.Number(PassingMarks);
        validation.Name_2(activityName);
        data_value.SetComBox(change_Activity, "getActivities");
        data_value.SetComBox(changeClass, "getClasses");
        data_value.SetComBox(selectTeacher, "getEmploys");
        selectSubjects.setValue("Non");
        this.ChangeCLasses();
        this.ChangeActivity();
        this.ChangeSubject();
        this.loadSubjects(classCheck);
        this.LoadData_1(day, month, year);
    }
    
    public void setTabe_1() {
        C2_0.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C2_1.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C2_2.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C2_3.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C2_4.setCellValueFactory(new PropertyValueFactory<>("gridPane"));
    }
    
    public void setTabe_2() {
        C1_1.setCellValueFactory(new PropertyValueFactory<>("gridPane"));
        C1_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C1_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C1_4.setCellValueFactory(new PropertyValueFactory<>("input1"));
        C1_5.setCellValueFactory(new PropertyValueFactory<>("gridPane2"));
        C1_6.setCellValueFactory(new PropertyValueFactory<>("text1"));
        C1_7.setCellValueFactory(new PropertyValueFactory<>("circle"));
        C1_8.setCellValueFactory(new PropertyValueFactory<>("delete"));
        
    }
    
    public void LoadData_1(String day, String month, String year) {
        data2.clear();
        Table_2.getItems().clear();
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select * from studyplan where C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C6='" + classCheck + "' And C8='" + checkActivity + "' And C7='" + checkSubject + "'";
            rs = stmt.executeQuery(sql1);
            int i = 0;
            while (rs.next()) {
                //Creating a Grid Pane 
                GridPane action = new GridPane();
                //Setting size for the pane  
                action.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                action.setVgap(0.5);
                // gridPane.setHgap(0);
                action.setAlignment(Pos.CENTER);
                String C0 = rs.getString("C0");
                String C1 = rs.getString("C2") + "/" + rs.getString("C3") + "/" + rs.getString("C4");
                String C2 = rs.getString("C9");
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(rs.getString("C0"));
                print.setOnAction(e -> {
                    // row_Id = ((Control) e.getSource()).getId();
                });
                //adding print
                Button delete = new Button();
                delete.getStyleClass().add("delete_Button");
                delete.setId(rs.getString("C0"));
                delete.setOnAction(e -> {
                    if (dialog.confirm_Dialog(mainPane, "You want to delete this activity")) {
                        logic.deleteData("studyplan", "C0", ((Control) e.getSource()).getId());
                        logic.deleteData("studydetails", "C1", ((Control) e.getSource()).getId());
                        this.LoadData_1(day, month, year);
                        this.LoadData_2(((Control) e.getSource()).getId());
                        dialog.Notofication("Deleting", "Successfuly deleted activity", "okay");
                        // row_Id = ((Control) e.getSource()).getId();
                    }
                });
                //adding Action
                action.add(print, 1, 1);
                action.add(delete, 2, 1);
                data2.add(new Logic.TableList(C0, String.valueOf(++i), C1, C2, action));
            }
            Table_2.setItems(data2);
        } catch (SQLException ex) {
            Logger.getLogger(StudyDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    //table 2 set button
    private void SelectCell() {
        Table_2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Logic.TableList t = Table_2.getItems().get(Table_2.getSelectionModel().getSelectedIndex());
                StudyDetailsController.this.LoadData_2(t.getC0());
            }
        });
    }
    
    public void LoadData_2(String Id) {
        data.clear();
        Table_1.getItems().clear();
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select * from studydetails where C1= '" + Id + "'";
            rs = stmt.executeQuery(sql1);
            int i = 0;
            while (rs.next()) {
                i++;
                //Drawing a Circle
                Circle circle = new Circle();
                //Setting the properties of the circle
                circle.setCenterX(300.0f);
                circle.setCenterY(135.0f);
                circle.setRadius(50.0f);
                //Setting other properties
                //Creating a Grid Pane 
                GridPane action = new GridPane();
                //Setting size for the pane  
                action.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                action.setVgap(0.5);
                // gridPane.setHgap(0);
                action.setAlignment(Pos.CENTER);
                //Creating a Grid Pane 
                GridPane student = new GridPane();
                //Setting size for the pane  
                student.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                student.setVgap(0.5);
                // gridPane.setHgap(0);
                student.setAlignment(Pos.CENTER);
                //adding button
                //Drawing a Circle
                Circle status = new Circle();
                //Setting the properties of the circle
                status.setCenterX(300.0f);
                status.setCenterY(135.0f);
                status.setRadius(25.0f);
                //Setting other properties
                status.setFill(Color.LIGHTGRAY);
                String C1 = rs.getString("C3");
                String C2 = rs.getString("C4");
                String C3 = rs.getString("C6");
                String passingMarks = rs.getString("C5");
                String C4 = rs.getString("C7");
                String C5 = rs.getString("C8");
                String C6 = rs.getString("C9");
                String C7 = rs.getString("C10");
                String C8 = rs.getString("C11");
                //input field
                JFXTextField input1 = new JFXTextField(C3);
                input1.setId(rs.getString("C0"));
                validation.Number2(input1);
                input1.getStyleClass().add("table_InputField");
                
                Text text1 = new Text(C4);
                Text text2 = new Text(C5);
                Text text3 = new Text(C6);
                Text text4 = new Text(C7);
                text1.getStyleClass().add("check-text");
                text2.getStyleClass().add("check-text");
                text3.getStyleClass().add("check-text");
                text4.getStyleClass().add("check-text");
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(rs.getString("C0"));
                print.setFocusTraversable(false);
                print.setOnAction(e -> {
                    // row_Id = ((Control) e.getSource()).getId();
                });
                picture.uploadImage("Student" + rs.getString("C2"), circle);
                status.setId(rs.getString("C0"));
                
                CheckBox selection = new CheckBox();
                
                selection.getStyleClass().add("check-box");

                //Selection
                selection.setId(rs.getString("C0"));
                selection.setOnAction(e -> {
                    
                });
                //Set Select Check
                if (selection_Check) {
                    selection.setVisible(true);
                    selection.setSelected(selection_Check);
                } else {
                    selection.setVisible(false);
                }
                
                if (C8.equals("Don")) {
                    picture.uploadImage("okay", status);
                } else {
                    picture.uploadImage("absence", status);
                }
                
                input1.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (!newValue.isEmpty()) {
                        if (Double.valueOf(newValue) > Double.valueOf(C2)) {
                            input1.setText(oldValue);
                        } else {
                            text1.setText(logic.getPercentage(C2, newValue));
                            text2.setText(logic.getGrade(text1.getText()));
                            text3.setText(logic.getResult(passingMarks, newValue));
                            text4.setText(logic.getDiscription(text1.getText()));
                            this.UpdateActivity(input1.getId(), newValue, text1.getText(), text2.getText(), text3.getText(), text4.getText());
                            picture.uploadImage("okay", status);
                            this.SetText(Id);
                        }
                    } else {
                        text1.setText("0");
                        text2.setText("Non");
                        text3.setText("Non");
                        text4.setText("Not Yet");
                    }
                });
                //adding Action
                action.add(text1, 1, 1);
                action.add(text2, 1, 2);
                action.add(text3, 1, 3);
                //  student.add(selection, 1, 1);
                student.add(circle, 1, 1);
                
                data.add(new Logic.TableList(student, C1, C2, input1, action, text4, status, print));
            }
            Table_1.setItems(data);
            this.SetText(Id);
        } catch (SQLException ex) {
            Logger.getLogger(StudyDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }
    
    public void UpdateActivity(String Id, String marks, String per, String grade, String result, String dis) {
        try {
            con = sqlConnection.ConnectDB();
            String sql = "update studydetails set C6='" + marks
                    + "',C7='" + per
                    + "',C8='" + grade
                    + "',C9='" + result
                    + "',C10='" + dis
                    + "',C11='" + "Don"
                    + "' where C0='" + Id + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }
    
    public void SetText(String Id) {
        try {
            int total = 0,
                    pass = 0,
                    fail = 0;
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select * from studydetails where C1= '" + Id + "'";
            rs2 = stmt.executeQuery(sql1);
            while (rs2.next()) {
                total++;
                if (rs2.getString("C9").equals("Pass")) {
                    pass++;
                } else {
                    fail++;
                }
            }
            total_Text.setText(String.valueOf(total));
            percentage_Text.setText(String.valueOf(pass * 100 / total) + " %");
            passText.setText(String.valueOf(pass));
            failText.setText(String.valueOf(fail));
            
        } catch (SQLException ex) {
            Logger.getLogger(StudyDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        
    }
    
    public boolean Validation() {
        if (!validation.CheckEmpty(activityName, "Activity Name is required !")
                || !validation.CheckEmpty(totalMarks, "Total Marks is required !")
                || !validation.CheckEmpty(PassingMarks, "Passing Marks is required !")) {
            return false;
        } else {
            all_Data.clear();
            all_Data.add(time);//0
            all_Data.add(day);//1
            all_Data.add(month);//2
            all_Data.add(year);//3
            all_Data.add(selectTeacher.getValue().toString());//4
            all_Data.add(changeClass.getValue().toString());//5
            all_Data.add(selectSubjects.getValue().toString());//6
            all_Data.add(checkActivity);//7
            all_Data.add(activityName.getText());//8
            all_Data.add(totalMarks.getText());//9
            all_Data.add(PassingMarks.getText());//10
            return true;
        }
    }
    
    public void SaveData_1() {
        
        try {
            if (Double.valueOf(all_Data.get(9)) < Double.valueOf(all_Data.get(10))) {
                dialog.Notofication("Error", "Passing marks must be greater than total marks", "error");
            } else {
                //geting one pice cost if scale is Dozen
                con = sqlConnection.ConnectDB();
                String sq = "insert into studyplan(C1,C2,C3,C4,C5,C6,C7,C8,C9)values('"
                        + all_Data.get(0)
                        + "','" + all_Data.get(1)
                        + "','" + all_Data.get(2)
                        + "','" + all_Data.get(3)
                        + "','" + all_Data.get(4)
                        + "','" + all_Data.get(5)
                        + "','" + all_Data.get(6)
                        + "','" + all_Data.get(7)
                        + "','" + all_Data.get(8)
                        + "')";
                pst = con.prepareStatement(sq);
                pst.execute();
                String Id = logic.resentId("studyplan", "C0");
                rs = logic.getTable_Data("student", classCheck, "C10", "C1");
                while (rs.next()) {
                    con = sqlConnection.ConnectDB();
                    String sq2 = "insert into studydetails(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11)values('"
                            + Id
                            + "','" + rs.getString("C1")
                            + "','" + rs.getString("C3")
                            + "','" + all_Data.get(9)
                            + "','" + all_Data.get(10)
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "Non"
                            + "','" + "Non"
                            + "','" + "Not Yet"
                            + "','" + "Not"
                            + "')";
                    
                    pst = con.prepareStatement(sq2);
                    pst.execute();
                }
                this.LoadData_2(Id);
                this.LoadData_1(day, month, year);
                dialog.Notofication("Adding Class", "SuccessFuly Adding new Class", "okay");
                this.menuPane();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudyDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        
    }
    
    public void ChangeCLasses() {
        changeClass.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    classCheck = newValue;
                    StudyDetailsController.this.loadSubjects(newValue);
                    StudyDetailsController.this.LoadData_1(day, month, year);
                    Table_1.getItems().clear();
                    data.clear();
                }
            }
        }
        );
        
    }
    
    public void loadSubjects(String Id) {
        try {
            temp.clear();
            rs = logic.getTable_Data("classdetails", Id, "C1", "C0");
            while (rs.next()) {
                temp.add(rs.getString("C2"));
            }
            selectSubjects.setValue("Non");
            selectSubjects.setItems(temp);
        } catch (SQLException ex) {
            Logger.getLogger(StudyDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            StudyDetailsController.this.CloseConnection();
        }
    }
    
    public void ChangeActivity() {
        change_Activity.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<String> temp = FXCollections.observableArrayList();
                if (newValue != null) {
                    checkActivity = newValue;
                    StudyDetailsController.this.LoadData_1(day, month, year);
                    Table_1.getItems().clear();
                    data.clear();
                    
                }
            }
        }
        );
        
    }
    
    public void ChangeSubject() {
        selectSubjects.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<String> temp = FXCollections.observableArrayList();
                if (newValue != null) {
                    checkSubject = newValue;
                    StudyDetailsController.this.LoadData_1(day, month, year);
                    Table_1.getItems().clear();
                    data.clear();
                }
            }
        }
        );
        
    }
    
    @FXML
    private void changeDate_On_Clicked(ActionEvent event) {
        if (!changeDate.getValue().toString().isEmpty()) {
            String temp[] = changeDate.getValue().toString().split("-");
            year = temp[0];
            month = logic.getMonth(temp[1]);
            day = temp[2];
            dateText.setText(day + " " + month + " " + year);
            this.LoadData_1(day, month, year);
            Table_1.getItems().clear();
            data.clear();
        }
    }
    
    @FXML
    private void changeTime_On_Cicked(ActionEvent event) {
        if (!time_Picker.getValue().toString().isEmpty()) {
            int h = 0,
                    m = time_Picker.getValue().getMinute();
            String am_pm = "";
            if (time_Picker.getValue().getHour() >= 12) {
                am_pm = "PM";
                if (time_Picker.getValue().getHour() == 12) {
                    h = time_Picker.getValue().getHour();
                } else {
                    h = time_Picker.getValue().getHour() - 12;
                }
            } else {
                am_pm = "AM";
                h = time_Picker.getValue().getHour();
            }
            time = String.valueOf(h) + ":" + String.valueOf(m) + " " + am_pm;
            // time = time_Picker.getValue().get;
            timeText.setText(time);
        }
    }
    
    @FXML
    private void add_On_Clicked(ActionEvent event) {
        if (this.Validation()) {
            this.SaveData_1();
        }
    }
    
    @FXML
    private void add_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation()) {
                this.SaveData_1();
            }
        }
    }
    
    public void Clear_1() {
        activityName.clear();
        totalMarks.clear();
        PassingMarks.clear();
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
    private void clos_Pane_On_Clicked(MouseEvent event) {
        this.menuPane();
    }
    
    @FXML
    private void add_New_Activity(MouseEvent event) {
        this.menuPane();
        if (checkActivity.equals("Exams")) {
            try {
                con = sqlConnection.ConnectDB();
                Statement stmt;
                stmt = con.createStatement();
                String sql1 = "Select C4,C5 from classdetails where C1= '" + classCheck + "' AND C2='" + checkSubject + "'";
                rs = stmt.executeQuery(sql1);
                while (rs.next()) {
                    totalMarks.setText(rs.getString("C4"));
                    PassingMarks.setText(rs.getString("C5"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudyDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void menuPane() {
        if (menuPane.getTranslateX() != 0) {
            openNav.play();
            mainGride.setDisable(true);
        } else {
            closeNav.setToX(-(menuPane.getWidth()));
            closeNav.play();
            mainGride.setDisable(false);
            this.Clear_1();
        }
    }
}
