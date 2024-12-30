package view;

import entities.GeneratePassword;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HomeController implements Initializable {

    private final GeneratePassword generate = new GeneratePassword();

    @FXML
    private RadioButton rbABC;//[0]

    @FXML
    private RadioButton rbabc;//[1]

    @FXML
    private RadioButton rb123;//[2]

    @FXML
    private RadioButton rbCharacters;//[3]

    @FXML
    private Slider sliderNumber;

    @FXML
    private TextField txtSize;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private Label labelAlert;

    private int passwordSize;
    private final boolean[] option = new boolean[5];

    public void onBtCreatePassword() {
        option[0] = rbABC.isSelected();
        option[1] = rbabc.isSelected();
        option[2] = rb123.isSelected();
        option[3] = rbCharacters.isSelected();

        passwordSize = Integer.parseInt(txtSize.getText());

        boolean rbSelected = false;

        for (boolean b : option) {
            if (b) {
                rbSelected = true;
                break;
            }
        }

        if (passwordSize < 6 || passwordSize > 100) {
            alertLabel("Tamanho invalido. Digite um valor entre 6  e 100");
        } else if (rbSelected) {
            alertLabel("");
            txtNewPassword.setText(generate.passwordWithoutkey(option, passwordSize));
        } else {
            alertLabel("Selecione pelo menos um Caracteres.");
        }
    }

    public void onBtPasswordStandard() {
        alertLabel("");
        txtNewPassword.setText(generate.passwordStandard());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        txtNewPassword.setText(generate.passwordStandard());
        sliderNumber.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            passwordSize = (int) sliderNumber.getValue();
            txtSize.setText("" + passwordSize);
        });
    }

    private void alertLabel(String text) {
        labelAlert.setStyle("-fx-text-fill: red;");
        labelAlert.setText(text);
    }

}
