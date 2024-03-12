package Member.service;

import Member.dto.MemberDTO;
import javafx.scene.Parent;

public interface MemberService {
	//public void memberInsert();
	public void registerFunc(String id, String name, String birth, String number, String pwd, boolean gender);
	public void cancelFunc();
	public void setRoot(Parent root);
	//public int insert(MemberDTO dto);
}
