/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author KAMRAN QADEER
 */
public class Dialogs {

    JFXDialogLayout content = new JFXDialogLayout();
    boolean check = false;
    BoxBlur blur = new BoxBlur(3, 3, 3);

    public void error_Dialog(StackPane pane, String message, String Header) {
        pane.setEffect(blur);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setTitle(null);
        alert.setHeaderText(Header);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            pane.setEffect(null);
            alert.close();
        } else {
            // ... user chose CANCEL or closed the dialog
            pane.setEffect(null);
            alert.close();
        }
    }

    public boolean confirm_Dialog(StackPane pane, String Message) {
        pane.setEffect(blur);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setTitle(null);
        alert.setHeaderText("Confirmation");
        alert.setContentText(Message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            pane.setEffect(null);
            return true;
        } else {
            // ... user chose CANCEL or closed the dialog
            pane.setEffect(null);
            alert.close();
            return false;

        }
    }

    public boolean info_Dialog(StackPane pane, String Message) {
        pane.setEffect(blur);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setTitle(null);
        alert.setHeaderText("Information");
        alert.setContentText(Message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            pane.setEffect(null);
            return true;
        } else {
            // ... user chose CANCEL or closed the dialog
            pane.setEffect(null);
            return false;

        }

    }

    public void Notofication(String title, String Message, String src) {
        InputStream targetStream = null;
        try {
            File location_File = new File("E:\\System\\" + src + ".png");
            targetStream = new DataInputStream(new FileInputStream(location_File));
            // InputStream file = this.getClass().getClassLoader().getResourceAsStream("/resources/icon/" + src + ".png");
            Image i = new Image(targetStream);
            ImageView image = new ImageView(i);
            Notifications notefications = Notifications.create()
                    .title(title)
                    .text(Message)
                    .darkStyle()
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_RIGHT)
                    .graphic(image)
                    .onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Check");
                        }
                    });
            notefications.show();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialogs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                targetStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Dialogs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
