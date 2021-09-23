package miniProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminLoginPage.fxml"));
		Parent root = loader.load();	//여기서 컨트롤러의 initialize가 실행됨 
		Scene scene = new Scene(root);
	
		AdminController ctl = loader.getController();
		ctl.setRoot(root);
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
