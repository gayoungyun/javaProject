package Member.service;

import java.util.Scanner;

import Member.dao.MemberDAO;
import Member.dto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberServiceImpl implements MemberService{
	TextField fxId, fxName, fxBirth, fxNumber, fxAddr;
	PasswordField fxPwd;
	RadioButton rdoWoman;

	private MemberDAO dao;
	
	Parent root;

	public MemberServiceImpl() {
		dao = new MemberDAO();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void registerFunc(String id, String name, String birth, String number, String pwd, boolean gender) {

		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		fxBirth = (TextField)root.lookup("#fxBirth");
		fxNumber = (TextField)root.lookup("#fxNumber");
		fxAddr = (TextField)root.lookup("#fxAddr");

		fxPwd = (PasswordField)root.lookup("#fxPwd");

		rdoWoman = (RadioButton)root.lookup("#rdoWoman");

		System.out.println("id : "+fxId.getText());
		System.out.println("name : "+fxName.getText());
		System.out.println("birth : "+fxBirth.getText());
		System.out.println("number : "+fxNumber.getText());
		System.out.println("addr : "+fxAddr.getText());

		System.out.println("pwd : "+fxPwd.getText());
		System.out.println("gender : "+rdoWoman.isSelected());

		MemberDTO dto = new MemberDTO();
		dto.setId(fxId.getText());
		dto.setName(fxName.getText());
		dto.setBirth(fxBirth.getText());
		dto.setTel(fxNumber.getText());
		dto.setAdd(fxAddr.getText());
		dto.setPwd(fxPwd.getText());
		dto.setGender(rdoWoman.isSelected()? 1:0);

		dao.insert(dto);
	}
	@Override
	public void cancelFunc() {
		Stage stage =(Stage)root.getScene().getWindow();
		stage.close();
	}

	
		
	}



