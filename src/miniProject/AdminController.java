package miniProject;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminController implements Initializable {

	Parent root;
	AdminService as = new AdminService();

	public void setRoot(Parent root) {
		this.root = root;
		as.setSRoot(root);
	}

	public void loginAdmin() {   // LOGIN BUTTON click
		as.loginAdmin();
	}

	public void keyboardId() {  // keyboard ADMIN textfield
		as.keyboardId();
	}

	public void keyboardPw() {  // keyboard PASSWORD textfield 
		as.keyboardPw();
	}
 
	public void keyboardNum() {   //  keyboard 123 button
		as.keyboardNum();
}

	public void keyboardCap() {   //  keyboard Caps button
		as.keyboardCap();
	}

	public void keyboard(ActionEvent event) {    // keyboard entire button
		as.keyboard(event);
	}

	public void deleteLetter() {    // keyboard del button
		as.deleteLetter();		
	}

	public void setPowerOff() {    // shutdown logo 
		as.powerOff();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
