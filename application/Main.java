package application;
	

import dao.CotisationDao;
import dao.LoanDao;
import dao.SessionDao;
import exception.EntityNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.stage.Stage;
import sql.DatabaseInitializer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import model.Cotisation;
import model.Loan;
import model.Session;
import model.User;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
//		try {
//			DatabaseInitializer.destroy();
//			DatabaseInitializer.init();
//			Parent root = FXMLLoader.load(getClass().getResource("/view/principal.fxml"));
//			Scene scene = new Scene(root,1200,800);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args) throws SQLException, EntityNotFoundException, ClassNotFoundException, IOException {
//		launch(args);
                        DatabaseInitializer.destroy();
			DatabaseInitializer.init();
           SessionDao s1 = new SessionDao();
           s1.create(new Session("sy", 0, LocalDate.now()));
           s1.create(new Session("sr", 1, LocalDate.now()));
           s1.create(new Session("ss", 2, LocalDate.now()));
           s1.create(new Session("sv", 3, LocalDate.now()));
           s1.create(new Session("su", 5, LocalDate.now()));
             CotisationDao c1 = new CotisationDao();
             c1.create(new Cotisation("dt","usr-024-43","sess-024-001"));
             c1.create(new Cotisation("dt","usr-024-44","sess-024-003"));
             c1.create(new Cotisation("dt","usr-024-42","sess-024-005"));
             c1.create(new Cotisation("dt","usr-024-40","sess-024-002"));
             c1.create(new Cotisation("dt","usr-024-45","sess-024-004"));
           
             c1.find("cot-024-002");
             c1.find("cot-024-005");
            
             LoanDao l = new LoanDao();
             l.create(new Loan("lt", "cot-024-002", 1000,"sess-024-004"));
             

	}
}
