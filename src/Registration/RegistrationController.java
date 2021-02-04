/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

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
public class RegistrationController implements Initializable {

    TranslateTransition openNav, closeNav, openNav2, closeNav2;
    ObservableList<String> fieldData = FXCollections.observableArrayList();
    ObservableList<String> className = FXCollections.observableArrayList();
    ObservableList<String> fee = FXCollections.observableArrayList("All Fee", "Paid", "Un-Paid");
    ObservableList<String> feeSelectName = FXCollections.observableArrayList("All Fee", "Monthly Fee");
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
    String row_Id = "", fee_Id = "", DOB = "", joinDate = "", feeDate = "", classCheck = "All Students", feeCheck = "All Fee";
    @FXML
    private Circle Circle_User;
    @FXML
    private Circle circle_Came;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField RegistrationNo;
    @FXML
    private JFXTextField RollNo;
    @FXML
    private ComboBox nationalty;
    @FXML
    private ComboBox Religion;
    @FXML
    private JFXTextField Cast;
    @FXML
    private ComboBox Gender;
    @FXML
    private JFXTextField LastSchool;
    @FXML
    private ComboBox ClassName;
    @FXML
    private ComboBox RelativeName;
    @FXML
    private JFXTextField FatherName;
    @FXML
    private JFXTextField Cnic;
    @FXML
    private JFXTextField Address;
    @FXML
    private JFXTextField GuarianName;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField Number;
    @FXML
    private ComboBox Code1;
    @FXML
    private JFXTextField officeNumber;
    @FXML
    private ComboBox Code2;
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
    private TableColumn<Logic.TableList, String> C1_9;
    @FXML
    private TableColumn<Logic.TableList, String> C1_10;
    @FXML
    private JFXTextField Language;
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private Text ageText;
    @FXML
    private AnchorPane slidePane;
    @FXML
    private GridPane mainGrid;
    @FXML
    private JFXTextField search;
    @FXML
    private Text studentCount;
    @FXML
    private AnchorPane slidePane2;
    @FXML
    private JFXTextField leftAmount;
    @FXML
    private JFXTextField relifeAmount;
    @FXML
    private JFXTextField totalFee;
    @FXML
    private JFXTextField recivedAmount;
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
    private TableColumn<Logic.TableList, String> C2_6;
    @FXML
    private TableColumn<Logic.TableList, String> C2_7;
    @FXML
    private Text leftText;
    @FXML
    private DatePicker joiningDate;
    @FXML
    private CheckBox checkBox;
    @FXML
    private StackPane mainPane;
    @FXML
    private Text classText;
    @FXML
    private JFXTextField finalAmount;
    @FXML
    private JFXTextField TotalAttandnace;
    @FXML
    private JFXTextField TotalAbbance;
    @FXML
    private Text yearText;
    @FXML
    private JFXTextField totalLeaves;
    @FXML
    private JFXTextField feeName;
    @FXML
    private DatePicker feeTakingDate;
    @FXML
    private CheckBox newFeeCheckBox;
    @FXML
    private ComboBox feeSelect;
    @FXML
    private ComboBox changeClasses;
    @FXML
    private ComboBox feeChange;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Slide Nave

        openNav = new TranslateTransition(new Duration(350), slidePane);
        openNav.setToX(0);
        closeNav = new TranslateTransition(new Duration(350), slidePane);
        openNav2 = new TranslateTransition(new Duration(350), slidePane2);
        openNav2.setToX(0);
        closeNav2 = new TranslateTransition(new Duration(350), slidePane2);
        // TODO
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data_value.SetComBox(Code1, "getAllCodes");
        data_value.SetComBox(Code2, "getAllCodes");
        data_value.SetComBox(Religion, "getReligion");
        data_value.SetComBox(Gender, "getGender");
        data_value.SetComBox(nationalty, "Nationality");
        data_value.SetComBox(ClassName, "getClasses");
        data_value.SetComBox(RelativeName, "getStudents");

