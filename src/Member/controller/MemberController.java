package Member.controller;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import Member.service.MemberService;
import Member.service.MemberServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberController implements Initializable{
	@FXML public TextField fxId, fxName, fxBirth, fxNumber;
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
		
		ms.registerFunc();
	}
	public void cancelFunc() {
		ms.cancelFunc();
	}
		
	}


