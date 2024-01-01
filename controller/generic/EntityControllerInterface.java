package controller.generic;

import javafx.scene.control.Button;

public interface EntityControllerInterface {

	public Button getBackBtn();
	
	public Button getMainButton();
	
	public Button getCancelButton();
	
	public Button getMoreBtn();
	
	public boolean verifyTextfield();
	
	public boolean verifyPassword();
}
