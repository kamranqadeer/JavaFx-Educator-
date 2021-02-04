/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddAttendance;

import Logic.Data;
import Logic.Dialogs;
import Logic.Validation;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class AddAttendanceController implements Initializable {

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> select_List = FXCollections.observableArrayList();
    ObservableList<String> Pane = FXCollections.observableArrayList("Student", "Employ");

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
    String classCheck = "", day = "", month = "", year = "", checkPane = "Student";
    boolean selection_Check = false;
    private ObservableList<Logic.TableList> data;
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
    private ComboBox changeClass;
    @FXML
    private StackPane mainPane;
    @FXML
    private DatePicker attendanceDate;
    @FXML
    private Text total_Text;
    @FXML
    private Text present_Text;
    @FXML
    private Text absence_Text;
    @FXML
    private Text leave_Text;
    @FXML
    private Text avrage_Text;
    @FXML
    private Text date_Text;
    @FXML
    private ComboBox mode_Select;
    @FXML
    private JFXTextField search;
    @FXML
    private GridPane mainGrid;
    @FXML
    private Text check_Text;
    @FXML
    private CheckBox select_All_Check;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        data = FXCollections.observableArrayList();
        this.setTabe_1();
        this.SelectCell();
        this.search();
        mode_Select.setItems(Pane);
        mode_Select.setValue("Student");
        list.add("All School");
        list.addAll(data_value.getClasses());
        changeClass.setItems(list);
        changeClass.setValue("All School");
        classCheck = changeClass.getValue().toString();
        this.ChangeCLasses();
        this.ChangePane();
        day = logic.getDay();
        month = logic.getMonth();
        year = logic.getYear();
        date_Text.setText(day + " " + month + " " + year);
        this.load_Student_Attendance(day, month, year);
        this.LoadData_1(day, month, year);
    }

    public void setTabe_1() {
        C1_1.setCellValueFactory(new PropertyValueFactory<>("gridPane2"));
        C1_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C1_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C1_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C1_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        C1_6.setCellValueFactory(new PropertyValueFactory<>("gridPane"));
        C1_7.setCellValueFactory(new PropertyValueFactory<>("circle2"));
        C1_8.setCellValueFactory(new PropertyValueFactory<>("details"));

    }

    public void LoadData_1(String day, String month, String year) {
        data.clear();
        Table_1.getItems().clear();
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "";
            if (classCheck.equals("All School") || classCheck.equals("All Employs")) {
                sql1 = "Select * from attendance where C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C9='" + checkPane + "'";
            } else {
                sql1 = "Select * from attendance where C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C7='" + classCheck + "' And C9='" + checkPane + "'";
            }
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
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
                GridPane Pic = new GridPane();
                //Setting size for the pane  
                Pic.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                Pic.setVgap(0.5);
                // gridPane.setHgap(0);
                Pic.setAlignment(Pos.CENTER);
                //adding button
                //Drawing a Circle
                Circle status = new Circle();
                //Setting the properties of the circle
                status.setCenterX(300.0f);
                status.setCenterY(135.0f);
                status.setRadius(25.0f);
                //Setting other properties
                status.setFill(Color.LIGHTGRAY);
                String C1 = rs.getString("C2") + "/" + rs.getString("C3") + "/" + rs.getString("C4");
                String C2 = rs.getString("C5");
                String C3 = rs.getString("C6");
                String C4 = rs.getString("C7");
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(rs.getString("C0"));
                print.setOnAction(e -> {
                    // row_Id = ((Control) e.getSource()).getId();
                });
                picture.uploadImage(mode_Select.getValue().toString() + rs.getString("C5"), circle);
                status.setId(rs.getString("C0"));
                Text text1 = new Text("Present");
                Text text2 = new Text("Absence");
                Text text3 = new Text("Leave");

                text1.getStyleClass().add("check-text");
                text2.getStyleClass().add("check-text");
                text3.getStyleClass().add("check-text");

                CheckBox present = new CheckBox();
                CheckBox absence = new CheckBox();
                CheckBox leave = new CheckBox();
                CheckBox selection = new CheckBox();

                present.getStyleClass().add("check-box");
                absence.getStyleClass().add("check-box");
                leave.getStyleClass().add("check-box");
                selection.getStyleClass().add("check-box");

                //present
                present.setId(rs.getString("C0"));
                present.setOnAction(e -> {
                    picture.uploadImage("okay", status);
                    absence.setSelected(false);
                    leave.setSelected(false);
                    this.UpdateAttandance(((Control) e.getSource()).getId(), "P");
                    this.textStatus("", classCheck, day, month, year);
                });
                //absence
                absence.setId(rs.getString("C0"));
                absence.setOnAction(e -> {
                    picture.uploadImage("absence", status);
                    present.setSelected(false);
                    leave.setSelected(false);
                    this.UpdateAttandance(((Control) e.getSource()).getId(), "A");
                    this.textStatus("", classCheck, day, month, year);
                });
                //Leaves
                leave.setId(rs.getString("C0"));
                leave.setOnAction(e -> {
                    picture.uploadImage("leave", status);
                    absence.setSelected(false);
                    present.setSelected(false);
                    this.UpdateAttandance(((Control) e.getSource()).getId(), "L");
                    this.textStatus("", classCheck, day, month, year);
                });
                //Selection
                selection.setId(rs.getString("C0"));
                selection.setOnAction(e -> {
                    if (selection.isSelected()) {
                        select_List.add(((Control) e.getSource()).getId());
                    } else {
                        this.remove_Add_Selection(((Control) e.getSource()).getId());
                    }
                });
                //Set Select Check
                if (selection_Check) {
                    selection.setVisible(true);
                    selection.setSelected(selection_Check);
                } else {
                    selection.setVisible(false);
                }

                if (rs.getString("C8").equals("P")) {
                    picture.uploadImage("okay", status);
                    present.setSelected(true);
                } else if (rs.getString("C8").equals("L")) {
                    picture.uploadImage("leave", status);
                    leave.setSelected(true);
                } else {
                    picture.uploadImage("absence", status);
                    absence.setSelected(true);
                }
                //adding Action
                Pic.add(selection, 1, 1);
                Pic.add(circle, 2, 1);
                action.add(present, 1, 1);
                action.add(absence, 1, 2);
                action.add(leave, 1, 3);
                action.add(text1, 2, 1);
                action.add(text2, 2, 2);
                action.add(text3, 2, 3);
                data.add(new Logic.TableList(Pic, C1, C2, C3, C4, action, status, print));
            }
            Table_1.setItems(data);
            this.textStatus("", classCheck, day, month, year);
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    public void remove_Add_Selection(String Id) {
        for (int i = 0; i < select_List.size(); i++) {
            if (Id.equals(select_List.get(i))) {
                select_List.remove(i);
            }
        }
    }

    private void search() {
        search.setOnKeyReleased(e -> {
            Table_1.getItems().clear();
            if (search.getText().equals("")) {
                AddAttendanceController.this.LoadData_1(day, month, year);
            } else {
                data.clear();
                Table_1.getItems().clear();

                try {
                    String table_Check = changeClass.getValue().toString();
                    con = sqlConnection.ConnectDB();

                    String sql1 = "";
                    if (table_Check.equals("All School") || table_Check.equals("All Employs")) {
                        sql1 = "Select * from attendance where C5 like '%" + search.getText() + "%'"
                                + "UNION Select * from attendance where C6 like '%" + search.getText() + "%' And C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C9='" + checkPane + "'";
                    } else {
                        sql1 = "Select * from attendance where C5 like '%" + search.getText() + "%'"
                                + "UNION Select * from attendance where C6 like '%" + search.getText() + "%' And C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C7='" + table_Check + "' And C9='" + checkPane + "'";
                    }
                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    while (rs.next()) {
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
                        GridPane Pic = new GridPane();
                        //Setting size for the pane  
                        Pic.setMinSize(100, 40);
                        //Setting the vertical and horizontal gaps between the columns 
                        Pic.setVgap(0.5);
                        // gridPane.setHgap(0);
                        Pic.setAlignment(Pos.CENTER);
                        //adding button
                        //Drawing a Circle
                        Circle status = new Circle();
                        //Setting the properties of the circle
                        status.setCenterX(300.0f);
                        status.setCenterY(135.0f);
                        status.setRadius(25.0f);
                        //Setting other properties
                        status.setFill(Color.LIGHTGRAY);
                        String C1 = rs.getString("C2") + "/" + rs.getString("C3") + "/" + rs.getString("C4");
                        String C2 = rs.getString("C5");
                        String C3 = rs.getString("C6");
                        String C4 = rs.getString("C7");
                        //adding print
                        Button print = new Button();
                        print.getStyleClass().add("print_Button");
                        print.setId(rs.getString("C0"));
                        print.setOnAction(e1 -> {
                            // row_Id = ((Control) e.getSource()).getId();
                        });
                        picture.uploadImage(mode_Select.getValue().toString() + rs.getString("C5"), circle);
                        status.setId(rs.getString("C0"));
                        Text text1 = new Text("Present");
                        Text text2 = new Text("Absence");
                        Text text3 = new Text("Leave");

                        text1.getStyleClass().add("check-text");
                        text2.getStyleClass().add("check-text");
                        text3.getStyleClass().add("check-text");

                        CheckBox present = new CheckBox();
                        CheckBox absence = new CheckBox();
                        CheckBox leave = new CheckBox();
                        CheckBox selection = new CheckBox();

                        present.getStyleClass().add("check-box");
                        absence.getStyleClass().add("check-box");
                        leave.getStyleClass().add("check-box");
                        selection.getStyleClass().add("check-box");

                        //present
                        present.setId(rs.getString("C0"));
                        present.setOnAction(e2 -> {
                            picture.uploadImage("okay", status);
                            absence.setSelected(false);
                            leave.setSelected(false);
                            this.UpdateAttandance(((Control) e2.getSource()).getId(), "P");
                            this.textStatus("", classCheck, day, month, year);
                        });
                        //absence
                        absence.setId(rs.getString("C0"));
                        absence.setOnAction(e3 -> {
                            picture.uploadImage("absence", status);
                            present.setSelected(false);
                            leave.setSelected(false);
                            this.UpdateAttandance(((Control) e3.getSource()).getId(), "A");
                            this.textStatus("", classCheck, day, month, year);
                        });
                        //Leaves
                        leave.setId(rs.getString("C0"));
                        leave.setOnAction(e4 -> {
                            picture.uploadImage("leave", status);
                            absence.setSelected(false);
                            present.setSelected(false);
                            this.UpdateAttandance(((Control) e4.getSource()).getId(), "L");
                            this.textStatus("", classCheck, day, month, year);
                        });
                        //Selection
                        selection.setId(rs.getString("C0"));
                        selection.setOnAction(e5 -> {
                            if (selection.isSelected()) {
                                select_List.add(((Control) e5.getSource()).getId());
                            } else {
                                this.remove_Add_Selection(((Control) e5.getSource()).getId());
                            }
                        });
                        //Set Select Check
                        if (selection_Check) {
                            selection.setVisible(true);
                            selection.setSelected(selection_Check);
                        } else {
                            selection.setVisible(false);
                        }

                        if (rs.getString("C8").equals("P")) {
                            picture.uploadImage("okay", status);
                            present.setSelected(true);
                        } else if (rs.getString("C8").equals("L")) {
                            picture.uploadImage("leave", status);
                            leave.setSelected(true);
                        } else {
                            picture.uploadImage("absence", status);
                            absence.setSelected(true);
                        }
                        //adding Action
                        Pic.add(selection, 1, 1);
                        Pic.add(circle, 2, 1);
                        action.add(present, 1, 1);
                        action.add(absence, 1, 2);
                        action.add(leave, 1, 3);
                        action.add(text1, 2, 1);
                        action.add(text2, 2, 2);
                        action.add(text3, 2, 3);
                        data.add(new Logic.TableList(Pic, C1, C2, C3, C4, action, status, print));
                    }
                    Table_1.setItems(data);

                } catch (SQLException ex) {
                    Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {

                    this.CloseConnection();
                }
            }
        });
    }

    //select Cell
    private void SelectCell() {
        Table_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Logic.TableList t = Table_1.getItems().get(Table_1.getSelectionModel().getSelectedIndex());
                AddAttendanceController.this.textStatus(t.getC2(), classCheck, day, month, year);

            }
        });
    }

    public void UpdateAttandance(String Id, String attendance) {
        try {
            con = sqlConnection.ConnectDB();
            String sql = "update attendance set C8='" + attendance
                    + "' where C0='" + Id + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void textStatus(String Id, String table_Check, String day, String month, String year) {
        int i = 0,
                P = 0,
                L = 0,
                A = 0;
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "";
            if (Id.isEmpty()) {
                if (table_Check.equals("All School") || table_Check.equals("All Employs")) {
                    sql1 = "Select * from attendance where C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C9='" + checkPane + "'";
                } else {
                    sql1 = "Select * from attendance where C2= '" + day + "' And C3='" + month + "' And C4='" + year + "' And C7='" + table_Check + "' And C9='" + checkPane + "'";
                }
                check_Text.setText("Total Strength");
            } else {
                sql1 = "Select * from attendance where C5= '" + Id + "' And C3='" + month + "' And C4='" + year + "' And C9='" + checkPane + "'";
                check_Text.setText("Total Days");
            }
            rs2 = stmt.executeQuery(sql1);
            while (rs2.next()) {
                select_List.add(rs2.getString("C0"));
                i++;
                if (rs2.getString("C8").equals("A")) {
                    A++;
                } else if (rs2.getString("C8").equals("P")) {
                    P++;
                } else {
                    L++;
                }
            }
            total_Text.setText(String.valueOf(i));
            present_Text.setText(String.valueOf(P));
            absence_Text.setText(String.valueOf(A));
            leave_Text.setText(String.valueOf(L));
            if (P == i) {
                avrage_Text.setText("100 %");
            } else {
                int percent = P * 100 / i;
                avrage_Text.setText(String.valueOf(percent) + " %");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    public void load_Student_Attendance(String day, String month, String year) {
        try {
            rs = logic.getAllData("student");
            while (rs.next()) {
                boolean check = true;
                con = sqlConnection.ConnectDB();
                pst = con.prepareStatement("Select * from attendance where C5='" + rs.getString("C1") + "' AND C2='" + day + "' AND C3='" + month + "' AND C4='" + year + "' And C9='Student'");
                rs2 = pst.executeQuery();
                while (rs2.next()) {
                    check = false;
                    break;
                }
                if (check) {
                    String sq = "insert into attendance(C1,C2,C3,C4,C5,C6,C7,C8,C9)values('"
                            + logic.getTime()
                            + "','" + day
                            + "','" + month
                            + "','" + year
                            + "','" + rs.getString("C1")
                            + "','" + rs.getString("C3")
                            + "','" + rs.getString("C10")
                            + "','" + "A"
                            + "','" + mode_Select.getValue().toString()
                            + "')";

                    pst = con.prepareStatement(sq);
                    pst.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    public void load_Employ_Attendance(String day, String month, String year) {
        try {
            rs = logic.getAllData("employ");
            while (rs.next()) {
                boolean check = true;
                con = sqlConnection.ConnectDB();
                pst = con.prepareStatement("Select * from attendance where C5='" + rs.getString("C1") + "' AND C2='" + day + "' AND C3='" + month + "' AND C4='" + year + "' And C9='Employ'");
                rs2 = pst.executeQuery();
                while (rs2.next()) {
                    check = false;
                    break;
                }
                if (check) {
                    String sq = "insert into attendance(C1,C2,C3,C4,C5,C6,C7,C8,C9)values('"
                            + logic.getTime()
                            + "','" + day
                            + "','" + month
                            + "','" + year
                            + "','" + rs.getString("C1")
                            + "','" + rs.getString("C3")
                            + "','" + rs.getString("C6")
                            + "','" + "A"
                            + "','" + mode_Select.getValue().toString()
                            + "')";

                    pst = con.prepareStatement(sq);
                    pst.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
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
                    AddAttendanceController.this.LoadData_1(day, month, year);
                }
            }
        }
        );

    }

    public void ChangePane() {
        mode_Select.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    checkPane = newValue;
                    if (checkPane.equals("Student")) {
                        //loading list
                        list.clear();
                        list.add("All School");
                        list.addAll(data_value.getClasses());
                        changeClass.setItems(list);
                        changeClass.setValue("All School");
                        classCheck = changeClass.getValue().toString();
                        //loading students
                        AddAttendanceController.this.load_Student_Attendance(day, month, year);
                        //Adding attendance
                        AddAttendanceController.this.LoadData_1(day, month, year);
                        //changing table name
                        C1_5.setText("Class Name");
                    } else {
                        //loading list
                        list.clear();
                        list.add("All Employs");
                        list.addAll(data_value.Designation());
                        changeClass.setItems(list);
                        changeClass.setValue("All Employs");
                        classCheck = changeClass.getValue().toString();
                        //loading students
                        AddAttendanceController.this.load_Employ_Attendance(day, month, year);
                        //Adding attendance
                        AddAttendanceController.this.LoadData_1(day, month, year);
                        //changing table name
                        C1_5.setText("Designation");
                    }
                }
            }
        }
        );

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
    private void mainPrint_On_Clicked(MouseEvent event) {
    }

    @FXML
    private void deleteall_OnClicked(MouseEvent event) {
        if (dialog.confirm_Dialog(mainPane, "You want to delete Selected Attendance")) {
            int j = 0;
            for (int i = 0; i < data.size(); i++) {
                try {
                    String sq = "delete  from attendance where C2 ='" + day + "' And C3 ='" + month + "' And C4 ='" + year + "' And C5 ='" + data.get(i).getC2() + "' And C9 ='" + checkPane + "'";
                    con = sqlConnection.ConnectDB();
                    pst = con.prepareStatement(sq);
                    j = pst.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(AddAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (j == 1) {
                dialog.Notofication("Delete Attendance", "Successfuly deleted all Attendance", "okay");
                this.LoadData_1(day, month, year);
            }
        }
    }

    @FXML
    private void attendanceDate_On_Cllicked(ActionEvent event
    ) {
        if (!attendanceDate.getValue().toString().isEmpty()) {
            String temp[] = attendanceDate.getValue().toString().split("-");
            year = temp[0];
            month = logic.getMonth(temp[1]);
            day = temp[2];
            date_Text.setText(day + " " + month + " " + year);
            AddAttendanceController.this.LoadData_1(day, month, year);

        }
    }

    @FXML
    private void select_All_On_Clicked(ActionEvent event) {
        select_List.clear();
        if (select_All_Check.isSelected()) {
            selection_Check = true;
            AddAttendanceController.this.LoadData_1(day, month, year);
        } else {
            selection_Check = false;
        }
        AddAttendanceController.this.LoadData_1(day, month, year);
    }

    @FXML
    private void all_Present_On_Clicked(ActionEvent event) {
        if (select_List.isEmpty() && select_All_Check.isSelected()) {
            dialog.Notofication("Selection", "First Select All", "Wrong");
        } else {
            for (int i = 0; i < select_List.size(); i++) {
                this.UpdateAttandance(select_List.get(i), "P");
            }
            selection_Check = false;
            select_All_Check.setSelected(selection_Check);
            AddAttendanceController.this.LoadData_1(day, month, year);
        }
    }

    @FXML
    private void all_Absence_On_Clicked(ActionEvent event) {
        if (select_List.isEmpty() && select_All_Check.isSelected()) {
            dialog.Notofication("Selection", "First Select All", "Wrong");
        } else {
            for (int i = 0; i < select_List.size(); i++) {
                this.UpdateAttandance(select_List.get(i), "A");
            }
            selection_Check = false;
            select_All_Check.setSelected(selection_Check);
            AddAttendanceController.this.LoadData_1(day, month, year);
        }
    }

}
