package Class;

import java.net.URL;
import java.nio.file.Paths;

import Member.controller.MemberController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Class02 {
	public void modifyFx(Parent root) {
		System.out.println("모실행");
		Stage memberStage = (Stage)root.getScene().getWindow();
		try {
			URL url = new URL("file:/" + (Paths.get("").toAbsolutePath().toString())+"/bin/modify.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			System.out.println("로드 전 실행");
			root = loader.load();
			System.out.println("로드 후 실행");
			MemberController ctrl = loader.getController();
			ctrl.setRoot(root);
			
			Scene scene = new Scene(root);
			memberStage.setScene(scene);
			memberStage.show();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
