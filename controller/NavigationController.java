package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class NavigationController {

    @FXML
    private Text entity;

    @FXML
    private Text manageType;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void showProfile(ActionEvent event) {

    }

    @FXML
    void showSetting(ActionEvent event) {

    }
    
    public void setEntity(String text) {
    	entity.setText(text);
    }
    
    public void setManageType(String text) {
    	manageType.setText(text);
    }

}
