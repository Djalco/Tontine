package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.User;
import sql.BdConnexion;

public class ConnexionController {

    @FXML
    private PasswordField passwordFieldPassword;

    @FXML
    private TextField textFielPassword;

    @FXML
    private TextField textFieldIdentifiant;

    @FXML
    private ImageView imgButton;
    
    @FXML
    void change(ActionEvent event) {
    	textFielPassword.setVisible(!textFielPassword.isVisible());
    	passwordFieldPassword.setVisible(!passwordFieldPassword.isVisible());
    	if(passwordFieldPassword.isVisible()) {
//    		imgButton.setImage(new Image(getClass().getResource("/img/show.png")).toString());
    	}else {
//    		imgButton.setImage(new Image("D:\\Users\\booml\\eclipse-workspace\\myProject\\ChristyBlockFactory\\src\\img\\hide_48px.png"));
    	}
    }

    @FXML
    void connexion(ActionEvent event) throws SQLException, IOException, EntityNotFoundException {
    	Connection conn = BdConnexion.getInstance();
    	String sql = "Select * FROM `user` WHERE (login = ? or mail=?) and password = ?";
    	PreparedStatement pst = conn.prepareStatement(sql);
    	pst.setString(1, textFieldIdentifiant.getText());
    	pst.setString(2, textFieldIdentifiant.getText());
    	pst.setString(3, textFielPassword.getText());
    	ResultSet rs = pst.executeQuery();

		Alert alert;
    	if(rs.next()) {
    		User.setUserConnected(DaoFactory.getUserDao().findLogin(textFieldIdentifiant.getText()));
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("Vous etes autorisé a vous connecter");
    		alert.showAndWait();
    		Parent root = FXMLLoader.load(getClass().getResource("/view/principal.fxml"));
    		((Stage)textFieldIdentifiant.getScene().getWindow()).close();
			Scene scene = new Scene(root,1280,720);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
    	}else {
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("Mot de passe ou nom d'utilisateur incorrect");
    		alert.showAndWait();
    	}
    }

    @FXML
    void passLaunch(KeyEvent event) {
    	textFielPassword.setText(passwordFieldPassword.getText());
    }

    @FXML
    void textFielPassword(ActionEvent event) {
    	
    }

    @FXML
    void textLaunch(KeyEvent event) {
    	passwordFieldPassword.setText(textFielPassword.getText());
    }

}
