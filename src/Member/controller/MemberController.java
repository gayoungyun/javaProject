package Member.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Member.service.MemberService;
import Member.service.MemberServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberController implements Initializable{
	@FXML public TextField fxId, fxName, fxBirth, fxNumber, fxAddr;
	@FXML public RadioButton rdoWoman;
	@FXML public PasswordField fxPwd;

	Parent root;
	MemberService ms;
	public void setRoot(Parent root) {
		ms.setRoot(root);
		this.root = root;
	}
	public MemberController() {
		System.out.println("");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberServiceImpl();
	}
	public void registerFunc() 
	{
		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		fxBirth = (TextField)root.lookup("#fxBirth");
		fxNumber = (TextField)root.lookup("#fxNumber");
		fxPwd = (PasswordField)root.lookup("#fxPwd");
		rdoWoman = (RadioButton)root.lookup("#rdoWoman");

		String phone = fxNumber.getText();

		if(!phone.equals(phone)) {
			String msg = fxNumber.getText();
			fxNumber.setText(msg);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("중복");
			alert.setContentText("이미 가입하셨습니다");
			alert.show();
		}
		ms.registerFunc(fxId.getText(), fxName.getText(), fxBirth.getText(), fxNumber.getText(), fxPwd.getText(), rdoWoman.isSelected());
	}
	public void cancelFunc() {
		System.out.println("root : "+root);
		ms.cancelFunc();
	}

}


