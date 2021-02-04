/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 *
 * @author KAMRAN QADEER
 */
public class Validation {

    boolean check = true;
    ValidationSupport validationSupport = new ValidationSupport();
    Dialogs dialogs = new Dialogs();
    String v = "";

    public boolean Cost(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (!newValue.matches("\\d*(\\.\\d*)?")) {
                field.setText(oldValue);
            } else if (newValue.equals(".")) {
                check = false;
            } else if (Double.valueOf(newValue) == 0.0 && !newValue.equals(".")) {
                field.setText("0");
            } else if (!newValue.isEmpty()) {
                text.setText("");

                check = true;
            }

        });
        return check;
    }

    public boolean Digite(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (!newValue.matches("\\d*")) {
                field.setText(oldValue);

            } else if (Double.valueOf(newValue) == 0) {
                field.setText(oldValue);
            } else if (!newValue.isEmpty()) {
                text.setText("");
                check = true;
            }
        });
        return check;
    }

    public boolean email(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (!Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(newValue).find()) {
                text.setText("only email accept!");
                check = false;
            } else {
                text.setText("");
                check = true;
            }
        });

        return check;
    }

    public boolean Contact(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (!newValue.matches("\\d*")) {
                field.setText(oldValue);
                check = false;
            } else if (newValue.length() > 7) {
                field.setText(oldValue);
            } else if (!newValue.isEmpty()) {
                text.setText("");
                check = true;
            }
        });
        return check;
    }

    public boolean Contact_Code(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (!newValue.matches("\\d*")) {
                field.setText(oldValue);
                check = false;
            } else if (newValue.length() > 4) {
                field.setText(oldValue);
            } else if (!newValue.isEmpty()) {
                text.setText("");
                check = true;
            }
        });
        return check;
    }

    public boolean ComboBox(ComboBox comb, Text text) {
        if (comb.getSelectionModel().isEmpty()) {
            check = false;
            text.setText("Pleas select !");
        } else {
            text.setText("");
            check = true;
        }
        return check;
    }

    public boolean productNameFiled(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (newValue.length() < 3) {
                text.setText("Min 2!");
                check = false;

            } else if (newValue.length() > 41) {
                text.setText(" Max 40!");
                check = false;

            } else {
                text.setText("");
                field.setText(field.getText().toString().trim().replaceAll(" +", " "));
                field.setText(field.getText().toString().trim().replaceAll("[^a-zA-Z0-9]", " "));
                check = true;

            }
        });
        return check;
    }

    public boolean UserName(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (newValue.length() < 3) {
                text.setText("Min 2!");
                check = false;

            } else if (newValue.length() > 41) {
                text.setText(" Max 40!");
                check = false;

            } else {
                text.setText("");
                field.setText(field.getText().toString().trim().replaceAll(" +", " "));
                field.setText(field.getText().toString().trim().replaceAll("[^a-zA-Z0-9]", " "));
                check = true;

            }
        });
        return check;
    }

    public boolean password(JFXPasswordField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (newValue.length() < 7) {
                text.setText("Min 6!");
                check = false;

            } else if (newValue.length() > 41) {
                text.setText(" Max 40!");
                check = false;

            } else if (!newValue.matches("\\S+")) {
                text.setText(" Space is not allow!");
                check = false;
            } else {
                text.setText("");
                check = true;

            }
        });
        return check;
    }

    public boolean Address(JFXTextField field, Text text) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                text.setText("Field is required !");
                check = false;
            } else if (newValue.length() < 3) {
                text.setText("Min 2!");
                check = false;

            } else if (newValue.length() > 51) {
                text.setText(" Max 50!");
                check = false;

            } else {
                text.setText("");
                field.setText(field.getText().toString().trim().replaceAll(" +", "  "));
                field.setText(field.getText().toString().trim().replaceAll("[^a-zA-Z0-9]", " "));
                check = true;

            }
        });
        return check;
    }

    public void Name_1(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (newValue.length() > 41) {
                    this.ErrorStyle(field, false);
                } else {
                    field.setText(field.getText().toString().trim().replaceAll("[^a-zA-Z0-9]", " "));
                    this.ErrorStyle(field, true);
                }
            }
        });
    }

    public void Name_2(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {

                if (newValue.length() > 41) {
                    this.ErrorStyle(field, false);
                } else if (newValue.matches(" ")) {
                    field.setText("");
                } else {
                    field.setText(field.getText().toString().replaceAll("\\s+", " "));
                    field.setText(field.getText().toString().replaceAll("[^a-zA-Z0-9]", " "));
                    this.ErrorStyle(field, true);
                }
            }
        });
    }

    public void Discription(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (newValue.length() > 100) {
                    this.ErrorStyle(field, false);
                } else if (newValue.matches(" ")) {
                    field.setText("");
                } else {
                    field.setText(field.getText().toString().replaceAll("\\s+", " "));
                    field.setText(field.getText().toString().replaceAll("[^a-zA-Z0-9]", " "));
                    this.ErrorStyle(field, true);
                }
            }
        });
    }

    public void Number(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (!newValue.matches("\\d*")) {
                    field.setText(oldValue);
                } else if (Double.valueOf(newValue) == 0) {
                    field.setText("0");
                } else if (!newValue.isEmpty()) {
                    this.ErrorStyle(field, true);
                }
            }
        });
        this.ErrorStyle(field, check);
    }

    public void Number2(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    field.setText(oldValue);
                } else if (Double.valueOf(newValue) == 0) {
                    field.setText("0");
                } else if (!newValue.isEmpty()) {
                    this.ErrorStyle(field, true);
                }
            }
        });
        this.ErrorStyle(field, check);
    }

    public void email(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (!Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(oldValue).find()) {
                    this.ErrorStyle(field, false);
                } else {
                    this.ErrorStyle(field, true);

                }
            }
        });
        this.ErrorStyle(field, check);
    }

    public boolean DOB(DatePicker DateOfBirth, String message) {
        if (DateOfBirth.getValue().toString().isEmpty()) {
            DateOfBirth.getStyleClass().remove("input2");
            DateOfBirth.getStyleClass().add("input_Error");
            dialogs.Notofication("Error", message, "Wrong");
            return false;
        } else {
            DateOfBirth.getStyleClass().remove("input_Error");
            DateOfBirth.getStyleClass().add("input2");
            return true;
        }
    }

    public void ContactNo(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (!newValue.matches("\\d*")) {
                    field.setText(oldValue);
                } else if (newValue.length() > 7) {
                    field.setText(oldValue);
                } else if (!newValue.isEmpty()) {
                    this.ErrorStyle(field, true);
                }
            }
        });
        this.ErrorStyle(field, check);
    }

    public void CNIC(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                if (!newValue.matches("\\d*")) {
                    field.setText(oldValue);
                } else if (newValue.length() > 13) {
                    field.setText(oldValue);
                } else if (newValue.length() < 13) {
                    this.ErrorStyle(field, false);
                } else if (!newValue.isEmpty()) {
                    this.ErrorStyle(field, true);
                }
            }
        });
        this.ErrorStyle(field, check);
    }

    public boolean CheckEmpty(JFXTextField field, String message) {
        if (field.getText().isEmpty()) {
            dialogs.Notofication("Error", message, "Wrong");
            validationSupport.registerValidator(field, Validator.createEmptyValidator(message));
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckCombox(ComboBox field, String message) {
        if (field.getValue() == null) {
            dialogs.Notofication("Error", message, "Wrong");
            validationSupport.registerValidator(field, Validator.createEmptyValidator(message));
            return false;
        } else {
            return true;
        }
    }

    public void ErrorStyle(JFXTextField field, boolean check) {
        if (!check) {
            field.getStyleClass().remove("input2");
            field.getStyleClass().add("input_Error");
        } else {
            field.getStyleClass().remove("input_Error");
            field.getStyleClass().add("input2");
        }
    }

}
