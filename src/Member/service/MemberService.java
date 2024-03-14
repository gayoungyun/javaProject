package Member.service;

import Member.dto.MemberDTO;
import javafx.scene.Parent;

public interface MemberService {
	public void registerFunc(String id, String name, String birth, String number, String pwd, boolean gender);
	public void cancelFunc();
	public void setRoot(Parent root);
	public boolean isMemberRegistered(String phoneNumber);
	public void checkFunc(Parent root, boolean result, String password);
	
	public void canclemFunc();
	public boolean passwordchk(String password);
	public void modifyFunc(Parent root, String password);
}
