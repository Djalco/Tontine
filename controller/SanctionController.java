package controller;

import java.sql.SQLException;

import controller.generic.EntityControllerAbstract;
import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Loan;

public class SanctionController extends EntityControllerAbstract<Loan>{

    @FXML
    private Text amountInfraction;

    @FXML
    private Text amountInterest;

    @FXML
    private Text amountLoan;

    @FXML
    private Text member;

    @FXML
    private Button moreBtn;

    @FXML
    private Text sessionLoan;

    @FXML
    private Text sessionRemboursed;

    @FXML
    private Text status;

	@Override
	protected void setField() throws Exception {
		if (entity == null)
			throw new EntityNotFoundException( "L'Entité nulle");
		member.setText(entity.getUser().toString());
		sessionLoan.setText(entity.getSession().toString());
		sessionRemboursed.setText(entity.getSessionSold().toString());
		amountLoan.setText(entity.getAmount()+"");
		amountInterest.setText(entity.getInterest()+"");
		member.setText(entity.getUser().toString());
		member.setText(entity.getUser().toString());
	}

	@Override
	protected void clearField() throws Exception {}

	@Override
	protected void disableField(boolean disable) {}

	@Override
	protected void buildEntity() throws Exception {}

	@Override
	protected void setDao() throws SQLException {
		dao = DaoFactory.getLoanDao();
	}

	@Override
	protected void initComponent() throws Exception {
		
	}

}
