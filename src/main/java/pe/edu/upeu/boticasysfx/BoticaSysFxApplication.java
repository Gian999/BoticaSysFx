package pe.edu.upeu.boticasysfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BoticaSysFxApplication extends Application {

	private static ConfigurableApplicationContext configurableApplicationContext;
	private Parent parent;

	public static void main(String[] args) {
		launch(args);
	}
//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			// Obtén el bean de MainX del contexto de Spring
////			MainX mx = context.getBean(MainX.class);
////			mx.menu();
//
//			CategoriaCrud CCrud = context.getBean(CategoriaCrud.class);
//			CCrud.menu();
//		};
//	}

	@Override
	public void init() throws Exception {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(BoticaSysFxApplication.class);
		builder.application().setWebApplicationType(WebApplicationType.NONE);
		configurableApplicationContext = builder.run(getParameters().getRaw().toArray(new String[0]));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
		fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
		parent= fxmlLoader.load();
	}
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("SysAlmacen Spring Java-FX");
		stage.setResizable(false);
		stage.show();
	}
	@Override
	public void stop() throws Exception {
		configurableApplicationContext.close();
	}

}
