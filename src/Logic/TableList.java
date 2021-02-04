/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author KAMRAN QADEER
 */
public class TableList {

    /**
     * @return the Id
     */
    private String C0, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11;
    private Button delete, print, edit, details, One, Two, Three, Four, Five, Six, Seven, Eight, Nine;
    private Circle circle, circle2;
    private GridPane gridPane, gridPane2;
    private JFXTextField input1, input2;
    private Text text1;
    private CheckBox checkBox1;

    public TableList(String C1, String C2, String C3, String C4, String C5, String C6, GridPane gridPane) {
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.gridPane = gridPane;
    }

    public TableList(String C0, String C1, String C2, String C3, GridPane gridPane) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.gridPane = gridPane;
    }

    public TableList(String C0, String C1, String C2, Circle circle) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.circle = circle;
    }

    public TableList(GridPane gridPane, String C1, String C2, JFXTextField input1, GridPane gridPane2, Text text1, Circle circle, Button delete) {
        this.C1 = C1;
        this.C2 = C2;
        this.gridPane = gridPane;
        this.input1 = input1;
        this.gridPane2 = gridPane2;
        this.text1 = text1;
        this.circle = circle;
        this.delete = delete;
    }

    public TableList(GridPane gridPane2, String C1, String C2, String C3, String C4, GridPane gridPane, Circle circle2, Button details) {
        this.gridPane2 = gridPane2;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.gridPane = gridPane;
        this.circle2 = circle2;
        this.details = details;
    }

    public TableList(String C1, String C2, String C3, String C4, String C5, Circle circle, GridPane gridPane) {
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.circle = circle;
        this.gridPane = gridPane;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, Button details, Button delete) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.details = details;
        this.delete = delete;
    }

    public TableList(String C1, String C2, String C3, String C4, String C5, String C6, String C7, String C8, String C9, String C10) {
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
        this.C8 = C8;
        this.C9 = C9;
        this.C10 = C10;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, String C6, String C7, String C8, String C9, Button delete) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
        this.C8 = C8;
        this.C9 = C9;
        this.delete = delete;
    }

    public TableList(GridPane gridPane, Button One, Button Two, Button Three, Button Four, Button Five, Button Six, Button Seven, Button Eight, Button Nine) {
        this.gridPane = gridPane;
        this.One = One;
        this.Two = Two;
        this.Three = Three;
        this.Four = Four;
        this.Five = Five;
        this.Six = Six;
        this.Seven = Seven;
        this.Eight = Eight;
        this.Nine = Nine;

    }

    public TableList(String C1, String C2, GridPane gridPane2, String C4, String C5, String C6, String C7, String C8, String C9, Button print) {
        this.C1 = C1;
        this.C2 = C2;
        this.gridPane2 = gridPane2;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
        this.C8 = C8;
        this.C9 = C9;
        this.print = print;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, String C6, String C7, String C8, String C9, String C10, String C11) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
        this.C8 = C8;
        this.C9 = C9;
        this.C10 = C10;
        this.C11 = C11;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, String C6, String C7, String C8) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
        this.C8 = C8;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
    }

    public TableList(Circle circle, String C1, String C2, String C3, String C4, String C5, String C6, String C7, Button details, GridPane gridPane) {
        this.circle = circle;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
        this.details = details;
        this.gridPane = gridPane;

    }

    public TableList(String C0, String C1, String C2, String C3, Button details, Button edit, Button delete) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.details = details;
        this.edit = edit;
        this.delete = delete;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, Button delete) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.delete = delete;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, Button delete) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.delete = delete;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, String C6) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;

    }

    public TableList(String C0, String C1, String C2, String C3, String C4, String C5, String C6, String C7) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.C4 = C4;
        this.C5 = C5;
        this.C6 = C6;
        this.C7 = C7;
    }

    public TableList(String C0, String C1, String C2) {

        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
    }

    public TableList(String C0, String C1) {

        this.C0 = C0;
        this.C1 = C1;
    }

    public TableList(String C0, String C1, String C2, String C3) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
    }

    public TableList(String C0, String C1, String C2, String C3, Button delete) {
        this.C0 = C0;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        this.delete = delete;
    }

