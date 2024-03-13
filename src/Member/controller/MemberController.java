package Member.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Member.dao.MemberDAO;
import Member.dto.MemberDTO;
import Member.service.MemberService;
import Member.service.MemberServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MemberController implements Initializable{
	@FXML public TextField fxId, fxName, fxBirth, fxNumber, fxAddr, fxIdm, fxNamem, fxBirthm, fxNumberm, fxAddrm;
	@FXML public RadioButton rdoWoman;
	@FXML public PasswordField fxPwd, fxPwdm, fxPwddelete, fxPwdcheck;

	@FXML public TableView<MemberDTO> fxView;
	@FXML public TableColumn<MemberDTO,String> fxViewid, fxViewname, fxViewbirth,fxViewtel, fxViewaddress;

	ObservableList<MemberDTO> myList = FXCollections.observableArrayList();

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

		String phoneNumber = fxNumber.getText();

		if(ms.isMemberRegistered(phoneNumber)) {
			String msg = fxNumber.getText();
			fxNumber.setText(msg);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("중복");
			alert.setContentText("이미 가입하셨습니다");
			alert.show();

		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("");
			alert.setContentText("가입 성공했습니다");
			alert.show();

		}
		ms.registerFunc(fxId.getText(), fxName.getText(), fxBirth.getText(), fxNumber.getText(), fxPwd.getText(), rdoWoman.isSelected());
	}

	public void checkFunc() {
		fxPwdcheck = (PasswordField)root.lookup("#fxPwdcheck");
		String password = fxPwdcheck.getText();
		//.isEmpty()

		boolean result = false;
		if (ms.passwordchk(password)) {
			//			MemberDTO member = ms.getMemberInfoByPassword(password);
			//			if(member != null) {
			//				//id name birth tel address
			//				fxViewid.setText(member.getId());
			//				fxViewname.setText(member.getName());
			//				fxViewbirth.setText(member.getBirth());
			//				fxViewtel.setText(member.getTel());
			//				fxViewaddress.setText(member.getAdd());
			//				
			//			}
			result = true;
		}

		ms.checkFunc(root, result, password);
	}
	public void modifyFunc() {
		
		fxIdm = (TextField)root.lookup("#fxIdm");
		fxPwdm = (PasswordField)root.lookup("#fxPwdm");
		fxNamem = (TextField)root.lookup("#fxNamem");
		fxNumberm = (TextField)root.lookup("#fxNumberm");
		fxAddr = (TextField)root.lookup("#fxAddrm");
		
		/*
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("중복");
		alert.setContentText("이미 가입하셨습니다");
		alert.show();
	*/
		ms.modifyFunc(root);
	}

	public void modifymFunc() {

	}
	public void canclemFunc() {

	}
	public void checkdFunc() {
		
	}
	/*
	public void getPasswordMameber(String password)
	{
		if (ms.passwordchk(password)) {
			MemberDTO member = ms.getMemberInfoByPassword(password);
			if(member != null) {
				//id name birth tel address
//				fxViewid.setText(member.getId());
//				fxViewname.setText(member.getName());
//				fxViewbirth.setText(member.getBirth());
//				fxViewtel.setText(member.getTel());
//				fxViewaddress.setText(member.getAdd());

			}
		}
	}
	 */
	public void find(String password)
	{
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();


		dto = dao.findMember(password);

		System.out.println(dto.getBirth());

		setTable(dto);
	}

	public void setTable(MemberDTO dto)
	{

		myList.add(new MemberDTO(dto.getId(), dto.getName(), dto.getBirth(), dto.getTel(), dto.getAdd()));
		// fxViewid, fxViewname, fxViewbirth,fxViewtel, fxViewaddress;

		fxViewid.setCellValueFactory(new PropertyValueFactory<>("id"));
		fxViewname.setCellValueFactory(new PropertyValueFactory<>("name"));
		fxViewbirth.setCellValueFactory(new PropertyValueFactory<>("birth"));
		fxViewtel.setCellValueFactory(new PropertyValueFactory<>("tel"));
		fxViewaddress.setCellValueFactory(new PropertyValueFactory<>("add"));

		fxView.setItems(myList);
	}

	public void deleteFunc() {
		ms.deleteFunc();

	}
	public void cancelFunc() {
		System.out.println("root : "+root);
		ms.cancelFunc();
	}
	public void cancelmFunc() {
		System.out.println("root : "+root);
		ms.cancelFunc();
	}
	public void canceldFunc() {
		System.out.println("root : "+root);
		ms.cancelFunc();
	}

}


