package Member.service;

import Member.dto.MemberDTO;
import javafx.scene.Parent;

public interface MemberService {
	public void registerFunc(String id, String name, String birth, String number, String pwd, boolean gender);
	public void cancelFunc();
	public void setRoot(Parent root);
	public boolean isMemberRegistered(String phoneNumber);
	public void modifyFunc();
	public void deleteFunc();
	//public void memberView();
	//public boolean isMemberCheck(String pwd);
	public void checkFunc(Parent root, boolean result, String password);
	
	public void modifymFunc();
	public void cancelmFunc();
	public void checkdFunc();
	//public MemberDTO getMemberInfoByPassword(String password);
	public boolean passwordchk(String password);
	public void modifyFunc(String id, String pwd, String name, String number, String  addr);
	public void modifyFunc(Parent root);
	void deleteFunc(Parent root, boolean result, String password);
}
