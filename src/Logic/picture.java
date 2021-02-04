/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author KAMRAN QADEER
 */
public class picture {

    public boolean UploadPicture(String name, Circle circle) {
        boolean check = false;
        try {
            //select and set image
            Stage stage = new Stage();
            FileChooser filechooser = new FileChooser();
            filechooser.setTitle("Chose file");
            filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"),
                    new FileChooser.ExtensionFilter("JPEG", "*.jpg"));
            File selectFile = filechooser.showOpenDialog(stage);
            if (selectFile != null) {
                Image orignalImage = new Image(selectFile.toURI().toString(), 140, 140, false, false);
                circle.setFill(new ImagePattern(orignalImage));
                circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.TRANSPARENT));
                File saveLocation = new File("E:/System/" + name + ".png");
                //Save Image
                BufferedImage bi = SwingFXUtils.fromFXImage(orignalImage, null);
                check = ImageIO.write(bi, "png", saveLocation);
            }
        } catch (IOException ex) {
            Logger.getLogger(picture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean checkImage(String name) {
        File f = new File("E:/System/" + name + ".png");
        return f.exists();
    }

    public void uploadImage(String name, Circle circle) {
        File f;
        if (this.checkImage(name)) {
            f = new File("E:/System/" + name + ".png");
        } else {
            f = new File("E:/System/user.png");
        }
        Image orignalImage = new Image(f.toURI().toString(), 140, 140, false, false);
        circle.setFill(new ImagePattern(orignalImage));
        circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.TRANSPARENT));
    }

    public void DeleteImage(String name) {
        if (this.checkImage(name)) {
            //DELETE ELEMENT FROM FOLDER
            File f = new File("E:/System/" + name + ".png");
            f.delete();
        }
    }
}
