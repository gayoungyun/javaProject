package MemberInfo.main;

import java.net.URL;
import java.nio.file.Paths;

import Member.controller.MemberController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import register.url.URLService;

public class MainInfo extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(getClass().getResource(""));//현재위치정보
		System.out.println("file:/"+(Paths.get("").toAbsolutePath().toString())+"/bin/check.fxml");
		URL url= new URL(URLService.fxPath+"check.fxml");

		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		System.out.println("test");
		MemberController ctrl = loader.getController();
		ctrl.setRoot(root);

		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();

	}
	public static void main(String[] args) {
		launch(args);

	}

}


