/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;

/**
 *
 * @author joaqu
 */
public class Conexion {
    
    public static Connection conectar(){
        
       Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/loginfx");
        
        } catch (Exception ex) {
            System.out.println("Error base de datos Hsqldb"+ex);
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido acceder a la base de datos.");
                        alert.showAndWait();
        }
        return con;
    }
    
    
}
