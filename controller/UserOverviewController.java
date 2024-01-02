package controller;

import controller.generic.OverviewControllerAbstract;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserOverviewController extends OverviewControllerAbstract{

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
