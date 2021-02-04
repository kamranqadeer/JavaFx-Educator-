/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddClasses;

import Logic.Data;
import Logic.Dialogs;
import Logic.Validation;
import Logic.kk_Logic;
import com.jfoenix.controls.JFXTextField;
import educator.sqlConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.validation.ValidationSupport;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class ClassController implements Initializable {

    TranslateTransition openNav, closeNav;
    ObservableList<String> fieldData1 = FXCollections.observableArrayList();
    ObservableList<String> fieldData2 = FXCollections.observableArrayList();
    ObservableList<String> fieldData3 = FXCollections.observableArrayList();

    ValidationSupport validationSupport = new ValidationSupport();
    Data data_value = new Data();
    Connection con = null;
    Dialogs dialog = new Dialogs();
    Validation validation = new Validation();
    ResultSet rs = null, rs2 = null;
    PreparedStatement pst = null;
    DecimalFormat numberFormat = new DecimalFormat("#.0");
    kk_Logic logic = new kk_Logic();
    private ObservableList<Logic.TableList> data;
    private ObservableList<Logic.TableList> data2;
    private ObservableList<Logic.TableList> data3;
    String row_Id = "";

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
    private TableColumn<Logic.TableList, String> C1_11;
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
    private TableColumn<Logic.TableList, String> C2_8;
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
    private TableColumn<Logic.TableList, String> C3_6;
    @FXML
    private JFXTextField className;
    @FXML
    private ComboBox teacherName;
    @FXML
    private JFXTextField search;
    @FXML
    private StackPane main_Pane;
    @FXML
    private JFXTextField subjectName;
    @FXML
    private JFXTextField subjectCode;
    @FXML
    private JFXTextField subjectMarks;
    @FXML
    private JFXTextField pasingMarks;
    @FXML
    private JFXTextField bookName;
    @FXML
    private JFXTextField otherName;
    @FXML
    private JFXTextField discription;
    @FXML
    private JFXTextField version;
    @FXML
    private AnchorPane subjectPane;
    @FXML
    private GridPane mainGrid;
    @FXML
    private JFXTextField annualFund;
    @FXML
    private JFXTextField summerTask;
    @FXML
    private JFXTextField monthlyFee;
    @FXML
    private JFXTextField TuationFee;
    @FXML
    private JFXTextField registrationFee;
    @FXML
    private JFXTextField ExaminationFee;
    @FXML
    private JFXTextField labChargesFee;
    @FXML
    private ComboBox subject_Teacher;
    @FXML
    private Text subjectTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.LoadClasses();
        // Slide Nave
        openNav = new TranslateTransition(new Duration(350), subjectPane);
        openNav.setToX(0);
        closeNav = new TranslateTransition(new Duration(350), subjectPane);
//        educOpen = new TranslateTransition(new Duration(350), eduPane);
//        educOpen.setToX(0);
//        educClose = new TranslateTransition(new Duration(350), eduPane);
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data3 = FXCollections.observableArrayList();
        data_value.SetComBox(teacherName, "getTeachers");
        data_value.SetComBox(subject_Teacher, "getTeachers");

        this.RunTimeValidations();
        //setting table 1
        this.setTable_1();
        this.loadTable1();
        this.SelectCell();
        this.search();
        //setting table 2
        this.setTabe_2();
        //setting table_3
        this.setTabe_3();
    }

    public void RunTimeValidations() {
        //Class Details Validations
        validation.Name_2(className);
        validation.Number2(annualFund);
        validation.Number2(summerTask);
        validation.Number2(monthlyFee);
        validation.Number2(TuationFee);
        validation.Number2(registrationFee);
        validation.Number2(ExaminationFee);
        validation.Number2(labChargesFee);
        //Subject Details
        validation.Name_2(subjectName);
        validation.Name_2(subjectCode);
        validation.Number(subjectMarks);
        validation.Number(pasingMarks);
        //bookes
        validation.Name_2(bookName);
        validation.Discription(otherName);
        validation.Discription(discription);
        validation.Name_2(version);
    }

    //    SetTable
    public void setTable_1() {
        C1_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C1_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C1_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C1_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C1_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        C1_6.setCellValueFactory(new PropertyValueFactory<>("C5"));
        C1_7.setCellValueFactory(new PropertyValueFactory<>("C6"));
        C1_8.setCellValueFactory(new PropertyValueFactory<>("C7"));
        C1_9.setCellValueFactory(new PropertyValueFactory<>("C8"));
        C1_10.setCellValueFactory(new PropertyValueFactory<>("C9"));
        C1_11.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    public void setTabe_2() {
        C2_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C2_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C2_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C2_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C2_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        C2_6.setCellValueFactory(new PropertyValueFactory<>("C5"));
        C2_7.setCellValueFactory(new PropertyValueFactory<>("details"));
        C2_8.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    public void setTabe_3() {
        C3_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        C3_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        C3_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        C3_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        C3_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        C3_6.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    public boolean Validation_1() {
        if (!validation.CheckEmpty(className, "Class Name is required !")
                || !validation.CheckEmpty(annualFund, "Anuual Fund is required !")
                || !validation.CheckEmpty(summerTask, "Summer Task is required !")
                || !validation.CheckEmpty(monthlyFee, "Monthly Fee is required !")
                || !validation.CheckEmpty(TuationFee, "Tuition Fee is required !")
                || !validation.CheckEmpty(registrationFee, "Registration Fee is required !")
                || !validation.CheckEmpty(ExaminationFee, "Examinition Fee is required !")
                || !validation.CheckEmpty(labChargesFee, "Lab Charges is required !")) {
            return false;
        } else {
            Double v = 0.0;
            fieldData1.clear();
            fieldData1.add(className.getText());
            fieldData1.add(teacherName.getValue().toString());
            fieldData1.add(annualFund.getText());
            fieldData1.add(summerTask.getText());
            fieldData1.add(monthlyFee.getText());
            fieldData1.add(TuationFee.getText());
            fieldData1.add(registrationFee.getText());
            fieldData1.add(ExaminationFee.getText());
            fieldData1.add(labChargesFee.getText());
            for (int i = 2; i < fieldData1.size(); i++) {
                v += Double.valueOf(fieldData1.get(i));
            }
            fieldData1.add(numberFormat.format(v));
            return true;
        }
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
                    String sql1 = "Select * from classes where C1 like '%" + search.getText() + "%'"
                            + "UNION Select * from classes where C2 like '%" + search.getText() + "%'";
                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    int i = 0;
                    while (rs.next()) {

                        String no = String.valueOf(++i);
                        String C1 = rs.getString("C1");
                        String C2 = rs.getString("C2");
                        String C3 = rs.getString("C3");
                        String C4 = rs.getString("C4");
                        String C5 = rs.getString("C5");
                        String C6 = rs.getString("C6");
                        String C7 = rs.getString("C7");
                        String C8 = rs.getString("C8");
                        String C9 = rs.getString("C9");
                        //adding remove
                        Button remove = new Button();
                        remove.getStyleClass().add("delete_Button");
                        remove.setId(C1);
                        remove.setOnAction(e1 -> {
                            this.deleteTable_1(((Control) e1.getSource()).getId());
                        });
                        data.add(new Logic.TableList(no, C1, C2, C3, C4, C5, C6, C7, C8, C9, remove));

                    }
                    Table_1.setItems(data);

                } catch (SQLException ex) {
                    Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {

                    this.CloseConnection();
                }
            }
        });
    }

    public boolean Validation_2() {

        if (!validation.CheckEmpty(className, "Class Name is required !")
                || !validation.CheckEmpty(subjectName, "Subject Name is required !")
                || !validation.CheckEmpty(subjectCode, "Subject Code is required !")
                || !validation.CheckEmpty(subjectMarks, "Subject Marks is required !")
                || !validation.CheckEmpty(pasingMarks, "Passing Marks is required !")) {
            return false;
        } else {
            fieldData2.clear();
            fieldData2.add(className.getText()); //0
            fieldData2.add(subjectName.getText());//1
            fieldData2.add(subjectCode.getText());//2
            fieldData2.add(subjectMarks.getText());//3
            fieldData2.add(pasingMarks.getText());//4
            fieldData2.add(subject_Teacher.getValue().toString());//5
            return true;
        }
    }

    public void loadTable1() {
        data.clear();
        Table_1.getItems().clear();
        try {
            rs = logic.getAllData("classes");
            int i = 0;
            while (rs.next()) {

                String no = String.valueOf(++i);
                String C1 = rs.getString("C1");
                String C2 = rs.getString("C2");
                String C3 = rs.getString("C3");
                String C4 = rs.getString("C4");
                String C5 = rs.getString("C5");
                String C6 = rs.getString("C6");
                String C7 = rs.getString("C7");
                String C8 = rs.getString("C8");
                String C9 = rs.getString("C9");
                //adding remove
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(C1);
                remove.setOnAction(e -> {
                    this.deleteTable_1(((Control) e.getSource()).getId());
                });
                data.add(new Logic.TableList(no, C1, C2, C3, C4, C5, C6, C7, C8, C9, remove));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_1.setItems(data);
    }
    //Delete Table 1 Row

    public void deleteTable_1(String Id) {
        if (dialog.confirm_Dialog(main_Pane, "You want to delete this Class")) {
            logic.deleteData("book", "C2", Id);
            logic.deleteData("classdetails", "C1", Id);
            logic.deleteData("classes", "C1", Id);
            this.loadTable1();
            Table_2.getItems().clear();
            this.Clear_1();
            this.Clear_2();
            dialog.Notofication("Deleting", "Class is successfuly deleted", "okay");
        }
    }

    //load Table 2
    public void loadTable2(String Id) {
        data2.clear();
        Table_2.getItems().clear();
        try {
            rs = logic.getTable_Data("classdetails", Id, "C1", "C0");
            int i = 0;
            while (rs.next()) {
                //adding button

                String no = String.valueOf(++i);
                String C1 = rs.getString("C2");
                String C2 = rs.getString("C3");
                String C3 = rs.getString("C4");
                String C4 = rs.getString("C5");
                String C5 = rs.getString("C6");
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(rs.getString("C0"));
                remove.setOnAction(e -> {
                    this.deleteTable_2(((Control) e.getSource()).getId());
                });
                Button books = new Button();
                if (logic.Check_Id("book", "C1", rs.getString("C0")).isEmpty()) {
                    books.getStyleClass().add("question_Button");
                } else {
                    books.getStyleClass().add("confirm_Button");
                }
                books.setId(rs.getString("C0"));
                books.setOnAction(e -> {
                    this.SubjectPane();
                    this.loadTable3(((Control) e.getSource()).getId());
                });
                data2.add(new Logic.TableList(no, C1, C2, C3, C4, C5, books, remove));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_2.setItems(data2);
    }

    //Delete Table 1 Row
    public void deleteTable_2(String Id) {
        if (dialog.confirm_Dialog(main_Pane, "You want to delete class subject")) {
            logic.deleteData("classdetails", "C0", Id);
            logic.deleteData("book", "C1", Id);
            this.loadTable2(className.getText());
            dialog.Notofication("Deleting", "Class subject is successfuly deleted", "okay");
        }
    }

    //load Table 3
    public boolean Validation_3() {

        if (!validation.CheckEmpty(bookName, "Book Name is required !")
                || !validation.CheckEmpty(otherName, "Other Name is required !")
                || !validation.CheckEmpty(discription, "Discription is required !")
                || !validation.CheckEmpty(version, "Version is required !")) {
            return false;
        } else {
            fieldData3.clear();
            fieldData3.add(row_Id);
            fieldData3.add(className.getText());
            fieldData3.add(bookName.getText());
            fieldData3.add(otherName.getText());
            fieldData3.add(discription.getText());
            fieldData3.add(version.getText());
            return true;
        }
    }

    public void loadTable3(String Id) {
        row_Id = Id;
        data3.clear();
        Table_3.getItems().clear();
        try {
            rs = logic.getTable_Data("book", Id, "C1", "C0");
            int i = 0;
            while (rs.next()) {
                //adding button
                String no = String.valueOf(++i);
                String C1 = rs.getString("C3");
                String C2 = rs.getString("C4");
                String C3 = rs.getString("C5");
                String C4 = rs.getString("C6");
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(rs.getString("C0"));
                remove.setOnAction(e -> {
                    this.deleteTable_3(((Control) e.getSource()).getId());
                });

                data3.add(new Logic.TableList(no, C1, C2, C3, C4, remove));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_3.setItems(data3);
    }

    //Delete Table 1 Row
    public void deleteTable_3(String Id) {
        if (dialog.confirm_Dialog(main_Pane, "You want to delete book details")) {
            logic.deleteData("book", "C0", Id);
            dialog.Notofication("Deleting", "Book is successfuly deleted", "okay");
            this.Clear_3();
        }
    }

    public void SaveData_1() {
        try {
            if (logic.Check_Id("classes", "C1", fieldData1.get(0)).isEmpty()) {
                con = sqlConnection.ConnectDB();
                String sq = "insert into classes(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11)values('"
                        + fieldData1.get(0)
                        + "','" + fieldData1.get(1)
                        + "','" + fieldData1.get(2)
                        + "','" + fieldData1.get(3)
                        + "','" + fieldData1.get(4)
                        + "','" + fieldData1.get(5)
                        + "','" + fieldData1.get(6)
                        + "','" + fieldData1.get(7)
                        + "','" + fieldData1.get(8)
                        + "','" + fieldData1.get(9)
                        + "','" + fieldData1.get(10) + "')";
                pst = con.prepareStatement(sq);
                pst.execute();
                this.loadTable1();
                this.Clear_1();
                dialog.Notofication("Note", "New Class is created", "okay");
            } else {
                //geting one pice cost if scale is Dozen
                con = sqlConnection.ConnectDB();
                String sql = "update classes set C2='" + fieldData1.get(1)
                        + "',C3='" + fieldData1.get(2)
                        + "',C4='" + fieldData1.get(3)
                        + "',C5='" + fieldData1.get(4)
                        + "',C6='" + fieldData1.get(5)
                        + "',C7='" + fieldData1.get(6)
                        + "',C8='" + fieldData1.get(7)
                        + "',C9='" + fieldData1.get(8)
                        + "',C10='" + fieldData1.get(9)
                        + "' where C1='" + fieldData1.get(0) + "'";
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                dialog.Notofication("Note", "Class Name will be same.", "Wrong");
                dialog.Notofication("Updating Class", "SuccessFuly Updated", "okay");
                this.loadTable1();
                this.Clear_1();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }

    }

    //select Cell
    private void SelectCell() {
        Table_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ClassController.this.Clear_1();
                Logic.TableList t = Table_1.getItems().get(Table_1.getSelectionModel().getSelectedIndex());
                className.setText(t.getC1());
                teacherName.setValue(t.getC2());
                annualFund.setText(t.getC3());
                summerTask.setText(t.getC4());
                monthlyFee.setText(t.getC5());
                TuationFee.setText(t.getC6());
                registrationFee.setText(t.getC7());
                ExaminationFee.setText(t.getC8());
                labChargesFee.setText(t.getC10());
                ClassController.this.loadTable2(t.getC1());

            }
        });
    }

    public void SaveData_2() {
        if (logic.Check_Id("classes", "C1", className.getText()).isEmpty()) {
            dialog.Notofication("Error", "This Class is not exist first add", "Wrong");
        } else {
            if (Double.valueOf(fieldData2.get(4)) > Double.valueOf(fieldData2.get(3))) {
                dialog.Notofication("Error", "Passing Marks is not greater than Subject Marks !", "Wrong");
            } else {
                try {
                    //geting one pice cost if scale is Dozen
                    if (!logic.Check_Id("classdetails", "C1", className.getText()).isEmpty() && !logic.Check_Id("classdetails", "C2", subjectName.getText()).isEmpty()) {
                        dialog.Notofication("Error", "This Subject is already added", "Wrong");
                    } else {
                        con = sqlConnection.ConnectDB();
                        String sq = "insert into classdetails(C1,C2,C3,C4,C5,C6)values('"
                                + fieldData2.get(0)
                                + "','" + fieldData2.get(1)
                                + "','" + fieldData2.get(2)
                                + "','" + fieldData2.get(3)
                                + "','" + fieldData2.get(4)
                                + "','" + fieldData2.get(5) + "')";
                        pst = con.prepareStatement(sq);
                        pst.execute();
                        dialog.Notofication("Adding Details", "SuccessFuly added new Class Details", "okay");
                        this.loadTable2(fieldData2.get(0));
                        this.Clear_2();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    this.CloseConnection();
                }
            }
        }
    }

    public void SaveData_3() {

        try {
            //geting one pice cost if scale is Dozen

            con = sqlConnection.ConnectDB();
            String sq = "insert into book(C1,C2,C3,C4,C5,C6)values('"
                    + fieldData3.get(0)
                    + "','" + fieldData3.get(1)
                    + "','" + fieldData3.get(2)
                    + "','" + fieldData3.get(3)
                    + "','" + fieldData3.get(4)
                    + "','" + fieldData3.get(5) + "')";
            pst = con.prepareStatement(sq);
            pst.execute();
            dialog.Notofication("Adding Book", "SuccessFuly added new Book", "okay");
            this.loadTable3(fieldData3.get(0));
            this.Clear_3();
        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }

    }

    @FXML
    private void add_On_Clicked(ActionEvent event) {
        if (this.Validation_1()) {
            this.SaveData_1();
        }

    }

    @FXML
    private void add_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_1()) {
                this.SaveData_1();
            }
        }
    }

    public void Clear_1() {
        className.clear();
        annualFund.clear();
        summerTask.clear();
        monthlyFee.clear();
        TuationFee.clear();
        registrationFee.clear();
        ExaminationFee.clear();
        labChargesFee.clear();
        fieldData1.clear();
        Table_2.getItems().clear();

    }

    public void Clear_2() {
        subjectName.clear();
        subjectCode.clear();
        subjectMarks.clear();
        pasingMarks.clear();
        fieldData2.clear();
        subjectName.requestFocus();
    }

    public void Clear_3() {
        bookName.clear();
        otherName.clear();
        discription.clear();
        version.clear();
        fieldData3.clear();
        this.SubjectPane();
        this.loadTable2(className.getText());
        this.Table_3.getItems().clear();
    }

    public void SubjectPane() {
        if (subjectPane.getTranslateX() != 0) {
            openNav.play();
            mainGrid.setDisable(false);
        } else {
            closeNav.setToX(-(subjectPane.getWidth()));
            closeNav.play();
            mainGrid.setDisable(true);
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

    public void LoadClasses() {
        try {
            for (int i = 0; i < data_value.Classes().size(); i++) {
                if (logic.Check_Id("classes", "C1", data_value.Classes().get(i)).isEmpty()) {
                    con = sqlConnection.ConnectDB();
                    String sq = "insert into classes(C1,C2,C3,C4,C5,C6,C7,C8,C9,C10)values('"
                            + data_value.Classes().get(i)
                            + "','" + "Not Yet"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0"
                            + "','" + "0" + "')";
                    pst = con.prepareStatement(sq);
                    pst.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    @FXML
    private void subject_Close_On_Clicked(MouseEvent event) {
        this.SubjectPane();
    }

    @FXML
    private void add_Book_On_Clicked(ActionEvent event) {
        if (this.Validation_3()) {
            this.SaveData_3();
        }
    }

    @FXML
    private void add_Book_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_3()) {
                this.SaveData_3();
            }
        }
    }

    @FXML
    private void subject_Add_On_Clicked(ActionEvent event) {
        if (this.Validation_2()) {
            this.SaveData_2();
        }
    }

    @FXML
    private void subject_Add_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_2()) {
                this.SaveData_2();
            }
        }
    }

}
