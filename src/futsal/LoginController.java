/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futsal;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Andien
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField user;
    @FXML
    private Button btnlogin;
    @FXML
    private JFXPasswordField pass;
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    /**
     * Initializes the controller class.
     */
     @FXML
    void login(ActionEvent event) throws SQLException {
        
        try {
            
            sql = "SELECT * FROM admin WHERE username='"+user.getText()+"' AND password='"+pass.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(user.getText().equals(rs.getString("username")) && pass.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "anda berhasil login");
                }
                
                
                // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
                
            }else{
                    JOptionPane.showMessageDialog(null, "Isikan Username dan Password anda dengan benar");
                    user.setText("");
                    user.requestFocus();
                    pass.setText("");
                }
            
            
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }    
    
}
