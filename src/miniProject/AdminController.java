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

	TextField resultId;
	TextField resultPw;
	String textId;
	String textPw;
	String keyId;
	String keyPw;
	int a;
	int capBtn = 0;
	int i = 1;
	int clickNum = 0;

	public void setRoot(Parent root) {
		this.root = root;
		as.setSRoot(root);
	}

	public void loginAdmin() {
		as.loginAdmin(textId, textPw);
	}

//	@FXML
	public void keyboardId() {
		as.keyboardId();
		System.out.println("스크린 아이디 터치 ");
		a = 1;
	}

//	@FXML
	public void keyboardPw() {
		as.keyboardPw();
		System.out.println("스크린 비밀번호 터치 ");
		a = 2;
	}
 
	// 키보드 맨 윗칸 숫자로 변경 
	public void keyboardNum() { // id 1~10
		clickNum++;

		for (i = 1; i <= 10; i++) {
			if (clickNum == 1 || clickNum % 2 != 0) {
				Button cap = (Button) root.lookup("#fxId" + i);
				if (i == 10) {
					cap.setText(0 + "");
				} else {
					cap.setText(i + "");
				}
			} else {
				String [] list = {"","q","w","e","r","t","y","u","i","o","p"};				
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(list[i]);
			}
		}
		System.out.println(clickNum);
	}

	public void keyboardCap(ActionEvent event) {
		capBtn++;
		// caps버튼 누르면 눌린 상태로 있었으면 좋겠음
		// 대문자로 변경, 소문자로 변경 --얘가 급~~ 어쨌든 성
		if (capBtn == 1 || capBtn % 2 != 0) {
			for (i = 1; i <= 27; i++) {
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(cap.getText().toUpperCase());
			}
		} else {
			for (i = 1; i <= 27; i++) {
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(cap.getText().toLowerCase());
			}
		}
	}

//	@FXML
	public void keyboard(ActionEvent event) {
//		keyboard(event);
		if (a == 1) { // 아이디 칸 vs 비밀번호 칸
			// 대문자 vs 소문자
			keyId = ((Button) event.getSource()).getText();
			resultId = ((TextField) root.lookup("#resultId"));
			textId = resultId.getText() + keyId;
			resultId.setText(textId);
			System.out.println(textId);
		} else {
			keyPw = ((Button) event.getSource()).getText();
			resultPw = ((TextField) root.lookup("#resultPw"));
			textPw = resultPw.getText() + keyPw;
			resultPw.setText(textPw);
			System.out.println(textPw);
		}
	}

	public void deleteLetter() {
		if (a == 1) {
			int i = resultId.getLength(); // resultId의 총 길이를 구한 뒤
			System.out.println(resultId.getLength());
			if(i <=0) {
				Alert alert  = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("ADMIN을 입력하세요");
				alert.show();
				} else {
					resultId.deleteText((i - 1), i); // i-1 이상 i 미만 만큼 텍스트를 제거해준다
					textId = resultId.getText();
			}	
		} else {
			int j = resultPw.getLength();
			System.out.println(resultPw.getLength());
			if(j<=0) {
				Alert alert  = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("PASSWORD를 입력하세요");
				alert.show();
				}else {
					resultPw.deleteText((j - 1), j);
					textPw = resultPw.getText();
				}			
		}
		as.deleteLetter(textId, textPw);
	}

	public void setPowerOff() {
		as.powerOff();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
