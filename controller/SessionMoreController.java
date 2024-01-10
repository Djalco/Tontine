package controller;

import java.sql.SQLException;

import controller.generic.MoreControllerAbstract;
import dao.DaoFactory;
import dao.SessionDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import model.Session;

public class SessionMoreController extends MoreControllerAbstract<Session>{

	
    @FXML
    private Button backBtn;

    @FXML
    private TableView<?> contribution;

    @FXML
    private Text infractionContribution;

    @FXML
    private Text infractionLoan;

    @FXML
    private Text nbPersonContribute;

    @FXML
    private Text nbPersonContributeRemaining;

    @FXML
    private Text nbPersonLRemainig;

    @FXML
    private Text nbPersonLoan;

    @FXML
    private Text nbPersonLoanRemboursed;

    @FXML
    private Text statusContribute;

    @FXML
    private Text statutLoan;

    @FXML
    private TableColumn<?, ?> tableContributeMember;

    @FXML
    private TableColumn<?, ?> tableContributeStatus;

    @FXML
    private TableColumn<?, ?> tableContributesNbName;

    @FXML
    private TableColumn<?, ?> tableInfractionAmount;

    @FXML
    private TableColumn<?, ?> tableInfractionStatus;

    @FXML
    private TableColumn<?, ?> tableInfractionType;

    @FXML
    private TableColumn<?, ?> tableLoanAmount;

    @FXML
    private TableColumn<?, ?> tableLoanMember;

    @FXML
    private TableColumn<?, ?> tableLoanRemaining;

    @FXML
    private TableColumn<?, ?> tableLoanStatus;

    @FXML
    private TableColumn<?, ?> tablenfractionMember;

	@Override
	protected void setDetail() throws SQLException {
		int not = obj.getNotCotisation();
		System.out.println(not);
		nbPersonContribute.setText(obj.getCotisation()+"");
		nbPersonContributeRemaining.setText(not+"");
		if(not<1) {
			statusContribute.getStyleClass().remove("title-detail-number-not-valid");
			statusContribute.getStyleClass().add("title-detail-number-valid");
			statusContribute.setText("Valide");
		}else {
			statusContribute.getStyleClass().add("title-detail-number-not-valid");
			statusContribute.getStyleClass().remove("title-detail-number-valid");
			statusContribute.setText("Invalide");
		}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setDao() throws SQLException {
		dao = DaoFactory.getSessionDao();
		
	}


}
