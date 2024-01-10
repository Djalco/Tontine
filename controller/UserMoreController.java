package controller;

import java.sql.SQLException;

import controller.generic.MoreControllerAbstract;
import dao.DaoFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.User;

public class UserMoreController extends MoreControllerAbstract<User>{

	@FXML
	private Button backBtn;

	@FXML
	private Button returnBtn;

	@Override
	protected void setDetail() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setContribution() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setLoan() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setInfraction() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setOverview() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setDao() throws SQLException {
		dao = DaoFactory.getUserDao();		
	}

	//	@Override
	//	public Button getBackBtn() {
	//		return backBtn;
	//	}
	//
	//	@Override
	//	public Button getReturnBtn() {
	//		return returnBtn;
	//	}

}
