/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sql.BdConnexion;

/**
 *
 * @author Alexiapc
 */
public class ConnexionController {
    @FXML
    private JFXButton connect;

    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField pass;

    @FXML
    void connection(ActionEvent event) throws SQLException {
           
        BdConnexion con= new BdConnexion();

            Connection conn=con.getInstance();

		PreparedStatement stat=null;
		ResultSet rs=null;
		String sql="SELECT * FROM user WHERE login= ? AND password= ? ";

    	try {
    	stat=conn.prepareStatement(sql);
    	stat.setString(1, login.getText().toString());
    	stat.setString(2, pass.getText().toString());
    	rs=stat.executeQuery();
    	if(rs.next()) {
    	
    	//conex.getScene().getWindow().hide();
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/principal.fxml"));
    	Parent main=loader.load();
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    	 
    	}else {
    	Alert alert= new Alert(AlertType.ERROR);
    	alert.setTitle("Alert");
    	alert.setHeaderText("Erreur");
    	alert.setContentText("mot de pass ou login incorrect");
    	alert.showAndWait();
    	}
    	}catch (Exception e) {
    	// TODO: handle exception
    	}
    }
    
    
    public void initialize(URL location, ResourceBundle resources) {
    }
}
