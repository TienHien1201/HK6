package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javafx.fxml.FXML;

public class SampleController 

{
	@FXML
	private TextField txtUser,txtPassword;
	
	@FXML
	private Label lblInfo;
	
	
	public void Dangnhap(String username, String password)
	{
		try {
			Connection conn=DataConnection.getConnection();
			
			String query = "SELECT id, username FROM	tbl_Users "
					+ "where username='"+username+"' and password='"+password+"'";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) 
			{
				lblInfo.setText(rs.getString("username")+ " đã đăng nhập");
			}
			else
			{
				lblInfo.setText("Đăng nhập không thành công");
			}
			
			
		}
		
		catch(Exception ex)
		{
			lblInfo.setText("Lỗi đăng nhập:"+ex.getMessage());
			txtUser.setText("Lỗi đăng nhập:"+ex.getMessage());
		}
		
		
	}
	
	@FXML
	public void dangnhap_clicked()
	{
		
		Dangnhap(txtUser.getText(), txtPassword.getText());
		
		//lblInfo.setText("Đăng nhập thành công!");
		//txtUser.setText("Đang nhập thành công");
		
	}
	
	
}
