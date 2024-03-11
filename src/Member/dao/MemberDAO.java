package Member.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import Member.dto.MemberDTO;
import javafx.scene.shape.Path;

public class MemberDAO {
	private String path ="D:\\핀테크\\윤가영\\eclipse.java\\members/";
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;

	public void register(MemberDTO dto) {
		File p= new File(path +dto.getId()+".txt");
		if(p.exists()) {
			System.out.println("존재하는 회원입니다!");
		}else {
			try {
				fos = new FileOutputStream(p);
				bos = new BufferedOutputStream(fos);
				oos = new ObjectOutputStream(bos);
				oos.writeObject(dto);

				oos.close();
				bos.close();
				fos.close();

			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("회원가입 성공!");
		}
	}
	
	

}
