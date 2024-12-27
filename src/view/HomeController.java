package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HomeController implements Initializable {

    @FXML
    private Button btCreate;

    @FXML
    private RadioButton rb123;

    @FXML
    private RadioButton rbABC;

    @FXML
    private RadioButton rbCharacters;

    @FXML
    private RadioButton rbKey;

    @FXML
    private RadioButton rbabc;

    @FXML
    private Slider sliderNumber;

    @FXML
    private TextField txtKey;

    @FXML
    private Label labelNumber;

    @FXML
    private TextField txtPassword;
    
    private int passwordSize;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       initializeNodes();
    }    
 
    private void initializeNodes() {
        sliderNumber.valueProperty().addListener(new ChangeListener<Number>() {
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               passwordSize = (int) sliderNumber.getValue();
               labelNumber.setText(""+passwordSize);
           }   
       });
    }
    
}
