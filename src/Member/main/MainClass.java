package Member.main;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.ModuleLayer.Controller;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

import Member.controller.MemberController;
import Member.dto.MemberDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import register.url.URLService;

public class MainClass extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(getClass().getResource(""));//현재위치정보
		System.out.println("file:/"+(Paths.get("").toAbsolutePath().toString())+"/bin/register.fxml");
		URL url= new URL(URLService.fxPath+"register.fxml");

		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		//System.out.println("test");
		MemberController ctrl = loader.getController();
		ctrl.setRoot(root);


		MemberDTO dto = new MemberDTO();


		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();


		
	}
	public static void main(String[] args) {
		launch(args);
		
		try {
			Socket sock = new Socket("192.168.42.97",12345);
			Scanner input = new Scanner(System.in);

			OutputStream out = sock.getOutputStream();
			DataOutputStream os = new DataOutputStream(out);
			
			os.writeUTF("test");
			
			os.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}


