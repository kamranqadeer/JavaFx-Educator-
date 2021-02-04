/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddSubjects;

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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class SubjectsController implements Initializable {

    ValidationSupport validationSupport = new ValidationSupport();
    Connection con = null;
    Dialogs dialog = new Dialogs();
    Validation validation = new Validation();
    ResultSet rs = null;
    PreparedStatement pst = null;
    kk_Logic logic = new kk_Logic();
    private ObservableList<Logic.TableList> data;
    private ObservableList<Logic.TableList> data2;
    String C3 = "",
            C4 = "",
            C5 = "",
            C6 = "",
            C2_2 = "",
            C2_3 = "",
            C2_4 = "",
            C2_5 = "",
            C2_1 = "",
            row_Id = "";
    @FXML
    private ScrollPane scrol_Pane;
    @FXML
    private ScrollPane scrol_Pane2;
    @FXML
    private TableView<Logic.TableList> Table_1;
    @FXML
    private TableView<Logic.TableList> Table_2;
    @FXML
    private TableColumn<Logic.TableList, String> Col_1;
    @FXML
    private TableColumn<Logic.TableList, String> Col_2;
    @FXML
    private TableColumn<Logic.TableList, String> Col_3;
    @FXML
    private TableColumn<Logic.TableList, String> Col_4;
    @FXML
    private TableColumn<Logic.TableList, String> Col_5;
    @FXML
    private TableColumn<Logic.TableList, String> Col_6;
    @FXML
    private JFXTextField bookName;
    @FXML
    private JFXTextField otherName;
    @FXML
    private JFXTextField discription;
    @FXML
    private JFXTextField version;
    @FXML
    private JFXTextField searchField;
    @FXML
    private JFXTextField subjectName;
    @FXML
    private JFXTextField subjectCode;
    @FXML
    private JFXTextField subjectMarks;
    @FXML
    private JFXTextField pasingMarks;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_1;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_2;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_3;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_4;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_5;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_6;
    @FXML
    private TableColumn<Logic.TableList, String> Col2_7;
    @FXML
    private StackPane main_Pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //bind table height
        Table_1.prefHeightProperty().bind(scrol_Pane.heightProperty());
        Table_2.prefHeightProperty().bind(scrol_Pane2.heightProperty());
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        //seting tabel 
        this.setTable_1();
        this.loadTable1();
        this.SelectCell();
        this.search();
        validation.Name_2(subjectName);
        validation.Name_2(subjectCode);
        validation.Number2(subjectMarks);
        validation.Number2(pasingMarks);
        //setting table2
        this.setTabe_2();
        validation.Name_2(bookName);
        validation.Name_2(otherName);
        validation.Discription(discription);
        validation.Name_2(version);

        // TODO
    }
    //    SetTable

    public void setTable_1() {
        Col_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        Col_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        Col_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        Col_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        Col_5.setCellValueFactory(new PropertyValueFactory<>("C4"));
        Col_6.setCellValueFactory(new PropertyValueFactory<>("delete"));

    }

    public void setTabe_2() {
        Col2_1.setCellValueFactory(new PropertyValueFactory<>("C0"));
        Col2_2.setCellValueFactory(new PropertyValueFactory<>("C1"));
        Col2_3.setCellValueFactory(new PropertyValueFactory<>("C2"));
        Col2_4.setCellValueFactory(new PropertyValueFactory<>("C3"));
        Col2_5.setCellValueFactory(new PropertyValueFactory<>("C5"));
        Col2_6.setCellValueFactory(new PropertyValueFactory<>("C4"));
        Col2_7.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    public boolean Validation_1() {
        if (!validation.CheckEmpty(subjectName, "Subject Name is required !")
                || !validation.CheckEmpty(subjectCode, "Subject Code is required !")
                || !validation.CheckEmpty(subjectMarks, "Subject Marks is required !")
                || !validation.CheckEmpty(pasingMarks, "Passing Marks is required !")) {
            return false;
        } else if (Double.valueOf(subjectMarks.getText()) < Double.valueOf(pasingMarks.getText())) {
            dialog.Notofication("Error", "Passing marks shoud be greter than subject marks", "error");
            return false;
        } else {
            C3 = subjectName.getText();
            C4 = subjectCode.getText();
            C5 = subjectMarks.getText();
            C6 = pasingMarks.getText();
            return true;
        }
    }

    private void search() {
        searchField.setOnKeyReleased(e -> {
            Table_2.getItems().clear();
            if (searchField.getText().equals("")) {
                this.loadTable1();
            } else {
                data.clear();
                Table_1.getItems().clear();

                try {
                    con = sqlConnection.ConnectDB();
                    String sql1 = "Select * from subject where C3 like '%" + searchField.getText() + "%'"
                            + "UNION Select * from subject where C4 like '%" + searchField.getText() + "%'";
                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    int i = 0;
                    while (rs.next()) {
                        //adding button
                        Button remove = new Button();
                        remove.getStyleClass().add("delete_Button");
                        remove.setId(String.valueOf(i));
                        remove.setOnAction(event -> {
                            row_Id = ((Control) event.getSource()).getId();
                            this.deleteTable_1();
                        });
                        String no = String.valueOf(++i);
                        String C1 = rs.getString("C3");
                        String C2 = rs.getString("C4");
                        String C3 = rs.getString("C5");
                        String C4 = rs.getString("C6");

                        data.add(new Logic.TableList(no, C1, C2, C3, C4, remove));

                    }
                    Table_1.setItems(data);

                } catch (SQLException ex) {
                    Logger.getLogger(SubjectsController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {

                    this.CloseConnection();
                }
            }
        });
    }

    public boolean Validation_2() {
        if (subjectName.getText().isEmpty()) {
            dialog.Notofication("Error", "First Select the subject", "error");
            return false;
        } else if (!validation.CheckEmpty(bookName, "Book Name is required !")
                || !validation.CheckEmpty(otherName, "Other Name is required !")
                || !validation.CheckEmpty(discription, "Discription is required !")
                || !validation.CheckEmpty(version, "Version is required !")) {
            return false;
        } else {
            C2_1 = subjectName.getText();
            C2_2 = bookName.getText();
            C2_3 = otherName.getText();
            C2_4 = discription.getText();
            C2_5 = version.getText();
            return true;
        }
    }

    public void loadTable1() {
        data.clear();
        Table_1.getItems().clear();
        try {
            rs = logic.getAllData("subject");
            int i = 0;
            while (rs.next()) {
                //adding button
                Button remove = new Button();
                remove.getStyleClass().add("delete_Button");
                remove.setId(String.valueOf(i));
                remove.setOnAction(e -> {
                    row_Id = ((Control) e.getSource()).getId();
                    this.deleteTable_1();
                });
                String no = String.valueOf(++i);
                String C1 = rs.getString("C3");
                String C2 = rs.getString("C4");
                String C3 = rs.getString("C5");
                String C4 = rs.getString("C6");

                data.add(new Logic.TableList(no, C1, C2, C3, C4, remove));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_1.setItems(data);
    }
    //Delete Table 1 Row

    public void deleteTable_1() {
        for (int i = 0; i < data.size(); i++) {
            if (String.valueOf(i).equals(row_Id)) {
                if (dialog.confirm_Dialog(main_Pane, "You want to delete this Subject")) {
                    logic.deleteData("subject", "C3", data.get(i).getC1());
                    logic.deleteData("book", "C1", data.get(i).getC1());
                    this.loadTable1();
                    Table_2.getItems().clear();
                    dialog.Notofication("Deleting", "Subject is successfuly deleted", "okay");
                }
                break;
            }
        }
    }

    //load Table 2
    public void loadTable2(String Id) {
        data2.clear();
        Table_2.getItems().clear();
        try {
            rs = logic.getTable_Data("book", Id, "C1", "C1");
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
                String C1 = rs.getString("C0");
                String C2 = rs.getString("C2");
                String C3 = rs.getString("C3");
                String C4 = rs.getString("C4");
                String C5 = rs.getString("C5");
                data2.add(new Logic.TableList(no, C1, C2, C3, C4, C5, remove));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        Table_2.setItems(data2);
    }

    //Delete Table 1 Row
    public void deleteTable_2() {
        for (int i = 0; i < data2.size(); i++) {
            if (String.valueOf(i).equals(row_Id)) {
                if (dialog.confirm_Dialog(main_Pane, "You want to delete this Subject")) {
                    logic.deleteData("book", "C0", data2.get(i).getC1());
                    this.loadTable2(C3);
                    dialog.Notofication("Deleting", "Book is successfuly deleted", "okay");
                }
                break;
            }
        }
    }

    public void SaveData_1() {
        try {
            //geting one pice cost if scale is Dozen

            if (!logic.Check_Id("subject", "C3", C3).isEmpty()) {
                dialog.Notofication("Error", "This Subject already added", "Wrong");
            } else {
                con = sqlConnection.ConnectDB();
                String sq = "insert into subject(C3,C4,C5,C6)values('"
                        + C3
                        + "','" + C4
                        + "','" + C5
                        + "','" + C6 + "')";
                pst = con.prepareStatement(sq);
                pst.execute();
                dialog.Notofication("Adding Subject", "SuccessFuly Adding new Subject", "okay");
                this.loadTable1();
                this.Clear_1();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    public void Update() {
        try {
            if (logic.Check_Id("subject", "C3", subjectName.getText()).isEmpty()) {
                dialog.Notofication("Note", "This Subject is not exist", "Wrong");
            } else if (!C4.equals(subjectCode.getText())
                    || !C5.equals(subjectMarks.getText())
                    || !C6.equals(pasingMarks.getText())) {

                //geting one pice cost if scale is Dozen
                con = sqlConnection.ConnectDB();
                String sql = "update subject set C4='" + C4
                        + "',C5='" + C5
                        + "',C6='" + C6
                        + "' where C3='" + C3 + "'";
                pst = con.prepareStatement(sql);
                pst.executeUpdate();
                dialog.Notofication("Note", "Subject Name will be same.", "Wrong");
                dialog.Notofication("Updating Subject", "SuccessFuly Updated", "okay");
                this.loadTable1();
                this.Clear_1();
            } else {
                this.Clear_1();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectsController.class.getName()).log(Level.SEVERE, null, ex);
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
                subjectName.setText(t.getC1());
                C3 = t.getC1();
                subjectCode.setText(t.getC2());
                C4 = t.getC2();
                subjectMarks.setText(t.getC3());
                C5 = t.getC3();
                pasingMarks.setText(t.getC4());
                C6 = t.getC6();
                SubjectsController.this.loadTable2(subjectName.getText());
            }
        });
    }

    public void SaveData_2() {
        try {
            //geting one pice cost if scale is Dozen

            if (!logic.Check_Id("book", "C2", C3).isEmpty() && !logic.Check_Id("book", "C3", C2_3).isEmpty()) {
                dialog.Notofication("Error", "This Book already added for this subject", "Wrong");
            } else {
                con = sqlConnection.ConnectDB();
                String sq = "insert into book(C1,C2,C3,C4,C5)values('"
                        + C2_1
                        + "','" + C2_2
                        + "','" + C2_3
                        + "','" + C2_4
                        + "','" + C2_5 + "')";
                pst = con.prepareStatement(sq);
                pst.execute();
                dialog.Notofication("Adding Book", "SuccessFuly Adding new Subject", "okay");
                this.loadTable2(C3);
                this.Clear_2();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    @FXML
    private void details_On_Clicked(ActionEvent event) {
        if (this.Validation_2()) {
            this.SaveData_2();
        }
    }

    @FXML
    private void details_On_Enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (this.Validation_2()) {
                this.SaveData_2();
            }
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
        subjectName.clear();
        subjectCode.clear();
        subjectMarks.clear();
        pasingMarks.clear();
        Table_2.getItems().clear();
    }

    public void Clear_2() {
        bookName.clear();
        otherName.clear();
        discription.clear();
        version.clear();
        bookName.requestFocus();
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
