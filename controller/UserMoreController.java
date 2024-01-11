package controller;

import java.sql.SQLException;

import controller.generic.MoreControllerAbstract;
import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.User;

public class UserMoreController extends MoreControllerAbstract<User>{

	@FXML
	private Text NbrenbLoan;

	@FXML
	private Text amountInfraction;

	@FXML
	private Text amountInfractionLoan;

	@FXML
	private Text amountInterest;

	@FXML
	private Text amountLoan;

	@FXML
	private Text amountRemainnig;

	@FXML
	private Text amountSold;

	@FXML
	private Button backBtn;

	@FXML
	private Text gainPos;

	@FXML
	private Text nbInfractions;

	@FXML
	private Text nbInfractionLoan;

	@FXML
	private Text nbSeance;

	@FXML
	private Text nbSeanceContributed;

	@FXML
	private Text nbValidLoan;

	@FXML
	private VBox overview;
	
	
	@Override
	protected void setDetail() throws SQLException, EntityNotFoundException {
		NbrenbLoan.setText(obj.getLoan().size()+"");
		amountInfraction.setText(obj.getAmountInfraction()+"");
		amountInfractionLoan.setText(obj.getAmountInfractionLoan()+"");
		amountInterest.setText(obj.getAmountInterest()+"");
		amountLoan.setText(obj.getAmountLoan()+"");
		amountRemainnig.setText(obj.getAmountRemaining()+"");;
		amountSold.setText(obj.getAmount()+"");
		gainPos.setText(obj.getPos()+"");
		nbInfractions.setText(obj.getInfraction().size()+"");
		nbInfractionLoan.setText(obj.getNbInfractionLoan()+"");
		nbSeance.setText(obj.getNbSession()+"");
		nbSeanceContributed.setText(obj.getNbSessionContribute()+"");
		nbValidLoan.setText(obj.getValidLoan()+"");

	}

	@Override
	protected void setContribution() {

	}

	@Override
	protected void setLoan() {

	}

	@Override
	protected void setInfraction() {

	}

	@Override
	protected void setOverview() {

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
