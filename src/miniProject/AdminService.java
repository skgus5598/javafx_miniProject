package miniProject;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminService extends ActionEvent {

	
	Parent root;
	TextField resultId;
	TextField resultPw;
	String textId;
	String textPw;
	String keyId;
	String keyPw;
	int a;
	
	public void setSRoot(Parent root) {
		this.root = root;
	}
	
	public void loginAdmin(String textId, String textPw) {
		
		System.out.println("입력한 관리자 아이디 : " + textId);
		System.out.println("입력한 비밀번호 : " + textPw);
	}
	
	public void keyboardId() {
		a = 1;
	}
	
	public void keyboardPw() {
		a = 2;
	}
	
	
	
/*	public void keyboard() {
		ActionEvent event = null;
		if(a == 1) {
			keyId = ((Button)event.getSource()).getText();
			resultId = ((TextField) root.lookup("#resultId"));
			textId = resultId.getText() + keyId;
			resultId.setText(textId);
		} else {
			keyPw = ((Button)event.getSource()).getText();
			resultPw = ((TextField)root.lookup("#resultPw"));
			textPw = resultPw.getText() + keyPw;
			resultPw.setText(textPw);
		}
	}
*/
	
	public void deleteLetter(String textId , String textPw ) {
		this.textId = textId;
		this.textPw = textPw;	
	}	
	
	
	public void powerOff() {
		System.out.println("power off ");
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}

	
	
}
