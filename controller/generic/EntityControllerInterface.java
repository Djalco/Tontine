package controller.generic;

import controller.PrincipalController;
import controller.enumeration.State;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public interface EntityControllerInterface <T>{

	Button getBackBtn();

	Button getMainBtn();

	Button getCancelBtn();

	Button getMoreBtn();

	void setState(State state) throws Exception;

	void closeUpdate();

	void setPage(VBox page);

	void setController(PrincipalController principal, ManageControllerAbstract<T> manageController);

	void removeError();


}
