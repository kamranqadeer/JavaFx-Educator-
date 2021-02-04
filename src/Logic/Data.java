/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

/**
 *
 * @author KAMRAN QADEER
 */
public class Data {

    PreparedStatement pst = null;
    kk_Logic logic = new kk_Logic();
    ResultSet rs = null;
    public String Contact_Cumbers = "0345-8652594,0345-5517525 Email:  riasatali0345@gmail.com",
            address = "Near Askari Cement Factory Road Wah Rawalpindi District",
            sale_Discription = "THANKS..../nReturn with in 7 days ,you can return all products and change\nNo Return Without Bill",
            purchase_Discription = "",
            software_Develope = "This software powered by Flux.com Contact: 03444200515 / 03165752518 "
            + "Email:kamran.qadeer.26@gmail.com";

    public ObservableList<String> getMonth() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
        return scale;
    }

    public ObservableList<String> getDays() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        );
        return scale;
    }

    public ObservableList<String> CurrentFee(String Id) {
        ObservableList<String> scale = FXCollections.observableArrayList();
        try {
            rs = logic.getTable_Data("classes", Id, "C1", "C1");
            while (rs.next()) {
                scale.add("Annual Fund@" + rs.getString("C3"));
                scale.add("Sunmmer Task@" + rs.getString("C4"));
                scale.add("Monthly Fee@" + rs.getString("C5"));
                scale.add("Tuition Fee@" + rs.getString("C6"));
                scale.add("Registration Fee@" + rs.getString("C7"));
                scale.add("Examination Fee@" + rs.getString("C8"));
                scale.add("Lab Chargers Fee@" + rs.getString("C9"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scale;
    }

    public ObservableList<String> getYear() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "2020", "2021", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032");
        return scale;
    }

    public ObservableList<String> Classes() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Play Group", "Nursery", "K G", "One 1", "Two 2", "Three 3", "Four 4", "Five 5", "Six 6", "Seven 7", "Eight 8", "Nine 9", "Ten 10");
        return scale;
    }

    public ObservableList<String> getPortal() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Home", "All Reports", "Study Structure", "Activities", "Attendance", "Add Classes", "All Employees", "Registration");
        return scale;
    }

    public ObservableList<String> getPayments() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Student", "Employ");
        return scale;
    }

    public ObservableList<String> getReligion() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Islam", "Hinduism", "Christianity");
        return scale;
    }

    public ObservableList<String> getGender() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Male", "Fe-Male", "NoN");
        return scale;
    }

    public ObservableList<String> Designation() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Teacher", "Supporting Teacher", "Helper", "Worker");
        return scale;
    }

    public ObservableList<String> DegreeStatus() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Complete", "Countinue", "Start");
        return scale;
    }

    public ObservableList<String> getActivities() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Quiz", "Oral Test", "Activities", "Assignments", "Home Tasks", "Exams");
        return scale;
    }

    public ObservableList<String> Nationality() {
        ObservableList<String> scale = FXCollections.observableArrayList(
                "Pakistan", "Kashmir", "Afganistan");
        return scale;
    }

    public ObservableList<String> Percintage() {
        ObservableList<String> scale = FXCollections.observableArrayList();
        for (int i = 100; i >= 45; i--) {
            scale.add(String.valueOf(i) + " %");
        }
        return scale;
    }

    public ObservableList<String> getTeachers() {
        ObservableList<String> teacher = FXCollections.observableArrayList();
        try {
            rs = logic.getAllData("employ");
            while (rs.next()) {
                if (rs.getString("C6").equals("Teacher")) {
                    teacher.add(rs.getString("C1") + "-" + rs.getString("C3"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teacher;
    }

    public ObservableList<String> getEmploys() {
        ObservableList<String> employ = FXCollections.observableArrayList();
        try {
            rs = logic.getAllData("employ");
            while (rs.next()) {
                employ.add(rs.getString("C1") + "-" + rs.getString("C3"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employ;
    }

    public ObservableList<String> getStudents() {
        ObservableList<String> student = FXCollections.observableArrayList();
        try {
            rs = logic.getAllData("student");
            while (rs.next()) {
                student.add(rs.getString("C1") + "/" + rs.getString("C3") + "/" + rs.getString("C10"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    public ObservableList<String> getClasses() {
        ObservableList<String> classes = FXCollections.observableArrayList();
        try {
            rs = logic.getAllData("classes");
            while (rs.next()) {
                classes.add(rs.getString("C1"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

    public ObservableList<String> getAllCodes() {
        ObservableList<String> all_Codes = FXCollections.observableArrayList(
                "0341", "0342", "0343", "0344", "0345", "0346", "0347", "0348", "0349",
                "0300", "0301", "0302", "0303", "0304", "0305", "0306", "0307", "0308", "0309",
                "0311", "0312", "0313", "0314", "0315", "0316", "0317", "0318", "0319",
                "0331", "0332", "0333", "0334", "0335", "0336", "0337", "0338", "0339", "0355",
                "0321", "0322", "0323", "0324", "0325", "0326", "0327", "0328", "0329");
        return all_Codes;

    }

    public ObservableList<String> getSubjects() {
        ObservableList<String> subjects = FXCollections.observableArrayList("NON");
        try {
            rs = logic.getAllData("classdetails");
            while (rs.next()) {
                subjects.add(rs.getString("C2"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
    }

    public ObservableList<String> getSubjects(String Class) {
        ObservableList<String> subjects = FXCollections.observableArrayList("NON");
        try {
            rs = logic.getTable_Data("classdetails", Class, "C1", "C0");
            while (rs.next()) {
                subjects.add(rs.getString("C2"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
    }

    public InputStream getImage(String name) throws FileNotFoundException {
        InputStream targetStream = null;
        File location_File = new File("E:\\System\\" + name + ".png");
        targetStream = new DataInputStream(new FileInputStream(location_File));
        return targetStream;
    }

    public void SetComBox(ComboBox box, String type) {
        switch (type) {
            case "getReligion": {
                box.setValue("Islam");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getReligion());
                new combox<String>(box);
                break;
            }
            case "getGender": {
                box.setValue("Male");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getGender());
                new combox<String>(box);
                break;

            }
            case "Designation": {
                box.setValue("Teacher");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.Designation());
                new combox<String>(box);
                break;

            }
            case "DegreeStatus": {
                box.setValue("Complete");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.DegreeStatus());
                new combox<String>(box);
                break;
            }
            case "Percintage": {
                box.setValue("60 %");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.Percintage());
                new combox<String>(box);
                break;

            }
            case "getTeachers": {
                box.setValue("Non");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getTeachers());
                new combox<String>(box);
                break;
            }
            case "getEmploys": {
                box.setValue("Non");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getEmploys());
                new combox<String>(box);
                break;
            }
            case "getActivities": {
                box.setValue("Quiz");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getActivities());
                new combox<String>(box);
                break;
            }
            case "getAllCodes": {
                box.setValue("0344");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getAllCodes());
                new combox<String>(box);
                break;
            }
            case "getSubjects": {
                box.setValue("Non");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getSubjects());
                new combox<String>(box);
                break;
            }
            case "getStudents": {
                box.setValue("Non");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getStudents());
                new combox<String>(box);
                break;
            }
            case "getClasses": {
                box.setValue("Play Group");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.getClasses());
                new combox<String>(box);
                break;
            }
            case "Nationality": {
                box.setValue("Pakistan");
                box.setTooltip(new Tooltip());
                box.getItems().addAll(this.Nationality());
                new combox<String>(box);
                break;
            }
            default: {
                break;

            }

        }
    }

}
