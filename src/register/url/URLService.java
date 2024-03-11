package register.url;

import java.nio.file.Paths;

public interface URLService {
	public String fxPath = "file:/"+(Paths.get("").toAbsolutePath().toString())+"/bin/";

}
