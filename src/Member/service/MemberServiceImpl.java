package Member.service;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;

import Member.dao.MemberDAO;
import Member.dto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberServiceImpl implements MemberService{
	TextField fxId, fxName, fxBirth, fxNumber;
	PasswordField fxPwd;
	RadioButton rdoWoman;

	MemberDAO dao;
	Parent root;
	


	public MemberServiceImpl() {
		dao = new MemberDAO();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void registerFunc() {

		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		fxBirth = (TextField)root.lookup("#fxBirth");
		fxNumber = (TextField)root.lookup("#fxNumber");

		fxPwd = (PasswordField)root.lookup("#fxPwd");

		rdoWoman = (RadioButton)root.lookup("#rdoWoman");

		System.out.println("id : "+fxId.getText());
		System.out.println("name : "+fxName.getText());
		System.out.println("birth : "+fxBirth.getText());
		System.out.println("number : "+fxNumber.getText());

		System.out.println("pwd : "+fxPwd.getText());
		System.out.println("woman : "+rdoWoman.isSelected());

		MemberDTO dto = new MemberDTO();
		dto.setId(fxId.getText());
		dto.setName(fxName.getText());
		dto.setBir(fxBirth.getText());
		dto.setNum(fxNumber.getText());
		dto.setPwd(fxPwd.getText());
		dto.setGender(rdoWoman.isSelected()? 1:0);


	}
	@Override
	public void cancelFunc() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();

	}
	//public static void main(String[] args) {
		
	}



