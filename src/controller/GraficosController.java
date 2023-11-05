package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Joaquín
 */
public class GraficosController implements Initializable {

    @FXML
    private TextField userLogin;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private Button btn_login;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void usuarioKey(KeyEvent event) {
    }

    @FXML
    private void login(ActionEvent event) {
    }

    @FXML
    private void passwordLogin(KeyEvent event) {
    }
    
}
