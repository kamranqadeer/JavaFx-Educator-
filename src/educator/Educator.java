/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educator;

import Logic.Data;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author KAMRAN QADEER
 */
public class Educator extends Application {

    public static Boolean isSplashLoader = false;
    public static Stage loginStage;
    static boolean isSplashLoaded;
    public Stage stage;
    Data data = new Data();

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/LogIn/logIn.fxml"));
        loginStage = stage;
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
       // stage.setIconified(true);
        stage.show();
//        stage.setOpacity(0.9);
        stage.getIcons().add(new Image(data.getImage("MainLogo")));

        this.stage = stage;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
