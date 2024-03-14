package Member.service;

import java.util.ArrayList;
import java.util.Scanner;

import Class.Class01;
import Class.Class02;
import Member.dao.MemberDAO;
import Member.dto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberServiceImpl implements MemberService{
	TextField fxId, fxName, fxBirth, fxNumber, fxAddr, fxIdm, fxNamem, fxBirthm, fxNumberm, fxAddrm;;
	PasswordField fxPwd, fxPwdm, fxPwddelete, fxPwdcheck;
	RadioButton rdoWoman;
	TableColumn fxViewid, fxViewname, fxViewbirth,fxViewtel, fxViewaddress;

	private MemberDAO dao;
	private MemberDTO dto;

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
	public void modifyFunc(Parent root , String password ) {
		
		System.out.println("modifyfund실행");
		Class02 cs02= new Class02();
		System.out.println("class호출");
		
		cs02.modifyFx(root, password);
	}
	
	public void checkFunc(Parent root, boolean result, String password) {
		ArrayList<MemberDTO> member = dao.getMembers();
		Class01 cs01= new Class01();
		if(member.size()== 1 || member != null) {
			fxPwdcheck = (PasswordField)root.lookup("#fxPwdcheck");
			System.out.println("pwd : "+fxPwdcheck.getText());

			MemberDTO dto = new MemberDTO();
			dto.setPwd(fxPwdcheck.getText());
		}
		dao.getMembers();
		if(result == true)
			cs01.viewFx(root, password);
		else
			System.out.println("비밀번호가 다릅니다");
	}
	
	@Override
	public boolean isMemberRegistered(String phoneNumber) 
	{
		boolean result = dao.phoneNumberchk(phoneNumber);

		return result;

	}

	public boolean isMemberCheck(String pwd)
	{
		boolean result = dao.passwordchk(pwd);
		return result;
	}

	public boolean passwordchk(String pwd) 
	{
		return dao.passwordchk(pwd);

	}

	@Override
	public void cancelFunc() {
		Stage stage =(Stage)root.getScene().getWindow();
		stage.close();
	}
	@Override
	public void canclemFunc() {
		Stage stage =(Stage)root.getScene().getWindow();
		stage.close();
	}
	
}



