package GUI.presentacio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader((getClass().getResource("LogIn.fxml")));
        AnchorPane flowPane = loader.load();

        LogInController controller = loader.getController();
        controller.setController(new ControllerPresentacio());

        primaryStage.setTitle("Mastermind");
        Scene SceneToCharge = new Scene(flowPane, 800, 600);
        primaryStage.setScene(SceneToCharge);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
