/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;

import AddStudyDetails.StudyDetailsController;
import Logic.Data;
import Logic.Dialogs;
import Logic.Validation;
import Logic.kk_Logic;
import Logic.picture;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class TimeTableController implements Initializable {

    ObservableList<String> list = FXCollections.observableArrayList();
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
    String day = "", month = "", year = "", time = "00:00", StudentId = "", activity = "Quiz", subject = "Math", classCheck = "Play Group";
    private ObservableList<Logic.TableList> data, data2, data3;
    @FXML
    private TableView<Logic.TableList> Table_1;
    @FXML
    private TableColumn<Logic.TableList, String> T1_0;
    @FXML
    private TableColumn<Logic.TableList, String> T1_1;
    @FXML
    private TableColumn<Logic.TableList, String> T1_2;
    @FXML
    private TableColumn<Logic.TableList, String> T1_3;
    @FXML
    private TableColumn<Logic.TableList, String> T1_4;
    @FXML
    private TableColumn<Logic.TableList, String> T1_5;
    @FXML
    private TableColumn<Logic.TableList, String> T1_6;
    @FXML
    private TableColumn<Logic.TableList, String> T1_7;
    @FXML
    private TableColumn<Logic.TableList, String> T1_8;
    @FXML
    private TableColumn<Logic.TableList, String> T1_9;
    @FXML
    private JFXTimePicker schoolTime;
    @FXML
    private ComboBox changeClass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data_value.SetComBox(changeClass, "getClasses");
        this.setTabe_1();
        this.LoadData_1();
        this.LoadTimeTable();
    }

    public void setTabe_1() {
        T1_0.setCellValueFactory(new PropertyValueFactory<>("gridPane"));
        T1_1.setCellValueFactory(new PropertyValueFactory<>("One"));
        T1_2.setCellValueFactory(new PropertyValueFactory<>("Two"));
        T1_3.setCellValueFactory(new PropertyValueFactory<>("Three"));
        T1_4.setCellValueFactory(new PropertyValueFactory<>("Four"));
        T1_5.setCellValueFactory(new PropertyValueFactory<>("Five"));
        T1_6.setCellValueFactory(new PropertyValueFactory<>("Six"));
        T1_7.setCellValueFactory(new PropertyValueFactory<>("Seven"));
        T1_8.setCellValueFactory(new PropertyValueFactory<>("Eight"));
        T1_9.setCellValueFactory(new PropertyValueFactory<>("Nine"));

    }

    public void LoadTimeTable() {
        data2.clear();
        Table_1.getItems().clear();
        for (int i = 0; i < data.size(); i++) {
            //Days
            Text day_Text = new Text(data.get(i).getC1());
            day_Text.getStyleClass().add("check-text");
            GridPane days = new GridPane();
            days.setMinSize(100, 95);
            days.setVgap(0.5);
            days.setAlignment(Pos.CENTER);
            days.getStyleClass().add("borderContaner2");
            days.add(day_Text, 0, 0);
            //One
            Button One = new Button(data.get(i).getC2());
            One.getStyleClass().add("borderContaner3");
            One.setId(String.valueOf(i));
            One.setOnAction(e -> {
                this.Update(((Control) e.getSource()).getId(), 1);
            });
            //Two
            Button Two = new Button(data.get(i).getC3());
            Two.getStyleClass().add("borderContaner3");

            //Three
            Button Three = new Button(data.get(i).getC4());
            Three.getStyleClass().add("borderContaner3");

            //Four
            Button Four = new Button(data.get(i).getC5());
            Four.getStyleClass().add("borderContaner3");

            //Five
            Button Five = new Button(data.get(i).getC6());
            Five.getStyleClass().add("borderContaner3");

            //Six
            Button Six = new Button(data.get(i).getC7());
            Six.getStyleClass().add("borderContaner3");

            //Seven
            Button Seven = new Button(data.get(i).getC8());
            Seven.getStyleClass().add("borderContaner3");

            //eight
            Button Eight = new Button(data.get(i).getC9());
            Eight.getStyleClass().add("borderContaner3");

            //Nine
            Button Nine = new Button(data.get(i).getC10());
            Nine.getStyleClass().add("borderContaner3");

            data2.addAll(new Logic.TableList(days, One, Two, Three, Four, Five, Six, Seven, Eight, Nine));
        }
        Table_1.setItems(data2);

    }

    public void Update(String Id, int Id2) {

//        
//        String day = data.get(Integer.valueOf(Id)).getC1();
//        String one = data.get(Integer.valueOf(Id)).getC2();
//        String two = data.get(Integer.valueOf(Id)).getC3();
//        String three = data.get(Integer.valueOf(Id)).getC4();
//        String four = data.get(Integer.valueOf(Id)).getC5();
//        String five = data.get(Integer.valueOf(Id)).getC6();
//        String six = data.get(Integer.valueOf(Id)).getC7();
//        String seven = data.get(Integer.valueOf(Id)).getC8();
//        String eight = data.get(Integer.valueOf(Id)).getC9();
//        String nine = data.get(Integer.valueOf(Id)).getC10();
//        //     System.out.println(one);
//        data.remove(Integer.valueOf(Id), Id2);
//        data.add(Integer.valueOf(Id), new Logic.TableList(day, "Check", two, three, four, five, six, seven, eight, nine));
//        this.LoadTimeTable();
    }

    public void LoadData_1() {
        list = data_value.getDays();
        data.clear();
        for (int i = 0; i < list.size(); i++) {
            String s = time + "  To End" + "\n" + "Class Name\nTeacher Name\nRoom No",
                    s2 = "00:00" + "  To End" + "\n" + "Class Name\nTeacher Name\nRoom No";

            data.addAll(new Logic.TableList(list.get(i), s, s2, s2, s2, s2, s2, s2, s2, s2));
        }

    }

    @FXML
    private void schoolTime_On_Clicked(ActionEvent event) {
        this.time = this.getTime(schoolTime);
        this.LoadData_1();
        this.LoadTimeTable();

    }

    public String getTime(JFXTimePicker timePicker) {
        String time = "";
        if (!timePicker.getValue().toString().isEmpty()) {
            int h = 0,
                    m = timePicker.getValue().getMinute();
            String am_pm = "";
            if (timePicker.getValue().getHour() >= 12) {
                am_pm = "PM";
                if (timePicker.getValue().getHour() == 12) {
                    h = timePicker.getValue().getHour();
                } else {
                    h = timePicker.getValue().getHour() - 12;
                }
            } else {
                am_pm = "AM";
                h = timePicker.getValue().getHour();
            }
            time = String.valueOf(h) + ":" + String.valueOf(m) + " " + am_pm;
            // time = time_Picker.getValue().get;
        }
        return time;
    }

    @FXML
    private void newOnClicked(MouseEvent event) {
        // this.Dialog();

    }

    public void ChangeCLasses() {
        changeClass.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    classCheck = newValue;

                }
            }
        }
        );

    }
}
