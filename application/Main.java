package application;

import java.sql.SQLException;

import dao.DaoFactory;
import dao.SessionDao;
import dao.SettingDao;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Loan;
import model.Sanction;
import model.enumration.PaymentType;
import sql.DatabaseInitializer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			DatabaseInitializer.destroy();
			DatabaseInitializer.init();

			initClass();
			if(! SettingDao.settingIsExist()) {
				Parent root = FXMLLoader.load(getClass().getResource("/view/initTontine.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			}else {
				DaoFactory.getSessionDao().init();
			Parent root = FXMLLoader.load(getClass().getResource("/view/principal.fxml"));
			Scene scene = new Scene(root,1200,800);
			primaryStage.setScene(scene);
			primaryStage.show();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void initClass() throws SQLException {
		Sanction.intiSanctions();
		Loan.setSetting(PaymentType.getPayment(SettingDao.getTypePamentLoan()),
				SettingDao.getAmountPamentLoan());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
