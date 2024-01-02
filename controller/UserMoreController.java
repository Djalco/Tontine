package controller;

import controller.generic.MoreControllerAbstract;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserMoreController extends MoreControllerAbstract{

    @FXML
    private Button backBtn;
    
    @FXML
    private Button returnBtn;

	@Override
	public Button getBackBtn() {
		return backBtn;
	}

	@Override
	public Button getReturnBtn() {
		return returnBtn;
	}

}
