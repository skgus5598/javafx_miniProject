package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdminDB {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public void checkId(String textId) {
		// select id from naver where id = ?;
		String sql = "select * from naver where id = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "raina", "5598");
			System.out.println("연결되었습니다 : " + conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1, textId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String admin = rs.getString("id");
				String pwd = rs.getString("pwd");
				AdminService as = new AdminService();
				as.loginDBCheck(admin, pwd);
			} else {				
				Alert alert  = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("존재하지 않는 ADMIN입니다.");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
