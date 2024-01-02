package controller.generic;

import javafx.scene.control.Button;

public interface EntityControllerInterface {

	public Button getBackBtn();
	
	public Button getMainBtn();
	
	public Button getCancelBtn();
	
	public Button getMoreBtn();
	
	public boolean verifyTextfield();
	
	public boolean verifySpinner();
	
	public boolean verifyComboBox();
}