// check data
    /**
     * @return the C0
     */
    public String getC0() {
        return C0;
    }

    /**
     * @param C0 the C0 to set
     */
    public void setC0(String C0) {
        this.C0 = C0;
    }

    /**
     * @return the C1
     */
    public String getC1() {
        return C1;
    }

    /**
     * @param C1 the C1 to set
     */
    public void setC1(String C1) {
        this.C1 = C1;
    }

    /**
     * @return the C2
     */
    public String getC2() {
        return C2;
    }

    /**
     * @param C2 the C2 to set
     */
    public void setC2(String C2) {
        this.C2 = C2;
    }

    /**
     * @return the C3
     */
    public String getC3() {
        return C3;
    }

    /**
     * @param C3 the C3 to set
     */
    public void setC3(String C3) {
        this.C3 = C3;
    }

    /**
     * @return the C4
     */
    public String getC4() {
        return C4;
    }

    /**
     * @param C4 the C4 to set
     */
    public void setC4(String C4) {
        this.C4 = C4;
    }

    /**
     * @return the C5
     */
    public String getC5() {
        return C5;
    }

    /**
     * @param C5 the C5 to set
     */
    public void setC5(String C5) {
        this.C5 = C5;
    }

    /**
     * @return the C6
     */
    public String getC6() {
        return C6;
    }

    /**
     * @param C6 the C6 to set
     */
    public void setC6(String C6) {
        this.C6 = C6;
    }

    /**
     * @return the C7
     */
    public String getC7() {
        return C7;
    }

    /**
     * @param C7 the C7 to set
     */
    public void setC7(String C7) {
        this.C7 = C7;
    }

    /**
     * @return the C8
     */
    public String getC8() {
        return C8;
    }

    /**
     * @param C8 the C8 to set
     */
    public void setC8(String C8) {
        this.C8 = C8;
    }

    /**
     * @return the C9
     */
    public String getC9() {
        return C9;
    }

    /**
     * @param C9 the C9 to set
     */
    public void setC9(String C9) {
        this.C9 = C9;
    }

    /**
     * @return the C10
     */
    public String getC10() {
        return C10;
    }

    /**
     * @param C10 the C10 to set
     */
    public void setC10(String C10) {
        this.C10 = C10;
    }

    /**
     * @return the C11
     */
    public String getC11() {
        return C11;
    }

    /**
     * @param C11 the C11 to set
     */
    public void setC11(String C11) {
        this.C11 = C11;
    }

    /**
     * @return the delete
     */
    public Button getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(Button delete) {
        this.delete = delete;
    }

    /**
     * @return the circle
     */
    public Circle getCircle() {
        return circle;
    }

    /**
     * @param circle the circle to set
     */
    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    /**
     * @return the print
     */
    public Button getPrint() {
        return print;
    }

    /**
     * @param print the print to set
     */
    public void setPrint(Button print) {
        this.print = print;
    }

    /**
     * @return the edit
     */
    public Button getEdit() {
        return edit;
    }

    /**
     * @param edit the edit to set
     */
    public void setEdit(Button edit) {
        this.edit = edit;
    }

    /**
     * @return the details
     */
    public Button getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(Button details) {
        this.details = details;
    }

    /**
     * @return the gridPane
     */
    public GridPane getGridPane() {
        return gridPane;
    }

    /**
     * @param gridPane the gridPane to set
     */
    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    /**
     * @return the gridPane2
     */
    public GridPane getGridPane2() {
        return gridPane2;
    }

    /**
     * @param gridPane2 the gridPane2 to set
     */
    public void setGridPane2(GridPane gridPane2) {
        this.gridPane2 = gridPane2;
    }

    /**
     * @return the circle2
     */
    public Circle getCircle2() {
        return circle2;
    }

    /**
     * @param circle2 the circle2 to set
     */
    public void setCircle2(Circle circle2) {
        this.circle2 = circle2;
    }

    /**
     * @return the input1
     */
    public JFXTextField getInput1() {
        return input1;
    }

    /**
     * @param input1 the input1 to set
     */
    public void setInput1(JFXTextField input1) {
        this.input1 = input1;
    }

    /**
     * @return the input2
     */
    public JFXTextField getInput2() {
        return input2;
    }

    /**
     * @param input2 the input2 to set
     */
    public void setInput2(JFXTextField input2) {
        this.input2 = input2;
    }

    /**
     * @return the text1
     */
    public Text getText1() {
        return text1;
    }

    /**
     * @param text1 the text1 to set
     */
    public void setText1(Text text1) {
        this.text1 = text1;
    }

    /**
     * @return the checkBox1
     */
    public CheckBox getCheckBox1() {
        return checkBox1;
    }

    /**
     * @param checkBox1 the checkBox1 to set
     */
    public void setCheckBox1(CheckBox checkBox1) {
        this.checkBox1 = checkBox1;
    }

    /**
     * @return the One
     */
    public Button getOne() {
        return One;
    }

    /**
     * @param One the One to set
     */
    public void setOne(Button One) {
        this.One = One;
    }

    /**
     * @return the Two
     */
    public Button getTwo() {
        return Two;
    }

    /**
     * @param Two the Two to set
     */
    public void setTwo(Button Two) {
        this.Two = Two;
    }

    /**
     * @return the Three
     */
    public Button getThree() {
        return Three;
    }

    /**
     * @param Three the Three to set
     */
    public void setThree(Button Three) {
        this.Three = Three;
    }

    /**
     * @return the Four
     */
    public Button getFour() {
        return Four;
    }

    /**
     * @param Four the Four to set
     */
    public void setFour(Button Four) {
        this.Four = Four;
    }

    /**
     * @return the Five
     */
    public Button getFive() {
        return Five;
    }

    /**
     * @param Five the Five to set
     */
    public void setFive(Button Five) {
        this.Five = Five;
    }

    /**
     * @return the Six
     */
    public Button getSix() {
        return Six;
    }

    /**
     * @param Six the Six to set
     */
    public void setSix(Button Six) {
        this.Six = Six;
    }

    /**
     * @return the Seven
     */
    public Button getSeven() {
        return Seven;
    }

    /**
     * @param Seven the Seven to set
     */
    public void setSeven(Button Seven) {
        this.Seven = Seven;
    }

    /**
     * @return the Eight
     */
    public Button getEight() {
        return Eight;
    }

    /**
     * @param Eight the Eight to set
     */
    public void setEight(Button Eight) {
        this.Eight = Eight;
    }

    /**
     * @return the Nine
     */
    public Button getNine() {
        return Nine;
    }

    /**
     * @param Nine the Nine to set
     */
    public void setNine(Button Nine) {
        this.Nine = Nine;
    }

  
}
