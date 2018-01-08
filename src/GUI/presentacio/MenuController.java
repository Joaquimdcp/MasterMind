package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import java.io.IOException;

public class MenuController {
    private ControllerPresentacio controller;

    @FXML
    private ImageView noSavedGame;

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
    }

    public void newGamePressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RoleFX.fxml"));
        Parent SceneParent = loader.load();
        Scene SceneToCharge = new Scene(SceneParent);

        controller = new ControllerPresentacio();
        RoleFXController roleFXController = loader.getController();
        roleFXController.setController(this.controller);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void loadGamePressed(ActionEvent actionEvent) throws IOException {
        if (this.controller.doesSavedExist(this.controller.getCurrentGame().getCurrentUser())) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("board.fxml"));
            Parent SceneParent = loader.load();
            Scene SceneToCharge = new Scene(SceneParent);

            BoardFXController roleFXController = loader.getController();
            roleFXController.setController(this.controller);

            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(SceneToCharge);
            window.show();
        } else {
            Image image = new Image("/GUI/assets/nosavedgame.png");
            noSavedGame.setImage(image);
        }
    }

    public void howToPlayPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HowToPlayFX.fxml"));
        Parent SceneParent = loader.load();
        Scene SceneToCharge = new Scene(SceneParent);

        HowToPlayFXController controller = loader.getController();
        controller.setController(this.controller);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void rankingPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RankingFX.fxml"));
        Parent SceneParent = loader.load();
        Scene SceneToCharge = new Scene(SceneParent);

        RankingFXController controller = loader.getController();
        controller.setController(this.controller);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void logOutPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LogIn.fxml"));
        Parent SceneParent = loader.load();
        Scene SceneToCharge = new Scene(SceneParent);

        LogInController controller = loader.getController();
        controller.setController(this.controller);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void exitPressed(ActionEvent actionEvent) {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
