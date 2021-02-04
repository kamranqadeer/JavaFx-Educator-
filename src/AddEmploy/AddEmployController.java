/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddEmploy;

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
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import org.controlsfx.validation.ValidationSupport;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class AddEmployController implements Initializable {

    TranslateTransition openNav, closeNav, educOpen, educClose;
    ValidationSupport validationSupport = new ValidationSupport();
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
    private ObservableList<Logic.TableList> data;
    private ObservableList<Logic.TableList> data2;
    private ObservableList<Logic.TableList> data3;

    boolean check = false;
    String Id = "",
            C1 = "",
            C2 = "",
            C3 = "",
            C4 = "",
            C5 = "",
            C6 = "",
            C7 = "",
            C8 = "",
            C9 = "",
            C10 = "",
            C11 = "",
            C2_2 = "",
            C2_3 = "",
            C2_4 = "",
            C2_5 = "",
            C2_6 = "",
            C3_2 = "",
            C3_3 = "",
            C3_4 = "",
            C3_5 = "",
            C3_6 = "",
            C3_7 = "",
            C3_8 = "",
            C3_9 = "",
            C3_10 = "",
            C3_11 = "",
            C3_12 = "",
            C3_13 = "",
            C3_14 = "",
            C3_15 = "",
            row_Id = "",
            salaryId = "";
    @FXML
    private TableView<Logic.TableList> Table_1;
    @FXML
    private TableView<Logic.TableList> Table_2;
    @FXML
    private Circle Circle_User;
    @FXML
    private Circle circle_Came;
    @FXML
    private JFXTextField degreeName;
    @FXML
    private JFXTextField regNo;
    @FXML
    private ComboBox degreeStatus;
    @FXML
    private ComboBox percentage;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private ComboBox religion;
    @FXML
    private ComboBox gender;
    @FXML
    private ComboBox designation;
    @FXML
    private JFXTextField salary;
    @FXML
    private JFXTextField email;
    @FXML
    private DatePicker joiningDate;
    @FXML
    private JFXTextField contactNumber;
    @FXML
    private JFXTextField cnic;
    @FXML
    private JFXTextField currentAddress;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_1;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_2;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_3;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_4;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_5;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_6;
    @FXML
    private TableColumn<Logic.TableList, String> col_1_7;
    @FXML
    private TableColumn<Logic.TableList, String> col_2_1;
    @FXML
    private TableColumn<Logic.TableList, String> col_2_2;
    @FXML
    private TableColumn<Logic.TableList, String> col_2_3;
    @FXML
    private TableColumn<Logic.TableList, String> col_2_4;
    @FXML
    private TableColumn<Logic.TableList, String> col_2_5;
    @FXML
    private TableColumn<Logic.TableList, String> col_2_6;
    @FXML
    private ComboBox code;
    @FXML
    private Text countEmpoly;
    @FXML
    private StackPane main_Pane;
    @FXML
    private AnchorPane addEmployPane;
    @FXML
    private GridPane mainGrid;
    @FXML
    private AnchorPane eduPane;
    @FXML
    private TableView<Logic.TableList> Table_3;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_1;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_2;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_3;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_4;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_5;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_6;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_7;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_8;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_9;
    @FXML
    private TableColumn<Logic.TableList, String> col_3_10;
    @FXML
    private ComboBox Year;
    @FXML
    private JFXTextField cutting;
    @FXML
    private JFXTextField finalSalary;
    @FXML
    private JFXTextField discription;
    @FXML
    private JFXTextField paySalary;
    @FXML
    private JFXTextField leftSalary;
    @FXML
    private Text absence;
    @FXML
    private Text leaves;
    @FXML
    private Text attendance;
    @FXML
    private DatePicker pay_Date;
    @FXML
    private JFXTextField mainSalary;
    @FXML
    private Text leftAmount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Slide Nave
        openNav = new TranslateTransition(new Duration(350), addEmployPane);
        openNav.setToX(0);
        closeNav = new TranslateTransition(new Duration(350), addEmployPane);
        educOpen = new TranslateTransition(new Duration(350), eduPane);
        educOpen.setToX(0);
        educClose = new TranslateTransition(new Duration(350), eduPane);
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data3 = FXCollections.observableArrayList();
        data_value.SetComBox(code, "getAllCodes");
        data_value.SetComBox(religion, "getReligion");
        data_value.SetComBox(gender, "getGender");
        data_value.SetComBox(designation, "Designation");
        data_value.SetComBox(degreeStatus, "DegreeStatus");
        data_value.SetComBox(percentage, "Percintage");
        //setTable 1
        this.setTable_1();
        this.loadTable1();
        this.SelectCell();
        this.search();
        // this.search();
        Year.setValue(logic.getYear());
        Year.setItems(data_value.getYear());
        //setTable 2
        this.setTabe_2();
        //setTable 3
        this.setTabe_3();
        this.Salary();
        this.SalaryYear();
        C2 = logic.getDay() + "-" + logic.getMonth() + "-" + logic.getYear();
        joiningDate.setPromptText(C2);
        pay_Date.setPromptText(C2);
        picture.uploadImage("", Circle_User);
        picture.uploadImage("camera", circle_Came);
        //Employ Details Validations
        validation.Name_1(firstName);
        validation.Name_1(lastName);
        validation.Name_2(regNo);
        validation.Number2(mainSalary);
        validation.email(email);
        validation.ContactNo(contactNumber);
        validation.CNIC(cnic);
        //Employ Education Validations
        validation.Name_2(degreeName);
        validation.Discription(currentAddress);
        //Employ Salary Validations
        validation.Discription(discription);
        validation.Number2(paySalary);

    }
    //    SetTable

    public void setTable_1() {
        col_1_1.setCellValueFactory(new PropertyValueFactory<>("C1"));
        col_1_2.setCellValueFactory(new PropertyValueFactory<>("C2"));
        col_1_3.setCellValueFactory(new PropertyValueFactory<>("C3"));
        col_1_4.setCellValueFactory(new PropertyValueFactory<>("C4"));
        col_1_5.setCellValueFactory(new PropertyValueFactory<>("C5"));
        col_1_6.setCellValueFactory(new PropertyValueFactory<>("C6"));
        col_1_7.setCellValueFactory(new PropertyValueFactory<>("gridPane"));
    }

    public void setTabe_2() {
        col_2_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        col_2_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        col_2_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        col_2_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        col_2_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        col_2_6.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    public void setTabe_3() {
        col_3_1.setCellValueFactory(new PropertyValueFactory<>("C1"));
        col_3_2.setCellValueFactory(new PropertyValueFactory<>("C2"));
        col_3_3.setCellValueFactory(new PropertyValueFactory<>("gridPane2"));
        col_3_4.setCellValueFactory(new PropertyValueFactory<>("C4"));
        col_3_5.setCellValueFactory(new PropertyValueFactory<>("C5"));
        col_3_6.setCellValueFactory(new PropertyValueFactory<>("C6"));
        col_3_7.setCellValueFactory(new PropertyValueFactory<>("C7"));
        col_3_8.setCellValueFactory(new PropertyValueFactory<>("C8"));
        col_3_9.setCellValueFactory(new PropertyValueFactory<>("C9"));
        col_3_10.setCellValueFactory(new PropertyValueFactory<>("print"));

    }

    public boolean Validation_1() {
        if (!validation.CheckEmpty(firstName, "First Name is required !")
                || !validation.CheckEmpty(lastName, "Last Name is required !")
                || !validation.CheckEmpty(mainSalary, "Salary is required !")
                || !validation.CheckEmpty(email, "Email is required !")
                || !validation.CheckEmpty(contactNumber, "CNIC is required !")
                || !validation.CheckEmpty(currentAddress, "Current Address is required !")) {
            return false;
        } else {
            C3 = firstName.getText() + " " + lastName.getText();
            C4 = religion.getValue().toString();
            C5 = gender.getValue().toString();
            C6 = designation.getValue().toString();
            C7 = mainSalary.getText();
            C8 = email.getText();
            C9 = code.getValue().toString() + "-" + contactNumber.getText();
            C10 = cnic.getText();
            C11 = currentAddress.getText();
            return true;
        }
    }

    public boolean Validation_2() {
        if (!validation.CheckEmpty(degreeName, "Degree Name is requird !")
                || !validation.CheckEmpty(regNo, "Reg No / Location is required !")) {
            return false;
        } else {
            C2_2 = Id;
            C2_3 = degreeName.getText();
            C2_4 = regNo.getText();
            C2_5 = degreeStatus.getValue().toString();
            C2_6 = percentage.getValue().toString();
            return true;
        }
    }

    public boolean Validation_3() {
        if (!validation.CheckEmpty(paySalary, "Pay Salary is requird !")) {
            return false;
        } else {
            C3_2 = logic.getDay();
            C3_3 = logic.getMonth();
            C3_4 = logic.getYear();
            C3_5 = Id;
            C3_6 = salary.getText();
            if (Double.valueOf(C3_15) == 0) {
                C3_7 = "Don";
            } else if (Double.valueOf(paySalary.getText()) != 0) {
                C3_7 = "Some";
            } else {
                C3_7 = "Left";
            }
            C3_8 = leaves.getText();
            C3_9 = absence.getText();
            C3_10 = attendance.getText();
            C3_11 = cutting.getText();
            C3_12 = discription.getText();
            C3_13 = finalSalary.getText();
            C3_14 = paySalary.getText();
            return true;
        }
    }

    public void Salary() {
        paySalary.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (Double.valueOf(newValue) > Double.valueOf(salary.getText())) {
                    paySalary.setText(oldValue);
                }

                double left = Double.valueOf(salary.getText()) - Double.valueOf(paySalary.getText());
                leftSalary.setText(numberFormat.format(left) + " Rs");
                C3_15 = numberFormat.format(left);

            } else {

                C3_15 = salary.getText();
                leftSalary.setText(C3_15 + " Rs");
                // paySalary.setText("0.0");
            }
        });
    }

    private void search() {
        search.setOnKeyReleased(e -> {
            Table_2.getItems().clear();
            if (search.getText().equals("")) {
                this.loadTable1();
            } else {
                data.clear();
                Table_1.getItems().clear();

                try {
                    con = sqlConnection.ConnectDB();
                    String sql1 = "Select * from employ where C1 like '%" + search.getText() + "%'"
                            + "UNION Select * from employ where C3 like '%" + search.getText() + "%'"
                            + "UNION Select * from employ where C6 like '%" + search.getText() + "%'";

                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    int i = 0;
                    while (rs.next()) {
                        //Creating a Grid Pane 
                        GridPane action = new GridPane();
                        //Setting size for the pane  
                        action.setMinSize(100, 40);
                        //Setting the padding  
                        action.setPadding(new Insets(5, 5, 5, 5));
                        //Setting the vertical and horizontal gaps between the columns 
                        action.setVgap(0.5);
                        // gridPane.setHgap(0);
                        //Setting the Grid alignment 
                        action.setAlignment(Pos.CENTER);

                        //Arranging all the nodes in the grid 
                        //Drawing a Circle
                        Circle circle = new Circle();
                        //Setting the properties of the circle
                        circle.setCenterX(300.0f);
                        circle.setCenterY(135.0f);
                        circle.setRadius(40.0f);
                        //Setting other properties
                        circle.setFill(Color.LIGHTGRAY);
                        circle.setStrokeWidth(1.0);
                        circle.setStroke(Color.WHITE);
                        //  String C0 = String.valueOf(++i);
                        String C1 = rs.getString("C1");
                        String C2 = rs.getString("C2");
                        String C3 = rs.getString("C3");
                        String C4 = rs.getString("C6");
                        String C5 = rs.getString("C9");
                        String C6 = rs.getString("C8");

                        //adding details
                        Button education = new Button();
                        education.getStyleClass().add("educa_Button");
                        education.setId(C1);
                        education.setOnAction(e1 -> {
                            this.loadTable2(((Control) e1.getSource()).getId());
                            if (eduPane.getTranslateX() != 0) {
                                educOpen.play();
                                mainGrid.setEffect(null);
                            } else {
                                educClose.setToX(-(eduPane.getWidth()));
                                educClose.play();
                                mainGrid.setEffect(blur);
                            }
                        });
                        //adding print
                        Button print = new Button();
                        print.getStyleClass().add("print_Button");
                        print.setId(C1);
                        print.setOnAction(e2 -> {
                            //Print
                        });
                        //adding Actions
                        action.add(education, 1, 1);
                        action.add(print, 2, 1);
                        data.add(new Logic.TableList(C1, C2, C3, C4, C5, C6, action));
                        ++i;
                        this.LoadSalary(C1, rs.getString("C7"));
                    }
                    Table_1.setItems(data);

                } catch (SQLException ex) {
                    Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {

                    this.CloseConnection();
                }
            }
        });
    }
//

//
    public void loadTable1() {
        data.clear();
        Table_1.getItems().clear();
        try {
            rs = logic.getAllData("employ");
            int i = 0;
            while (rs.next()) {
                //Creating a Grid Pane 
                GridPane action = new GridPane();
                //Setting size for the pane  
                action.setMinSize(100, 40);
                //Setting the padding  
                action.setPadding(new Insets(5, 5, 5, 5));
                //Setting the vertical and horizontal gaps between the columns 
                action.setVgap(0.5);
                // gridPane.setHgap(0);
                //Setting the Grid alignment 
                action.setAlignment(Pos.CENTER);

                //Arranging all the nodes in the grid 
                //Drawing a Circle
                Circle circle = new Circle();
                //Setting the properties of the circle
                circle.setCenterX(300.0f);
                circle.setCenterY(135.0f);
                circle.setRadius(40.0f);
                //Setting other properties
                circle.setFill(Color.LIGHTGRAY);
                circle.setStrokeWidth(1.0);
                circle.setStroke(Color.WHITE);
                //  String C0 = String.valueOf(++i);
                String C1 = rs.getString("C1");
                String C2 = rs.getString("C2");
                String C3 = rs.getString("C3");
                String C4 = rs.getString("C6");
                String C5 = rs.getString("C9");
                String C6 = rs.getString("C8");

                //adding details
                Button education = new Button();
                education.getStyleClass().add("educa_Button");
                education.setId(C1);
                education.setOnAction(e -> {
                    this.loadTable2(((Control) e.getSource()).getId());
                    if (eduPane.getTranslateX() != 0) {
                        educOpen.play();
                        mainGrid.setEffect(null);
                    } else {
                        educClose.setToX(-(eduPane.getWidth()));
                        educClose.play();
                        mainGrid.setEffect(blur);
                    }
                });
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(C1);
                print.setOnAction(e -> {
                    //Print
                });
                //adding Actions
                action.add(education, 1, 1);
                action.add(print, 2, 1);
                data.add(new Logic.TableList(C1, C2, C3, C4, C5, C6, action));
                ++i;
                this.LoadSalary(C1, rs.getString("C7"));
            }
            countEmpoly.setText(String.valueOf(i));
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_1.setItems(data);
        //   logic.Table_Resize(Table_1, 80);
    }
//
    //load Table 2

    public void loadTable2(String Id) {
        this.Id = Id;
        data2.clear();
        Table_2.getItems().clear();
        try {
            rs = logic.getTable_Data("employdetails", Id, "C2", "C1");
            int i = 0;
            while (rs.next()) {
                //adding button
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(String.valueOf(i));
                remove.setOnAction(e -> {
                    row_Id = ((Control) e.getSource()).getId();
                    this.deleteTable_2();
                });
                String no = String.valueOf(++i);
                String C1 = rs.getString("C3");
                String C2 = rs.getString("C4");
                String C3 = rs.getString("C5");
                String C4 = rs.getString("C6");

                data2.add(new Logic.TableList(no, C1, C2, C3, C4, remove));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_2.setItems(data2);
    }
    //load Table 2

    public void loadTable3(String Id, String Year) {
        this.Id = Id;
        data3.clear();
        Table_3.getItems().clear();
        double total = 0.0;
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select * from employsalary where C4='" + Year + "' AND C5='" + Id + "'";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                //Creating a Grid Pane 
                GridPane salary = new GridPane();
                //Setting size for the pane  
                salary.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                salary.setVgap(0.5);
                // gridPane.setHgap(0);
                //Setting the Grid alignment 
                salary.setAlignment(Pos.CENTER);
                String C1 = rs.getString("C3");
                String C2 = rs.getString("C6");
                String C3 = rs.getString("C7");
                String C4 = rs.getString("C9");
                String C5 = rs.getString("C11");
                String C6 = rs.getString("C12");
                String C7 = rs.getString("C13");
                String C8 = rs.getString("C14");
                String C9 = rs.getString("C15");
                //All Button
                //adding button
                Text salary_Amount = new Text(C3);
                salary_Amount.setFill(Color.WHITE);
                Button PaySalary = new Button();
                if (C3.equals("Not")) {
                    PaySalary.getStyleClass().add("Error_Button");
                } else if (C3.equals("Some")) {
                    PaySalary.getStyleClass().add("Some_Button");
                } else {
                    PaySalary.getStyleClass().add("confirm_Button");

                }
                PaySalary.setId(rs.getString("C1"));
                PaySalary.setOnAction(e -> {
                    salaryId = ((Control) e.getSource()).getId();
                    this.paySalary(salaryId);
                });
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(C1);
                print.setOnAction(e -> {
                    //Print
                    salaryId = ((Control) e.getSource()).getId();
                });
                //adding salary
                salary.add(salary_Amount, 1, 1);
                salary.add(PaySalary, 2, 1);
                data3.add(new Logic.TableList(logic.getMonth(C1), C2, salary, C4, C5, C6, C7, C8, C9, print));
                total += Double.valueOf(C9);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_3.setItems(data3);
        leftAmount.setText(numberFormat.format(total) + " Rs");
    }

// edit Table 3
    public void paySalary(String Id) {
        try {
            rs = logic.getTable_Data("employsalary", Id, "C1", "C1");
            while (rs.next()) {
                pay_Date.setPromptText(rs.getString("C2") + logic.getMonth(rs.getString("C3") + rs.getString("C4")));
                salary.setText(rs.getString("C6"));
                leaves.setText(rs.getString("C8"));
                absence.setText(rs.getString("C9"));
                attendance.setText(rs.getString("C10"));
                cutting.setText(rs.getString("C11"));
                discription.setText(rs.getString("C12"));
                finalSalary.setText(rs.getString("C13"));
                paySalary.setText(rs.getString("C14"));
                leftSalary.setText(rs.getString("C15"));
                if (addEmployPane.getTranslateX() != 0) {
                    openNav.play();
                    mainGrid.setEffect(null);
                } else {
                    closeNav.setToX(-(addEmployPane.getWidth()));
                    closeNav.play();
                    mainGrid.setEffect(blur);
                }
            }
            paySalary.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Delete Table 2 Row

    public void deleteTable_2() {
        for (int i = 0; i < data2.size(); i++) {
            if (String.valueOf(i).equals(row_Id)) {
                if (dialog.confirm_Dialog(main_Pane, "You want to delete Employ Details")) {
                    logic.deleteData("employdetails", "C3", data2.get(i).getC1());
                    dialog.Notofication("Deleting", "Employ Details is successfuly deleted", "okay");
                    if (eduPane.getTranslateX() != 0) {
                        educOpen.play();
                        mainGrid.setEffect(null);
                    } else {
                        educClose.setToX(-(eduPane.getWidth()));
                        educClose.play();
                        mainGrid.setEffect(blur);
                    }
                }
                break;
            }
        }
    }
//

    public void SaveData_1() {
        try {
            //geting one pice cost if scale is Dozen

            if (!logic.Check_Id("employ", "C3", C3).isEmpty()) {
                dialog.Notofication("Error", "This Employ already Exist !", "Wrong");
            } else {
                con = sqlConnection.ConnectDB();
                String sq = "insert into employ(C2,C3,C4,C5,C6,C7,C8,C9,C10,C11)values('"
                        + C2
                        + "','" + C3
                        + "','" + C4
                        + "','" + C5
                        + "','" + C6
                        + "','" + C7
                        + "','" + C8
                        + "','" + C9
                        + "','" + C10
                        + "','" + C11 + "')";

                pst = con.prepareStatement(sq);
                pst.execute();
                dialog.Notofication("Adding Class", "SuccessFuly Adding new Class", "okay");
                this.loadTable1();
                this.Clear_1();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }
//

    public void Update() {
        try {
            if (logic.Check_Id("employ", "C3", firstName.getText() + " " + lastName.getText()).isEmpty()) {
                dialog.Notofication("Note", "This Employ is not exist", "Wrong");
            } else {

                //geting one pice cost if scale is Dozen
                con = sqlConnection.ConnectDB();
                String sql = "update employ set C4='" + C4
                        + "',C5='" + C5
                        + "',C6='" + C6
                        + "',C7='" + C7
                        + "',C8='" + C8
                        + "',C9='" + C9
                        + "',C11='" + C11
                        + "' where C1='" + Id + "'";
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                dialog.Notofication("Note", "Teacher Name/CNIC will be same.", "Wrong");
                dialog.Notofication("Updating Class", "SuccessFuly Updated", "okay");
                this.loadTable1();
                this.Clear_1();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

// update Table 3
    public void UpdateSalary(String Id) {
        try {
            //geting one pice cost if scale is Dozen
            con = sqlConnection.ConnectDB();
            String sql = "update employsalary set C2='" + C3_2
                    + "',C7='" + C3_7
                    + "',C8='" + C3_8
                    + "',C9='" + C3_9
                    + "',C10='" + C3_10
                    + "',C11='" + C3_11
                    + "',C12='" + C3_12
                    + "',C13='" + C3_13
                    + "',C14='" + C3_14
                    + "',C15='" + C3_15
                    + "' where C1='" + Id + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            dialog.Notofication("Updating Salary", "SuccessFuly Updated", "okay");
            this.loadTable1();
            this.loadTable3(this.Id, logic.getYear());
            if (addEmployPane.getTranslateX() != 0) {
                openNav.play();
                mainGrid.setEffect(null);
            } else {
                closeNav.setToX(-(addEmployPane.getWidth()));
                closeNav.play();
                mainGrid.setEffect(blur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }
    //select Cell

    private void SelectCell() {
        Table_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Logic.TableList t = Table_1.getItems().get(Table_1.getSelectionModel().getSelectedIndex());
                Id = t.getC1();
                if (!Id.isEmpty()) {
                    try {
                        rs2 = logic.getTable_Data("employ", Id, "C1", "C1");
                        while (rs2.next()) {
                            String temp[] = rs2.getString("C3").split(" ");
                            firstName.setText(temp[0]);
                            lastName.setText(temp[1]);
                            religion.setValue(rs2.getString("C4"));
                            gender.setValue(rs2.getString("C5"));
                            designation.setValue(rs2.getString("C6"));
                            mainSalary.setText(rs2.getString("C7"));
                            email.setText(rs2.getString("C8"));
                            String temp2[] = rs2.getString("C9").split("-");
                            code.setValue(temp2[0]);
                            contactNumber.setText(temp2[1]);
                            cnic.setText(rs2.getString("C10"));
                            currentAddress.setText(rs2.getString("C11"));
                            AddEmployController.this.loadTable2(rs2.getString("C1"));
                            picture.uploadImage("Employ" + Id, Circle_User);
                            AddEmployController.this.loadTable3(Id, logic.getYear());
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        AddEmployController.this.CloseConnection();
                    }
                }
            }
        });
    }
//

    public void SaveData_2() {
        try {
            //geting one pice cost if scale is Dozen

            if (!logic.Check_Id("employdetails", "C3", C2_3).isEmpty()) {
                dialog.Notofication("Error", "This Details already added for this employ", "Wrong");
            } else {
                con = sqlConnection.ConnectDB();
                String sq = "insert into employdetails(C2,C3,C4,C5,C6)values('"
                        + C2_2
                        + "','" + C2_3
                        + "','" + C2_4
                        + "','" + C2_5
                        + "','" + C2_6 + "')";
                pst = con.prepareStatement(sq);
                pst.execute();
                dialog.Notofication("Adding Details", "SuccessFuly Adding new Degree Details", "okay");
                this.loadTable2(C2_2);
                this.Clear_2();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    @FXML
    private void Change_Image(MouseEvent event) {
        if (Id.isEmpty()) {
            dialog.Notofication("Error", "Fist Eneter the Id", "error");
        } else {
            if (picture.UploadPicture("Employ" + Id, Circle_User)) {
                dialog.Notofication("Save", "picture is updated", "okay");
            } else {
                dialog.Notofication("Error", "Location is not selected", "Wrong");
            }
        }
    }

    @FXML
    private void delete_Action(MouseEvent event) {
        if (Id.equals("")) {
            dialog.Notofication("Error", "Eneter Employ Id", "error");
        } else {
            if (dialog.confirm_Dialog(main_Pane, "You want to delete this Employ")) {
                logic.deleteData("employ", "C1", Id);
                logic.deleteData("employdetails", "C2", Id);
                logic.deleteData("employsalary", "C5", Id);
                picture.DeleteImage("Employ" + Id);
                this.loadTable1();
                Table_2.getItems().clear();
                this.Clear_1();
                this.Clear_2();
                dialog.Notofication("Deleting", "Employ is successfuly deleted", "okay");
            }
        }
    }

    @FXML
    private void details_add_On_Clicked(ActionEvent event) {
        if (this.Validation_2()) {
            this.SaveData_2();
        }
    }

    @FXML
    private void details_add_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_2()) {
                this.SaveData_2();
            }
        }
    }

    @FXML
    private void save_On_Clicked(ActionEvent event) {
        if (this.Validation_1()) {
            this.SaveData_1();
        }
    }

    @FXML
    private void save_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_1()) {
                this.SaveData_1();
            }
        }
    }

    @FXML
    private void update_On_Clicked(ActionEvent event) {
        if (this.Validation_1()) {
            this.Update();
        }
    }

    @FXML
    private void update_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_1()) {
                this.Update();
            }
        }
    }

    public void Clear_1() {
        firstName.clear();
        lastName.clear();
        email.clear();
        mainSalary.clear();
        contactNumber.clear();
        cnic.clear();
        currentAddress.clear();
        Table_2.getItems().clear();
    }
//

    public void Clear_2() {
        degreeName.clear();
        regNo.clear();
        degreeName.requestFocus();
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
    private void dateOnChange(ActionEvent event) {
        String temp[] = joiningDate.getValue().toString().split("-");
        String year = temp[0],
                month = temp[1],
                day = temp[2];
        C2 = day + logic.getMonth(month) + "_" + year;
    }

    @FXML
    private void backEduc_Action(MouseEvent event) {
        if (eduPane.getTranslateX() != 0) {
            educOpen.play();
            mainGrid.setEffect(null);
        } else {
            educClose.setToX(-(eduPane.getWidth()));
            educClose.play();
            mainGrid.setEffect(blur);
        }
    }

    @FXML
    private void close_Salary_Action(MouseEvent event) {
        if (addEmployPane.getTranslateX() != 0) {
            openNav.play();
            mainGrid.setEffect(null);
        } else {
            closeNav.setToX(-(addEmployPane.getWidth()));
            closeNav.play();
            mainGrid.setEffect(blur);
        }
    }

    @FXML
    private void all_Salay_Print(MouseEvent event) {
    }

    @FXML
    private void payDate_On_Action(ActionEvent event) {
        if (!pay_Date.getValue().toString().isEmpty()) {
            String temp[] = pay_Date.getValue().toString().split("-");
            String year = temp[0],
                    month = temp[1],
                    day = temp[2];
            C3_2 = day;
            C3_3 = month;
            C3_4 = year;
        }
    }

    @FXML
    private void paySalary_On_Clicked(ActionEvent event) {
        if (this.Validation_3()) {
            this.UpdateSalary(salaryId);
        }
    }

    @FXML
    private void pay_Salary_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_3()) {
                this.UpdateSalary(salaryId);
            }
        }
    }

    public void LoadSalary(String Id, String Salary) {
        try {
            boolean check = false;
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select C1 from employsalary where C3= '" + logic.getMonth() + "' AND C4='" + logic.getYear() + "' AND C5='" + Id + "'";
            rs2 = stmt.executeQuery(sql1);
            while (rs2.next()) {
                check = true;
            }
            if (!check) {
                String sq = "insert into employsalary(C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15)values('"
                        + logic.getDay()
                        + "','" + logic.getMonth()
                        + "','" + logic.getYear()
                        + "','" + Id
                        + "','" + Salary
                        + "','" + "Not"
                        + "','" + "0"
                        + "','" + "0"
                        + "','" + "0"
                        + "','" + "0"
                        + "','" + "Punctual and good performance"
                        + "','" + "0"
                        + "','" + "0"
                        + "','" + Salary + "')";
                pst = con.prepareStatement(sq);
                pst.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddEmployController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SalaryYear() {
        Year.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    if (Id.isEmpty()) {
                        dialog.Notofication("Error", "First Select Employ", "error");
                    } else {
                        AddEmployController.this.loadTable3(Id, newValue);
                    }
                }
            }
        }
        );

    }

}
