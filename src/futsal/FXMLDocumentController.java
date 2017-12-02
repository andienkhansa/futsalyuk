/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futsal;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Andien
 */
public class FXMLDocumentController implements Initializable {
    
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";

    
    @FXML
    private TextField nama;
    @FXML
    private TextField hp;
    @FXML
    private TextField kode;
    @FXML
    private DatePicker tgl;
    @FXML
    private TextField mulai;
    @FXML
    private TextField sampai;
    @FXML
    private Button logout;
    private JFXTextArea output;
    
    @FXML
    private Button reset;
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    
    @FXML
    private Button detail;
    @FXML
    private TableColumn<?, ?> IdFutsal;
    @FXML
    private TableColumn<?, ?> hpFutsal;
    @FXML
    private TableColumn<?, ?> kodeFutsal;
    @FXML
    private TableColumn<?, ?> mulaiFutsal;
    @FXML
    private TableColumn<?, ?> selesaiFutsal;
    @FXML
    private TableColumn<?, ?> tglFutsal;
    @FXML
    private TableColumn<?, ?> namaFutsal;
    @FXML
    private TableView<Data.ViewData> TabelY;

    private ObservableList<Data.ViewData> isi = FXCollections.observableArrayList();
    
    
    @FXML
    void detail(ActionEvent event) {
        com.mysql.jdbc.Connection con=null;
        Statement stat = null;
        setKolomTable();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/futsal", "root", "");
            
            stat=(Statement) con.createStatement();
            
            String sql ="SELECT * FROM futsal";
            ResultSet rs=stat.executeQuery(sql);
            
            while(rs.next()){
                isi.add(new Data.ViewData(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7)));     
            }
         stat.close();
         con.close();
        }catch(SQLException ex){
            System.out.print(ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
        }
        TabelY.setItems(isi);
    }
    
    private void setKolomTable(){
        IdFutsal.setCellValueFactory(new PropertyValueFactory<>("IdFutsal"));
        hpFutsal.setCellValueFactory(new PropertyValueFactory<>("hpFutsal"));
        kodeFutsal.setCellValueFactory(new PropertyValueFactory<>("kodeFutsal"));
        mulaiFutsal.setCellValueFactory(new PropertyValueFactory<>("mulaiFutsal"));
        selesaiFutsal.setCellValueFactory(new PropertyValueFactory<>("selesaiFutsal"));
        tglFutsal.setCellValueFactory(new PropertyValueFactory<>("tglFutsal"));
        namaFutsal.setCellValueFactory(new PropertyValueFactory<>("namaFutsal"));
    }
    @FXML
    private Button pesan;
    String namapel,hape,kod;
    
   
    
    @FXML
    void pesan(ActionEvent event) {
        namapel = nama.getText();
        hape = hp.getText();
        kod = kode.getText();
        
        String date = tgl.getValue().toString();
         if((nama.getText() == null || nama.getText().length() == 0)){
            new Alert(AlertType.ERROR, "Isikan Data Anda").showAndWait();
            }
        else{
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/futsal", "root", "");
            
            stat=(Statement) con.createStatement();
            
            //sql = "INSERT INTO futsal VALUES ('"+nama.getText()+"','"+hp.getText()+"','"+kode.getText()+"','"+date+"','"+mulai.getText()+"','"+sampai.getText()+"')";
            String sql = "INSERT INTO `futsal`(`id_futsal`, `nama_penyewa`, `no_hp`, `kode_booking`, "
                    + "`awal`, `akhir`, `tanggal`) VALUES (NULL,'"+nama.getText()+"','"+hp.getText()+"',"
                    + "'"+kode.getText()+"','"+mulai.getText()+"','"+sampai.getText()+"','"+date+"')";
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            stat.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }
    
        @FXML
    void reset(ActionEvent event) {
        nama.setText(" ");
        hp.setText(" ");
        kode.setText(" ");
        mulai.setText(" ");
        sampai.setText(" ");
    }
    
        @FXML
    void logout(ActionEvent event) {
        try{
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
     
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
    }
        catch(IOException e){
            System.out.println("Failed to create new window" + e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
