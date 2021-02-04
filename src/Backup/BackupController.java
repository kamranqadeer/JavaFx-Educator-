/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

import Logic.Dialogs;
import Logic.kk_Logic;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author KAMRAN QADEER
 */
public class BackupController implements Initializable {

    String location = null,
            fileName, date = "";
    kk_Logic logic = new kk_Logic();
    Dialogs dialogs = new Dialogs();
    @FXML
    private JFXTextField file_Select;
    @FXML
    private JFXButton backUp;
    @FXML
    private ImageView close;
    @FXML
    private Text text1;
    @FXML
    private JFXButton select;
    @FXML
    private Text com_Text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy");
        Calendar cal1 = Calendar.getInstance();
        date = dateFormat1.format(cal1.getTime()) + logic.getMonth(dateFormat2.format(cal1.getTime())) + dateFormat3.format(cal1.getTime());
    }

    public boolean CreatBackUp() {
        boolean check = false;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("C:/wamp64/bin/mysql/mysql5.7.14/bin/mysqldump.exe -uroot --add-drop-database -B educator -r" + fileName);
            int processComplete = p.waitFor();
            if (processComplete == 0) {
                // get a handle to the stage
                Stage stage = (Stage) backUp.getScene().getWindow();
                // do what you have to do
                stage.close();
                check = true;

            } else {
                check = false;
            }

        } catch (Exception e) {
            dialogs.Notofication("Error", "System error", "Wrong");
        }
        return check;
    }

    @FXML
    private void backup_OnClicked(ActionEvent event) {
        if (file_Select.getText().isEmpty()) {
            dialogs.Notofication("Error", "First select the the location", "Wrong");
        } else {
            if (this.CreatBackUp()) {
                dialogs.Notofication("Backup", "BackUp is created", "okay");
            } else {
                dialogs.Notofication("Error", "BackUp is not created", "Wrong");
            }
        }
    }
    @FXML
    private void close_On_Acc(MouseEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

    @FXML
    private void select_On_Action(ActionEvent event) {
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(path);

        try {
            File file = path.getSelectedFile();
            location = file.getAbsolutePath();
            location = location.replace("\\", "/");
            fileName = location + "_" + date + ".sql";
            file_Select.setText(fileName);
        } catch (Exception e) {
            dialogs.Notofication("Error", "Location is wrong", "Wrong");
        }
    }
}