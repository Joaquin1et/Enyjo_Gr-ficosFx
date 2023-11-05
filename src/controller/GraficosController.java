package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Conexion;

/**
 *
 * @author Joaquín
 */
public class GraficosController implements Initializable {

    @FXML
    private Button btn_login;
    @FXML
    private TextField txt_userLogin;
    @FXML
    private PasswordField txt_passwordLogin;

    public static String user = "";
    private String pass = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void usuarioKey(KeyEvent event) {
    }

    @FXML
    private void login(ActionEvent event) {

        user = txt_userLogin.getText().trim();
        pass = txt_passwordLogin.getText().trim();

        if (!user.equals("") && !pass.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select usuario, password from usuarios where usuario = '" + user + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    try {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));

                        Parent root = loader.load();
                        PrincipalController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        //stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        stage = (Stage) this.btn_login.getScene().getWindow();
                        stage.close();
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Datos de acceso incorrectos.");
                    alert.showAndWait();

                    Limpiar();
                }

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Error en la base de datos.");
                alert.showAndWait();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe rellenar todos los campos.");
            alert.showAndWait();

            Limpiar();

        }

    }

    @FXML
    private void passwordLogin(KeyEvent event) {
    }

    public void Limpiar() {

        txt_userLogin.setText("");
        txt_passwordLogin.setText("");
    }
}