        //Run time validations
        this.RunTimeValidations();
        //set Table 1
        this.setTabe_1();
        this.loadTable1("All Students", "All Fee");
        //Set Table 2
        this.setTabe_2();
        picture.uploadImage("non", Circle_User);
        picture.uploadImage("camera", circle_Came);
        joinDate = logic.getDay() + "/" + logic.getMonth() + "/" + logic.getYear();
        DOB = joinDate;
        feeDate = joinDate;
        yearText.setText(logic.getYear());
        DateOfBirth.setPromptText(joinDate);
        feeTakingDate.setPromptText(joinDate);
        joiningDate.setPromptText(joinDate);
        feeSelect.setItems(feeSelectName);
        feeSelect.setValue("All Fee");
        changeClasses.setValue("All Students");
        className.add("All Students");
        className.addAll(data_value.getClasses());
        changeClasses.setItems(className);
        feeChange.setValue("All Fee");
        feeChange.setItems(fee);
        this.ChangeFeeName();
        this.ChangeCLasses();
        this.ChangeFeeType();
        this.relife();
        this.recivied();
        this.Search();

    }

    public void setTabe_1() {
        C1_1.setCellValueFactory(new PropertyValueFactory<>("circle"));
        C1_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C1_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C1_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C1_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        C1_6.setCellValueFactory(new PropertyValueFactory<>("C5"));
        C1_7.setCellValueFactory(new PropertyValueFactory<>("C6"));
        C1_8.setCellValueFactory(new PropertyValueFactory<>("C7"));
        C1_9.setCellValueFactory(new PropertyValueFactory<>("details"));
        C1_10.setCellValueFactory(new PropertyValueFactory<>("gridPane"));

    }

    public void setTabe_2() {
        C2_1.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C2_2.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C2_3.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C2_4.setCellValueFactory(new PropertyValueFactory<>("C4"));
        C2_5.setCellValueFactory(new PropertyValueFactory<>("C5"));
        C2_6.setCellValueFactory(new PropertyValueFactory<>("circle"));
        C2_7.setCellValueFactory(new PropertyValueFactory<>("gridPane"));
    }

    public void RunTimeValidations() {
        //Student Personal Details Validations
        validation.Name_1(firstName);
        validation.Name_1(lastName);
        validation.Name_2(RollNo);
        validation.Number2(RegistrationNo);
        validation.Name_2(Cast);
        validation.Name_2(LastSchool);
        //Student Guarian's Details
        validation.Name_2(FatherName);
        validation.CNIC(Cnic);
        validation.Discription(Address);
        validation.Name_2(GuarianName);
        validation.email(email);
        validation.ContactNo(Number);
        validation.ContactNo(officeNumber);
        validation.Name_2(Language);
        //fee details
        validation.Name_2(feeName);
        validation.Number2(relifeAmount);
        validation.Number2(recivedAmount);
    }

    public boolean Validation_1() {
        if (!validation.CheckEmpty(firstName, "First Name is required !")
                || !validation.CheckEmpty(lastName, "Last Name is required !")
                || !validation.CheckEmpty(RollNo, "Roll No is required !")
                || !validation.CheckEmpty(RegistrationNo, "Registration No is required !")
                || !validation.CheckEmpty(LastSchool, "Last School Name is required !")
                || !validation.CheckEmpty(FatherName, "Father Name is required !")
                || !validation.CheckEmpty(Cnic, "CNIC is required !")
                || !validation.CheckEmpty(Address, "Address is required !")
                || !validation.CheckEmpty(Number, "Mobile Number is required !")
                || !validation.CheckEmpty(officeNumber, "Office / Another Number is required !")) {
            return false;
        } else {
            fieldData.clear();
            fieldData.add(RollNo.getText());
            fieldData.add(RegistrationNo.getText());
            fieldData.add(firstName.getText() + " " + lastName.getText());
            fieldData.add(DOB);
            fieldData.add(nationalty.getValue().toString());
            fieldData.add(Religion.getValue().toString());
            fieldData.add(Cast.getText());
            fieldData.add(Gender.getValue().toString());
            fieldData.add(LastSchool.getText());
            fieldData.add(ClassName.getValue().toString());
            fieldData.add(RelativeName.getValue().toString());
            fieldData.add(FatherName.getText());
            fieldData.add(Cnic.getText());
            fieldData.add(Address.getText());
            fieldData.add(GuarianName.getText());
            fieldData.add(email.getText());
            fieldData.add(Code1.getValue().toString() + "-" + Number.getText());
            fieldData.add(Code2.getValue().toString() + "-" + officeNumber.getText());
            fieldData.add(Language.getText());
            fieldData.add(joinDate);
            fieldData.add("Not");
            return true;
        }
    }

    public boolean Validation_2() {
        if (!validation.CheckEmpty(feeName, "Fee Name is required !")
                || !validation.CheckEmpty(relifeAmount, "Relife Amount is required !")
                || !validation.CheckEmpty(recivedAmount, "Recived Amount is required !")) {
            return false;
        } else {
            double v = Double.valueOf(relifeAmount.getText()) * 100 / Double.valueOf(totalFee.getText());
            fieldData.clear();
            fieldData.add(logic.getDay());//0
            fieldData.add(logic.getMonth());//1
            fieldData.add(logic.getYear());//2
            fieldData.add(row_Id);//3
            fieldData.add(feeName.getText());//4
            fieldData.add(totalFee.getText());//5
            fieldData.add(numberFormat.format(v));//6
            fieldData.add(relifeAmount.getText());//7
            fieldData.add("0");//8
            fieldData.add(finalAmount.getText());//9
            fieldData.add(recivedAmount.getText());//10
            fieldData.add(leftAmount.getText());//11
            if (Double.valueOf(recivedAmount.getText()) == 0) {
                fieldData.add("Not");//12
            } else if (Double.valueOf(leftAmount.getText()) != 0) {
                fieldData.add("Left");//12
            } else {
                fieldData.add("Don");//12
            }
            fieldData.add(joinDate);//13
            return true;
        }

    }

    public void loadTable1(String className, String feeType) {
        data.clear();
        Table_1.getItems().clear();
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "";
            //  All Conditions
//                            1=All Classes Select And All Fee Select
//                            2=All Classes Select But Specific Fee Select
//                            3=All Fee Select But Sepcific Class Select
//                            4=Pecific Class And Fee Select
            if (className.equals("All Students") && feeType.equals("All Fee")) {
                sql1 = "Select * from student";
            } else if (className.equals("All Students") && !feeType.equals("All Fee")) {
                sql1 = "Select * from student where C21='" + feeType + "'";
            } else if (feeType.equals("All Fee") && !className.equals("All Students")) {
                sql1 = "Select * from student where C10='" + className + "'";
            } else {
                sql1 = "Select * from student where C10='" + className + "' And C21='" + feeType + "'";
            }
            rs = stmt.executeQuery(sql1);
            int i = 0;
            while (rs.next()) {
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
                //Creating a Grid Pane 
                GridPane action = new GridPane();
                //Setting size for the pane  
                action.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                action.setVgap(0.5);
                // gridPane.setHgap(0);
                action.setAlignment(Pos.CENTER);
                //adding button
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(rs.getString("C1"));
                remove.setOnAction(e -> {
                    this.DeleteStudent(((Control) e.getSource()).getId());
                });
                //adding button
                Button edit = new Button();
                edit.getStyleClass().add("edit_Button");
                edit.setId(rs.getString("C1"));
                edit.setOnAction(e -> {
                    row_Id = ((Control) e.getSource()).getId();
                    this.Edit(row_Id);
                });
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(rs.getString("C1"));
                print.setOnAction(e -> {
                    row_Id = ((Control) e.getSource()).getId();
                });
                String C1 = rs.getString("C20");
                String C2 = rs.getString("C1");
                String C3 = rs.getString("C3");
                String C4 = rs.getString("C10");
                String C5 = rs.getString("C12");
                String C6 = rs.getString("C17");
                String C7 = rs.getString("C14");
                picture.uploadImage("Student" + rs.getString("C1"), circle);
                //adding Fee
                Button Fee = new Button();
                if (rs.getString("C21").equals("Not")) {
                    Fee.getStyleClass().add("question_Button");
                } else {
                    Fee.getStyleClass().add("confirm_Button");
                }
                Fee.setId(rs.getString("C1"));
                Fee.setOnAction(e -> {
                    this.FeeLoad(((Control) e.getSource()).getId(), logic.getYear(), "All");
                    yearText.setText(logic.getYear());
                    this.Slide_2();
                });
                //adding Action
                action.add(edit, 1, 1);
                action.add(print, 2, 1);
                action.add(remove, 3, 1);
                data.add(new Logic.TableList(circle, C1, C2, C3, C4, C5, C6, C7, Fee, action));
                ++i;
            }
            studentCount.setText(String.valueOf(i));
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_1.setItems(data);
    }

    public void Search() {
        search.setOnKeyReleased(e -> {
            String className = changeClasses.getValue().toString();
            Table_2.getItems().clear();
            if (search.getText().equals("")) {
                this.loadTable1(classCheck, feeCheck);
            } else {
                data.clear();
                Table_1.getItems().clear();

                try {
                    con = sqlConnection.ConnectDB();
                    String sql1 = "";
//                    All Conditions
//                            1=All Classes Select And All Fee Select
//                            2=All Classes Select But Specific Fee Select
//                            3=All Fee Select But Sepcific Class Select
//                            4=Pecific Class And Fee Select
                    if (classCheck.equals("All Students") && feeCheck.equals("All Fee")) {
                        sql1 = "Select * from student where C1 like '%" + search.getText() + "%'"
                                + "UNION Select * from student where C3 like '%" + search.getText() + "%'";
                    } else if (classCheck.equals("All Students") && !feeCheck.equals("All Fee")) {
                        sql1 = "Select * from student where C1 like '%" + search.getText() + "%'"
                                + "UNION Select * from student where C3 like '%" + search.getText() + "%' && C21='" + feeCheck + "'";
                    } else if (feeCheck.equals("All Fee") && !classCheck.equals("All Students")) {
                        sql1 = "Select * from student where C1 like '%" + search.getText() + "%'"
                                + "UNION Select * from student where C3 like '%" + search.getText() + "%' && C10='" + classCheck + "'";
                    } else {
                        sql1 = "Select * from student where C1 like '%" + search.getText() + "%'"
                                + "UNION Select * from student where C3 like '%" + search.getText() + "%' && C10='" + classCheck + "'"
                                + " && C21='" + feeCheck + "'";
                    }
                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    int i = 0;
                    while (rs.next()) {
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
                        //Creating a Grid Pane 
                        GridPane action = new GridPane();
                        //Setting size for the pane  
                        action.setMinSize(100, 40);
                        //Setting the vertical and horizontal gaps between the columns 
                        action.setVgap(0.5);
                        // gridPane.setHgap(0);
                        action.setAlignment(Pos.CENTER);
                        //adding button
                        Button remove = new Button();
                        remove.getStyleClass().add("delete_Button");
                        remove.setId(rs.getString("C1"));
                        remove.setOnAction(e1 -> {
                            this.DeleteStudent(((Control) e1.getSource()).getId());
                        });
                        //adding button
                        Button edit = new Button();
                        edit.getStyleClass().add("edit_Button");
                        edit.setId(rs.getString("C1"));
                        edit.setOnAction(e2 -> {
                            row_Id = ((Control) e2.getSource()).getId();
                            this.Edit(row_Id);
                        });
                        //adding print
                        Button print = new Button();
                        print.getStyleClass().add("print_Button");
                        print.setId(rs.getString("C1"));
                        print.setOnAction(e3 -> {
                            row_Id = ((Control) e3.getSource()).getId();
                        });
                        String C1 = rs.getString("C20");
                        String C2 = rs.getString("C1");
                        String C3 = rs.getString("C3");
                        String C4 = rs.getString("C10");
                        String C5 = rs.getString("C12");
                        String C6 = rs.getString("C17");
                        String C7 = rs.getString("C14");
                        picture.uploadImage("Student" + rs.getString("C1"), circle);
                        //adding Fee
                        boolean check = false;
                        Button Fee = new Button();
                        if (rs.getString("C21").equals("Not")) {
                            Fee.getStyleClass().add("question_Button");
                        } else {
                            Fee.getStyleClass().add("confirm_Button");
                        }
                        Fee.setId(rs.getString("C1"));
                        Fee.setOnAction(e4 -> {
                            this.FeeLoad(((Control) e4.getSource()).getId(), logic.getYear(), "All");
                            yearText.setText(logic.getYear());
                            this.Slide_2();
                        });
                        //adding Action
                        action.add(edit, 1, 1);
                        action.add(print, 2, 1);
                        action.add(remove, 3, 1);
                        data.add(new Logic.TableList(circle, C1, C2, C3, C4, C5, C6, C7, Fee, action));
                        ++i;
                    }
                    Table_1.setItems(data);

                } catch (SQLException ex) {
                    Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {

                    this.CloseConnection();
                }
            }
        });
    }

    public void DeleteStudent(String Id) {
        if (dialog.confirm_Dialog(mainPane, "You want to delete Student All Details")) {
            logic.deleteData("student", "C1", Id);
            logic.deleteData("feestructure", "C4", Id);
            logic.deleteData2("attendance", "C5", Id, "C9", "Student");
            picture.DeleteImage("Student" + Id);
            this.loadTable1("All Students", "All Fee");
            dialog.Notofication("Delete Student", "Successfuly student all deleted", "okay");
        }
    }

    public void FeeLoad(String Id, String year, String check) {
        classText.setText(logic.getTableValue("student", "C10", "C1", Id));
        row_Id = Id;
        data2.clear();
        Table_2.getItems().clear();
        double totalLeft = 0.0;
        boolean feeStatus = false;
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "";
            if (check.equals("Monthly Fee")) {
                sql1 = "Select * from feestructure where C3= '" + year + "' And C4='" + Id + "' And C5='" + check + "'";
            } else {
                sql1 = "Select * from feestructure where C3= '" + year + "' And C4='" + Id + "'";
            }
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                //Creating a Grid Pane 
                GridPane action = new GridPane();
                //Setting size for the pane  
                action.setMinSize(100, 40);
                //Setting the vertical and horizontal gaps between the columns 
                action.setVgap(0.5);
                // gridPane.setHgap(0);
                action.setAlignment(Pos.CENTER);
                //adding button
                String C1 = rs.getString("C1") + "/" + rs.getString("C2");
                String C2 = rs.getString("C5");
                String C3 = rs.getString("C6");
                String C4 = rs.getString("C11");
                String C5 = rs.getString("C12");
                //adding button
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(rs.getString("C0"));
                remove.setOnAction(e -> {
                    if (dialog.confirm_Dialog(mainPane, "You want to delete this Fee")) {
                        logic.deleteData("feestructure", "C0", ((Control) e.getSource()).getId());
                        this.FeeLoad(row_Id, logic.getYear(), "All");
                    }
                });
                //adding print
                Button print = new Button();
                print.getStyleClass().add("print_Button");
                print.setId(rs.getString("C0"));
                print.setOnAction(e -> {
                    //    row_Id = ((Control) e.getSource()).getId();
                });
                //adding button
                Button edit = new Button();
                edit.getStyleClass().add("edit_Button");
                edit.setId(rs.getString("C0"));
                edit.setOnAction(e -> {
                    this.Edit_2(((Control) e.getSource()).getId());
                });
                //Drawing a Circle
                Circle circle = new Circle();
                //Setting the properties of the circle
                circle.setCenterX(300.0f);
                circle.setCenterY(135.0f);
                circle.setRadius(15.0f);
                //Setting other properties
                circle.setFill(Color.LIGHTGRAY);
                if (rs.getString("C13").equals("Not")) {
                    picture.uploadImage("error", circle);
                    feeStatus = true;
                } else if (rs.getString("C13").equals("Left")) {
                    picture.uploadImage("Wrong", circle);
                    feeStatus = true;
                } else {
                    picture.uploadImage("okay", circle);
                }
                //adding Action
                action.add(edit, 1, 1);
                action.add(print, 2, 1);
                action.add(remove, 3, 1);
                data2.add(new Logic.TableList(C1, C2, C3, C4, C5, circle, action));
                totalLeft += Double.valueOf(C5);
            }
            Table_2.setItems(data2);
            leftText.setText(numberFormat.format(totalLeft));
            this.UpdateStatus(feeStatus);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateStatus(boolean check) {
        con = sqlConnection.ConnectDB();
        String sql = "";

        try {
            if (check) {
                sql = "update student set C21='" + "Not"
                        + "' where C1='" + row_Id + "'";
            } else {
                sql = "update student set C21='" + "Don"
                        + "' where C1='" + row_Id + "'";
            }
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Edit_2(String Id) {
        fee_Id = Id;
        try {
            rs = logic.getTable_Data("feestructure", Id, "C0", "C0");
            while (rs.next()) {
                feeTakingDate.setPromptText(rs.getString("C14"));
                feeName.setText(rs.getString("C5"));
                totalFee.setText(rs.getString("C6"));
                relifeAmount.setText(rs.getString("C8"));
                finalAmount.setText(rs.getString("C10"));
                recivedAmount.setText(rs.getString("C11"));
                leftAmount.setText(rs.getString("C12"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //edit Edit
    public void Edit(String Id) {
        checkBox.setVisible(false);
        try {
            rs = logic.getTable_Data("student", Id, "C1", "C1");
            while (rs.next()) {
                RollNo.setText(rs.getString("C1"));
                RegistrationNo.setText(rs.getString("C2"));
                String temp[] = rs.getString("C3").split(" ");
                firstName.setText(temp[0]);
                lastName.setText(temp[1]);
                String date[] = rs.getString("C4").split("/");
                RegistrationController.this.SetAge(date[2]);
                DateOfBirth.setPromptText(rs.getString("C4"));
                DOB = rs.getString("C4");
                nationalty.setValue(rs.getString("C5"));
                Religion.setValue(rs.getString("C6"));
                Cast.setText(rs.getString("C7"));
                Gender.setValue(rs.getString("C8"));
                LastSchool.setText(rs.getString("C9"));
                ClassName.setValue(rs.getString("C10"));
                RelativeName.setValue(rs.getString("C11"));
                FatherName.setText(rs.getString("C12"));
                Cnic.setText(rs.getString("C13"));
                Address.setText(rs.getString("C14"));
                GuarianName.setText(rs.getString("C15"));
                email.setText(rs.getString("C16"));
                String temp1[] = rs.getString("C17").split("-");
                Code1.setValue(temp1[0]);
                Number.setText(temp1[1]);
                String temp2[] = rs.getString("C18").split("-");
                Code2.setValue(temp1[0]);
                officeNumber.setText(temp1[1]);
                Language.setText(rs.getString("C19"));
                joinDate = rs.getString("C20");
                joiningDate.setPromptText(rs.getString("C20"));
                picture.uploadImage("Student" + rs.getString("C1"), Circle_User);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RegistrationController.this.CloseConnection();
        }
        this.Slide_1();
    }

    public void SaveData_1() {
        try {
            //geting one pice cost if scale is Dozen
            if (!logic.Check_Id("student", "C1", fieldData.get(0)).isEmpty()
                    && !logic.Check_Id("student", "C2", fieldData.get(1)).isEmpty()) {
                dialog.Notofication("Error", "This Student already Exist !", "Wrong");
            } else {
                con = sqlConnection.ConnectDB();
                String sq = "insert into student(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21)values('"
                        + fieldData.get(0)
                        + "','" + fieldData.get(1)
                        + "','" + fieldData.get(2)
                        + "','" + fieldData.get(3)
                        + "','" + fieldData.get(4)
                        + "','" + fieldData.get(5)
                        + "','" + fieldData.get(6)
                        + "','" + fieldData.get(7)
                        + "','" + fieldData.get(8)
                        + "','" + fieldData.get(9)
                        + "','" + fieldData.get(10)
                        + "','" + fieldData.get(11)
                        + "','" + fieldData.get(12)
                        + "','" + fieldData.get(13)
                        + "','" + fieldData.get(14)
                        + "','" + fieldData.get(15)
                        + "','" + fieldData.get(16)
                        + "','" + fieldData.get(17)
                        + "','" + fieldData.get(18)
                        + "','" + fieldData.get(19)
                        + "','" + fieldData.get(20)
                        + "')";

                pst = con.prepareStatement(sq);
                pst.execute();
                dialog.Notofication("Adding Class", "SuccessFuly Adding new Class", "okay");
                this.loadTable1("All Students", "All Fee");
                this.AddFee();
                this.Clear_1();
                this.Slide_1();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    public void SaveData_2() {
        try {

            con = sqlConnection.ConnectDB();
            String sq = "insert into feestructure(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14)values('"
                    + fieldData.get(0)
                    + "','" + fieldData.get(1)
                    + "','" + fieldData.get(2)
                    + "','" + fieldData.get(3)
                    + "','" + fieldData.get(4)
                    + "','" + fieldData.get(5)
                    + "','" + fieldData.get(6)
                    + "','" + fieldData.get(7)
                    + "','" + fieldData.get(8)
                    + "','" + fieldData.get(9)
                    + "','" + fieldData.get(10)
                    + "','" + fieldData.get(11)
                    + "','" + fieldData.get(12)
                    + "','" + fieldData.get(13)
                    + "')";

            pst = con.prepareStatement(sq);
            pst.execute();
            dialog.Notofication("Adding Fee", "SuccessFuly Adding new fee", "okay");

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    // update Table 3
    public void Update_1() {
        if (logic.Check_Id("student", "C1", fieldData.get(0)).isEmpty()) {
            dialog.Notofication("Error", "This Student is not Exist !", "Wrong");
        } else {
            try {
                //geting one pice cost if scale is Dozen
                con = sqlConnection.ConnectDB();
                String sql = "update student set C2='" + fieldData.get(1)
                        + "',C3='" + fieldData.get(2)
                        + "',C4='" + fieldData.get(3)
                        + "',C5='" + fieldData.get(4)
                        + "',C6='" + fieldData.get(5)
                        + "',C7='" + fieldData.get(6)
                        + "',C8='" + fieldData.get(7)
                        + "',C9='" + fieldData.get(8)
                        + "',C10='" + fieldData.get(9)
                        + "',C11='" + fieldData.get(10)
                        + "',C12='" + fieldData.get(11)
                        + "',C13='" + fieldData.get(12)
                        + "',C14='" + fieldData.get(13)
                        + "',C15='" + fieldData.get(14)
                        + "',C16='" + fieldData.get(15)
                        + "',C17='" + fieldData.get(16)
                        + "',C18='" + fieldData.get(17)
                        + "',C19='" + fieldData.get(18)
                        + "',C20='" + fieldData.get(19)
                        + "' where C1='" + fieldData.get(0) + "'";
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                dialog.Notofication("Updating Student", "SuccessFuly Updated", "okay");
                this.loadTable1("All Students", "All Fee");
                this.Clear_1();
                this.Slide_1();
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.CloseConnection();
            }
        }
    }

    // update Table 3
    public void Update_2(String Id) {
        if (logic.Check_Id("feestructure", "C0", Id).isEmpty()) {
            dialog.Notofication("Adding Fee", "Confirm You want to add new Fee !", "Wrong");
            if (dialog.confirm_Dialog(mainPane, "You want to add new fee")) {
                this.SaveData_2();
            }
        } else {
            try {
                //geting one pice cost if scale is Dozen
                con = sqlConnection.ConnectDB();
                String sql = "update feestructure set C7='" + fieldData.get(6)
                        + "',C8='" + fieldData.get(7)
                        + "',C9='" + fieldData.get(8)
                        + "',C10='" + fieldData.get(9)
                        + "',C11='" + fieldData.get(10)
                        + "',C12='" + fieldData.get(11)
                        + "',C13='" + fieldData.get(12)
                        + "',C14='" + fieldData.get(13)
                        + "' where C0='" + Id + "'";
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                dialog.Notofication("Updating Fee", "SuccessFuly fee Updated", "okay");
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.CloseConnection();
            }
        }
        // this.FeeLoad(row_Id, logic.getYear());
        this.Clear_2();
        this.FeeLoad(row_Id, logic.getYear(), "All");
        feeName.setEditable(false);
        totalFee.setEditable(false);
        feeName.focusTraversableProperty().set(false);
        totalFee.focusTraversableProperty().set(false);
        relifeAmount.requestFocus();
        newFeeCheckBox.setSelected(false);
    }

    @FXML
    private void Change_Image(MouseEvent event) {
        if (RollNo.getText().isEmpty()) {
            dialog.Notofication("Error", "Fist Eneter the Id", "error");
        } else {
            if (logic.Check_Id("student", "C1", RollNo.getText()).isEmpty()) {
                dialog.Notofication("Error", "This Student is not Exist !", "Wrong");
            } else {
                if (picture.UploadPicture("Student" + RollNo.getText(), Circle_User)) {
                    dialog.Notofication("Save", "picture is updated", "okay");
                    this.loadTable1("All Students", "All Fee");
                } else {
                    dialog.Notofication("Error", "Location is not selected", "Wrong");
                }
            }
        }
    }

    @FXML
    private void DateOfBirth_On_Action(ActionEvent event
    ) {
        if (!DateOfBirth.getValue().toString().isEmpty()) {
            String temp[] = DateOfBirth.getValue().toString().split("-");
            String year = temp[0],
                    month = temp[1],
                    day = temp[2];
            DOB = day + "/" + logic.getMonth(month) + "/" + year;
            this.SetAge(year);
        }
    }

    @FXML
    private void save_On_Clicked(ActionEvent event
    ) {
        if (this.Validation_1()) {
            this.SaveData_1();
        }
    }

    @FXML
    private void save_On_Enter(KeyEvent event
    ) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_1()) {
                this.SaveData_1();
            }
        }
    }

    public void Clear_1() {
        fieldData.clear();
        firstName.clear();
        lastName.clear();
        email.clear();
        RollNo.clear();
        RegistrationNo.clear();
        Cast.clear();
        LastSchool.clear();
        //second
        FatherName.clear();
        Cnic.clear();
        Address.clear();
        GuarianName.clear();
        email.clear();
        Number.clear();
        officeNumber.clear();
        Language.clear();
    }

    public void Clear_2() {
        feeName.clear();
        totalFee.clear();
        relifeAmount.clear();
        finalAmount.clear();
        recivedAmount.clear();
        leftAmount.clear();
        feeSelect.setValue("All Fee");
    }

    @FXML
    private void update_On_Clicked(ActionEvent event) {
        if (this.Validation_1()) {
            this.Update_1();
        }
    }

    @FXML
    private void update_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_1()) {
                this.Update_1();
            }
        }
    }

    public void SetAge(String year) {
        if (Integer.valueOf(logic.getYear()) > Integer.valueOf(year)) {
            int age = Integer.valueOf(logic.getYear()) - Integer.valueOf(year);
            ageText.setText(String.valueOf(age) + " Year");
        }
    }

    @FXML
    private void nave_Close_OnClicked(MouseEvent event) {
        this.Slide_1();
    }

    @FXML
    private void addNewStudent(MouseEvent event) {
        this.Clear_1();
        picture.uploadImage("non", Circle_User);
        this.Slide_1();
        checkBox.setVisible(true);
    }

    public void Slide_1() {
        if (slidePane.getTranslateX() != 0) {
            openNav.play();
            mainGrid.setDisable(true);
        } else {
            closeNav.setToX(-(slidePane.getWidth()));
            closeNav.play();
            mainGrid.setDisable(false);
        }
    }

    public void Slide_2() {
        if (slidePane2.getTranslateX() != 0) {
            openNav2.play();
            mainGrid.setDisable(true);
        } else {
            closeNav2.setToX(-(slidePane2.getWidth()));
            closeNav2.play();
            mainGrid.setDisable(false);
        }
    }

    public void AddFee() {

        try {
            ObservableList<String> data = FXCollections.observableArrayList();
            data = data_value.CurrentFee(fieldData.get(9));
            for (int i = 0; i < data.size(); i++) {
                String temp[] = data.get(i).split("@");
                String temp1[] = joinDate.split("/");
                if (checkBox.isSelected()) {
                    con = sqlConnection.ConnectDB();
                    String sq = "insert into feestructure(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14)values('"
                            + temp1[0]
                            + "','" + temp1[1]
                            + "','" + temp1[2]
                            + "','" + fieldData.get(0)
                            + "','" + temp[0]
                            + "','" + temp[1]
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + temp[1]
                            + "','" + "0"
                            + "','" + temp[1]
                            + "','" + "Not"
                            + "','" + feeDate
                            + "')";
                    pst = con.prepareStatement(sq);
                    pst.execute();
                } else {
                    con = sqlConnection.ConnectDB();
                    String sq = "insert into feestructure(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14)values('"
                            + logic.getDay()
                            + "','" + logic.getMonth()
                            + "','" + logic.getYear()
                            + "','" + fieldData.get(0)
                            + "','" + "Monthly Fee"
                            + "','" + temp[1]
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + temp[1]
                            + "','" + "0"
                            + "','" + temp[1]
                            + "','" + "Not"
                            + "','" + feeDate
                            + "')";
                    pst = con.prepareStatement(sq);
                    pst.execute();
                    break;

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void close_Pane2_OnClicked(MouseEvent event) {
        this.Slide_2();
        this.Clear_2();
        this.loadTable1("All Students", "All Fee");
        feeName.setEditable(false);
        totalFee.setEditable(false);
        feeName.focusTraversableProperty().set(false);
        totalFee.focusTraversableProperty().set(false);
        relifeAmount.requestFocus();
        newFeeCheckBox.setSelected(false);
        feeSelect.setValue("All Fee");
    }

    @FXML
    private void fee_Update_On_Clicked(ActionEvent event) {
        if (this.Validation_2()) {
            this.Update_2(fee_Id);
        }
    }

    @FXML
    private void fee_Update_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_2()) {
                this.Update_2(fee_Id);
            }
        }
    }

    @FXML
    private void print_Fee_Structure(MouseEvent event) {
    }

    @FXML
    private void joiningDate_On_Action(ActionEvent event) {
        if (!joiningDate.getValue().toString().isEmpty()) {
            String temp[] = joiningDate.getValue().toString().split("-");
            String year = temp[0],
                    month = temp[1],
                    day = temp[2];
            joinDate = day + "/" + logic.getMonth(month) + "/" + year;
        }
    }

    @FXML
    private void feeTakingDate_On_Clicked(ActionEvent event) {
        if (!feeTakingDate.getValue().toString().isEmpty()) {
            String temp[] = feeTakingDate.getValue().toString().split("-");
            String year = temp[0],
                    month = temp[1],
                    day = temp[2];
            feeDate = day + "/" + logic.getMonth(month) + "/" + year;
        }
    }

    @FXML
    private void newFeeCheckBox_OnChange(ActionEvent event) {
        if (newFeeCheckBox.isSelected()) {
            fee_Id = "";
            this.Clear_2();
            feeName.setEditable(true);
            totalFee.setEditable(true);
            feeName.requestFocus();
        } else {
            feeName.setEditable(false);
            totalFee.setEditable(false);
            feeName.focusTraversableProperty().set(false);
            totalFee.focusTraversableProperty().set(false);
            relifeAmount.requestFocus();
        }
    }

    public void relife() {
        relifeAmount.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (Double.valueOf(newValue) > Double.valueOf(totalFee.getText())) {
                    relifeAmount.setText(oldValue);
                } else if (!newValue.isEmpty() && !totalFee.getText().isEmpty()) {
                    double v = Double.valueOf(totalFee.getText()) - Double.valueOf(newValue);
                    finalAmount.setText(numberFormat.format(v));
                    leftAmount.setText(numberFormat.format(v));
                    recivedAmount.setText("0");
                }
            } else {
                finalAmount.setText(totalFee.getText());
            }
        });
    }

    public void recivied() {
        recivedAmount.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (Double.valueOf(newValue) > Double.valueOf(finalAmount.getText())) {
                    recivedAmount.setText(oldValue);
                } else if (!newValue.isEmpty() && !finalAmount.getText().isEmpty()) {
                    double v = Double.valueOf(finalAmount.getText()) - Double.valueOf(newValue);
                    leftAmount.setText(numberFormat.format(v));
                }
            } else {
                leftAmount.setText(finalAmount.getText());
            }
        });
    }

    public void ChangeFeeName() {
        feeSelect.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    if (newValue.equals("Monthly Fee")) {
                        RegistrationController.this.FeeLoad(row_Id, yearText.getText(), newValue);
                    } else {
                        RegistrationController.this.FeeLoad(row_Id, yearText.getText(), newValue);
                    }
                }
            }
        }
        );

    }

    public void ChangeFeeType() {
        feeChange.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    if (newValue.equals("Paid")) {
                        feeCheck = "Don";
                    } else if (newValue.equals("Un-Paid")) {
                        feeCheck = "Not";
                    } else {
                        feeCheck = "All Fee";
                    }
                    RegistrationController.this.loadTable1(classCheck, feeCheck);

                }
            }
        }
        );

    }

    public void ChangeCLasses() {
        changeClasses.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    classCheck = newValue;
                    RegistrationController.this.loadTable1(newValue, feeCheck);

                }
            }
        }
        );

    }

    @FXML
    private void Left_OnClicked(ActionEvent event) {
        yearText.setText(String.valueOf(Integer.valueOf(yearText.getText()) - 1));
        this.FeeLoad(row_Id, yearText.getText(), "All");
    }

    @FXML
    private void right_OnClicked(ActionEvent event) {
        yearText.setText(String.valueOf(Integer.valueOf(yearText.getText()) + 1));
        this.FeeLoad(row_Id, yearText.getText(), "All");
    }

    @FXML
    private void MainPrint_On_Clicked(MouseEvent event) {
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
}
