/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import educator.sqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

/**
 *
 * @author KAMRAN QADEER
 */
public class kk_Logic {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DecimalFormat numberFormat = new DecimalFormat("#.00");

    public ResultSet getFiledData(String t_Name, String f_Name) {
        try {
            con = sqlConnection.ConnectDB();
            pst = con.prepareStatement("Select " + f_Name + " from `" + t_Name + "`");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public String resentId(String t_Name, String f_Name) {
        String Value = "";
        try {
            Statement stmt;
            con = sqlConnection.ConnectDB();
            stmt = con.createStatement();
            String sql1 = "SELECT " + f_Name + " FROM " + t_Name + " WHERE " + f_Name + " = (SELECT MAX(" + f_Name + ") FROM " + t_Name + ")";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                Value = rs.getString(f_Name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        return Value;
    }

    //get field Data
    public String Check_Id(String table_Name, String f_Name, String id) {
        String check = "";
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select " + f_Name + " from " + table_Name + " where " + f_Name + "= '" + id + "'";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                check = rs.getString(f_Name);

            } else {
                check = "";
            }

        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public ResultSet getAllData(String t_Name) {
        try {
            con = sqlConnection.ConnectDB();
            pst = con.prepareStatement("Select * from `" + t_Name + "`");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }

    public String getTableValue(String t_Name, String f_Name, String f_Id, String id) {
        String Value = "";
        try {
            con = sqlConnection.ConnectDB();
            Statement stmt;
            stmt = con.createStatement();
            String sql1 = "Select " + f_Name + " from " + t_Name + " where " + f_Id + "= '" + id + "'";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                Value = rs.getString(f_Name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
        return Value;
    }

    public ResultSet getTable_Data(String t_Name, String id, String C, String Dec_C) {
        try {
            con = sqlConnection.ConnectDB();
            pst = con.prepareStatement("Select * from `" + t_Name + "` Where " + C + "='" + id + "'ORDER BY " + Dec_C + " DESC");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    //Delete Data

    public void deleteData(String t_Name, String t_Coloum, String id) {

        String sq = "delete  from " + t_Name + " where " + t_Coloum + " = ?";
        try {
            con = sqlConnection.ConnectDB();
            pst = con.prepareStatement(sq);
            pst.setString(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
        }
    }

    public void deleteData2(String t_Name, String t_Coloum1, String id1, String t_Coloum2, String id2) {

        String sq = "delete  from " + t_Name + " where " + t_Coloum1 + " ='" + id1 + "' And " + t_Coloum2 + " ='" + id2 + "'";
        try {
            con = sqlConnection.ConnectDB();
            pst = con.prepareStatement(sq);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(kk_Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.CloseConnection();
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

    public String getDay() {
        // Setting Date And time

        DateFormat dateFormat1 = new SimpleDateFormat("dd");

        Calendar cal1 = Calendar.getInstance();

        return dateFormat1.format(cal1.getTime());

    }

    public String getTime() {
        // Setting Date And time
        DateFormat dateFormat0 = new SimpleDateFormat("hh:mm a");

        Calendar cal1 = Calendar.getInstance();

        return dateFormat0.format(cal1.getTime());
    }

    public String getMonth() {
        // Setting Date And time

        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        Calendar cal1 = Calendar.getInstance();
        return this.getMonth(dateFormat2.format(cal1.getTime()));
    }

    public String getYear() {
        // Setting Date And time

        DateFormat dateFormat3 = new SimpleDateFormat("yyyy");
        Calendar cal1 = Calendar.getInstance();

        return dateFormat3.format(cal1.getTime());
    }

    //get Month
    public String getMonth(String m) {
        switch (m) {
            case "01":
                // code block
                return "January";
            case "02":
                // code block
                return "February";

            case "03":
                // code block
                return "March";
            case "04":
                // code block
                return "April";
            case "05":
                // code block
                return "May";
            case "06":
                // code block
                return "June";
            case "07":
                // code block
                return "July";
            case "08":
                // code block
                return "August";
            case "09":
                // code block
                return "September";
            case "10":
                // code block
                return "October";
            case "11":
                // code block
                return "November";
            default:
                // code block
                return "December";
        }
    }

    public String getPercentage(String TotalMarks, String obtainMarks) {
        float per = Float.valueOf(obtainMarks) * 100 / Float.valueOf(TotalMarks);
        return numberFormat.format(per)+" %";
    }

    public String getGrade(String v) {
        String temp[] = v.split(" ");
        double per = Double.valueOf(temp[0]);
        if (per >= 85) {
            return "A+";
        } else if (per > 79 && per < 84) {
            return "A";
        } else if (per > 74 && per < 80) {
            return "B+";
        } else if (per > 69 && per < 75) {
            return "B";
        } else if (per > 64 && per < 70) {
            return "C+";
        } else if (per > 59 && per < 65) {
            return "C";
        } else if (per > 54 && per < 60) {
            return "D+";
        } else if (per > 49 && per < 55) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getResult(String passingMarks, String obtainMarks) {
        if (Double.valueOf(obtainMarks) > Double.valueOf(passingMarks)) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public String getDiscription(String v) {
        String temp[] = v.split(" ");
        double per = Double.valueOf(temp[0]);
        if (per >= 85) {
            return "EXCELLENT WORK";
        } else if (per > 79 && per < 84) {
            return "WELL DON GREAT WORK";
        } else if (per > 74 && per < 80) {
            return "GOOD WORK";
        } else if (per > 69 && per < 75) {
            return "FAIR KEEP GOINING ON";
        } else if (per > 64 && per < 70) {
            return "SATISFACTORY";
        } else if (per > 59 && per < 65) {
            return "UN SATISFACTORY";
        } else if (per > 54 && per < 60) {
            return "TRY TO MORE EFFORT";
        } else if (per > 49 && per < 55) {
            return "POOR WORK";
        } else {
            return "YOU ARE FAIL";
        }
    }

    //set Table Size
    public void Table_Resize(TableView<Logic.TableList> tableView, double value) {
        //Set the right policy
        tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().stream().forEach((column)
                -> {
            //Minimal width = columnheader
            Text t = new Text(column.getText());
            double max = t.getLayoutBounds().getWidth();
            for (int i = 0; i < tableView.getItems().size(); i++) {
                //cell must not be empty
                if (column.getCellData(i) != null) {
                    t = new Text(column.getCellData(i).toString());
                    double calcwidth = t.getLayoutBounds().getWidth();
                    //remember new max-width
                    if (calcwidth > max) {
                        max = calcwidth;
                    }
                }
                column.setPrefWidth(max + value);
            }
            //set the new max-widht with some extra space
        });
    }

}
